(ns danbunearo.db-controller
  (:require [reagent.core :as r :refer [atom]]
            [danbunearo.db-model :refer [model]]
            [vr.pi :as pi :refer [swapm!]]
            [vr.rest.rest :as REST])
  (:require-macros
    [cljs.core.async.macros :refer [go]]
    [vr.macros :refer [safe gosafe <? ]]
    )
  )




(defn init []
;;   (js/console.log (js/JSON.stringify (clj->js (:paintings @model))))
  (safe
    (-> @model
        (assoc :title "Dan Bunea")
        (swapm! model))))

(defn change-path [new-path]
  (safe
    (-> @model
        (assoc-in [:context :old-path] (get-in @model [:context :path] ))
        (assoc-in [:context :path] new-path)
        (swapm! model))))


(defn select-painting [path-to-painting]
  (safe
    (-> @model
        (assoc-in [:selected :painting] path-to-painting)
        (swapm! model))))

(defn hide-tooltip []
  (safe
    (-> @model
        (assoc-in [:context :show-tooltip] false)
        (swapm! model))))


(comment
(select-painting nil)
  )

