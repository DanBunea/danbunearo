(ns danbunearo.core
    (:require [reagent.core :as reagent :refer [atom]]
              [danbunearo.db-model :refer [model]]
              [danbunearo.db-controller :as controller]
              [danbunearo.db-views :as views]
              ))

(enable-console-print!)

(println "This text is printed from src/danbunearo/core.cljs. Go ahead and edit it and see reloading in action.")

;; define your app data so that it doesn't get over-written on reload



(defn hello-world []
  [views/screen-component @model])

(reagent/render-component [hello-world]
                          (. js/document (getElementById "app")))

(defonce init
  (do
    (print "initializing..." )
    (controller/init )
    (print "initialized")))


(defn on-js-reload []
  ;; optionally touch your app-state to force rerendering depending on
  ;; your application
  ;; (swap! app-state update-in [:__figwheel_counter] inc)
)
