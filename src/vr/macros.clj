(ns vr.macros
  (:require [clojure.string :as str]))

(defmacro safe [& body]
  (let [e (gensym "e-")]
    `(try ~@body
      (catch :default ~e
        (vr.pi/add-error ~e)))))


(defmacro gosafe [& body]
  (let [e (gensym "e-")
        ex (symbol "ex")]
    `(cljs.core.async.macros/go
      (try ~@body
        (catch :default ~e
          (let [~ex (ex-data ~e)]
            (vr.pi/error :500 ~ex ~e)
            (.log js/console 500 ~e)
            (vr.pi/add-errors ~ex)
            ~e))))))



(defmacro <? [& body]
  `(vr.pi/throw-err
     (cljs.core.async/<! ~@body)))



(defn make-form [thread-fn [previous current]]
  (let [[symbol _] previous
        [current-symbol current-expr] current
        x (gensym)]
    [current-symbol `(let [~x ~(thread-fn current-expr symbol)]
                       (if (satisfies? cljs.core.async.impl.protocols/Channel ~x)
                         (vr.macros/<? ~x)
                         ~x))]))

(defn thread-first [expr symbol]
  (if (seq? expr)
    `(~(first expr) ~symbol ~@(rest expr))
    `(~expr ~symbol)))

(defn thread-last [expr symbol]
  (if (seq? expr)
    `(~@expr ~symbol)
    `(~expr ~symbol)))


(defn- -go-thread [thread-fn body]
  (let [first-sym (first body)
        forms (->> (map vector (conj (repeatedly (count (rest body)) gensym) first-sym) body)
                 (partition 2 1)
                 (map thread-fn))
        result (first (last forms))
        actual-forms (reduce concat [] forms)]
    (if (= 1 (count body))
      (let [let-body (first body)
            result (gensym)]
        `(vr.macros/gosafe
           (let [~result ~let-body]
              (if (satisfies? cljs.core.async.impl.protocols/Channel ~result)
                (vr.macros/<? ~result)
                ~result))))
      `(vr.macros/gosafe
          (let [~@actual-forms]
            ~result)))))

(defmacro go-> "

  like '->' but if anything is a chan it takes from that channel and passes the result onward
      Ex:
      (go-> x
            (+ 1))

      when x is 1 then return a channel with the value 2
      when x is a channel that has the value 1 it takes from it and return a chan with the value 2

"
  [& body]
  (-go-thread (partial make-form thread-first) body))


(defmacro go->> "
  like '->>' but if anything is a chan it takes from that channel and passes the result onward
          Ex:
          (go->> x
                (+ 1))

          when x is 1 then return a channel with the value 2
          when x is a channel that has the value 1 it takes from it and return a chan with the value 2
" [& body]
  (-go-thread (partial make-form thread-last) body))


(defmacro t-> [model & body]
  `(go-> (deref ~model)
      ~@body
      (vr.pi/swapm! ~model)))


