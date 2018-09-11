(ns vr.rest.rest
  (:require
   [ajax.core :as aj :refer [GET POST DELETE ajax-request json-request-format json-response-format detect-response-format]]
   [cljs.core.async :refer [chan <! >! put! take!]]
   [vr.pi :as pi]
   )
  (:require-macros [cljs.core.async.macros :refer [go]])
  )



(defn ^:export detect-internet-explorer []
  (let [
        ua (.-userAgent (.-navigator js/window))
        ]
    (cond
     (not= -1 (.indexOf ua "MSIE ")) true
     (not= -1 (.indexOf ua "Trident/")) true
     (not= -1 (.indexOf ua "Edge/")) true
     :else false
     )
    )
  )

(defn ^:export cache-check [url]
  (let
       [
        sign (if (not= -1 (.indexOf url "?")) "&" "?")
        random_string (str "random=" (int (rand 10000)))
        is_ie (detect-internet-explorer)
        ]
    (if (true? is_ie)
      (str url sign random_string)
      url
      )
    )
  )

(defn GET<
  ([url]
   (GET< url (fn [resp] ((last resp) :data)))
   )
  ([url from-response]
  (pi/info "GET" url)
  (let [ch (chan)]
    (ajax-request
     {:uri (cache-check url)
      :method :get
      :handler (fn [resp]
                 (put! ch (from-response resp)))
      :response-format (json-response-format {:keywords? true})})
    ch)))



(defn channel-reponse [ch]
  (fn get-data-from-response  [resp]
    (let [[ok response] resp
          r ((last resp) :data)]
      ;;               errors ((last resp) :errors)]
      ;;               (pi/info ok)
      ;;               (pi/info response)
      (cond
       (true? ok) (put! ch r)

       :else
       (let [errors (get-in response [:response :errors])]
         (print "errors" errors)
         (if (= (type errors) js/Error.)
           (put! ch (ex-info (pi/text "Operation cannot be performed")  [(pi/text "Operation cannot be performed")]))
           ;;else
           (put! ch  (ex-info (pi/text "Oops!")
                              (if (coll? errors)
                                (map
                                 #(if
                                    (nil? (:error %))
                                    %
                                    (:error %))
                                 errors)
                                ;;else
                                [errors]
                                )))



           ))

       ))))



(defn POST< [url json]
  (pi/info "POST" url json)
   (let [ch (chan)]
     (ajax-request
      {:uri (cache-check url)
       :method :post
       :params (clj->js json)
       :handler (channel-reponse ch)
       :format (json-request-format)
       :response-format (json-response-format {:keywords? true})})
     ch))





(defn DELETE< [url]
  (pi/info "DELETE" url)
   (let [
         ch (chan)]
     (ajax-request
      {:uri (cache-check url)
       :method "DELETE"
       :handler (channel-reponse ch)
       :format :raw
;;         :format (json-request-format)
       :response-format (json-response-format {:keywords? true})})
     ch))

