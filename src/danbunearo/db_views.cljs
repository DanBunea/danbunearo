(ns danbunearo.db-views
  (:require
    [danbunearo.db-controller :as controller]
    [reagent.core :as r :refer [atom]]

    [vr.pi :as pi]
    ))


(defn paiting-component [painting get-fn {:keys [width height]}]
    [:div
     {:style {
               :flex 1
               :color "white"
              :text-align "center"

              }
;;      :on-click #(controller/select-painting [:paintings (pi/keywordize (:position painting))])
      }
     [:div
      {
        :style {:height height}
        }
      [:svg
       {
         :width width
         :height height
         :preserve-aspect-ratio "xMaxYMin meet"
         }
       [:defs
        [:radialGradient
         {
           :id "gradient_filter"
           :cx "50%"
           :cy "50%"
           :r "50%"
           :fx "50%"
           :fy "50%"
           }
         [:stop {:offset "0%"
                 :style {:stop-color "rgb(255,153,0)"}}]
         [:stop {:offset "100%"
                 :style {:stop-color "rgb(0,0,0)"}}]
         ]
        [:filter
         {:id "shadow_filter"
          :x 0
          :y 0
          :width "200%"
          :height "200%"
          }
         [:feOffset
          {
            :dx 14
            :dy 14
            :in "SourceAlpha"
            :result "offOut"
            }]

         [:feGaussianBlur
          {
            :in "offOut"
            :std-deviation 4
            :result "blurOut"

            }]
         [:feBlend
          {
            :in "SourceGraphic"
            :in2 "blurOut"
            :mode "normal"

            }
          ]
         ]

        ]
       [:rect
        {
          :x 0
          :y 0
          :width width
          :height height
          :fill "url(#gradient_filter)"
          }]

       [:image
        {
          :filter "url(#shadow_filter)"
          :xlink-href (str "http://www.danbunea.ro/images/" (get-fn painting))
          :x (* 0.15 width)
          :y (* 0.15 height)
          :width (- width (* 0.30 width))
          :height (- height (* 0.30 height))
          }
        ]
       ]
      [:div
       {:style {
                 :margin-top (* -0.15 width)
                 :color "white"}}
       [:div
        {:style {:font-weight "bold"
                 :text-transform "uppercase"
                 }}
        (:title painting)]
       [:div (:description painting)]
       (when (not (empty? (:price painting)))
         [:div  (:price painting)

         (when (not (empty? (:etsy-link painting)))
           [:a {
                 :style {
                          :font-weight "bold"
                          :padding 10}
                 :href (:etsy-link painting)
                 :target "_blank"}
            "Buy now"
            ])
          ]
         )



       ]
      ]
     ]
  )


(defn gallery-component [state]
    (let [paintings (->> state
                         :paintings
                         vals
                         (filter #(not= 0 (:showOnHomepage %)))
                         (sort-by :position <))
          is-horizontal? (-> state :context :is-horizontal?)
          unit (-> state :context :square)
          width (-> state :context :width)
          height (-> state :context :height)
          ]



      [:div
       {:style
        {
          :font-size "14px"
          :margin-left (if is-horizontal? 200 0)
          :display "flex"
          :flex-direction (if is-horizontal? "row" "column")
          :width (* unit (if is-horizontal? (count paintings) 1))
          :height (* unit (if-not is-horizontal? (count paintings) 1))
          }}
       (when is-horizontal?
         [:img
          {:src "../images/right-thin-chevron.png"
           :style {:position "fixed"
                   :right 10
                   :top "50%"}
           :on-click #(js/animateScrollTo (+ (-> js/window .-scrollX) unit )  (clj->js {"horizontal" true}))
           }
          ])
       (for [v  paintings]
         ^{:key (str "painting_column_"  (:position v) )}
         [:div
          {
            :style {
                     :display "flex"
                     :flex-direction (if is-horizontal?  "column" "row")
                     }
            }
          ^{:key (str "painting_"  (:position v))}
          [paiting-component
           v
           #(:picture %)
           {:width unit :height unit :square unit :is-horizontal? (-> state :context :is-horizontal?)}

           ]
        (when (and is-horizontal? (not (empty? (:pictures v))))
         [:img
          {:src "../images/down-arrow.png"
           :style {:position "fixed"
                   :bottom 10
                   :left "50%"}
           :on-click #(js/animateScrollTo (+ (-> js/window .-scrollY) unit )  (clj->js {"horizontal" false}))
           }
          ])

          (for [pic (:pictures v)]
            ^{:key (str "painting_extra_" (clojure.string/replace pic " " ""))}
            [paiting-component
             v
             (fn [el] pic)
             {:width unit :height unit :square unit :is-horizontal? (-> state :context :is-horizontal?)}
             ]
            )
          ;;VIDEOS
          (for [video (:videos v)]
            ^{:key (str "video_"  video)}
            [:div {:style {:flex 1
                           :padding-top (int (/ (- unit (/ (* 315 unit) 560)) 2))}}
;;              [:iframe {

;;                         :width unit
;;                         :height (int (/ (* 315 unit) 560))
;;                         :src (str "https://www.youtube.com/embed/" (last (clojure.string/split video "=")) )
;;                         :frame-border 0
;;                         ;;                      :gesture "media"
;;                         :allow-full-screen true}]

             (let [small-unit (* 0.9 unit)]
            [:iframe {
                       :style {:margin-left (* 0.05 unit)}
                       :src video
                       :width small-unit
                       :height (int (/ (* 315 small-unit) 560))
                       :frame-border 0

                       :allow-full-screen true}])

             ])
          [:div
           {
             :style {
                      :width unit
                      :height 200}

             }]

          ])
       ])

)



(defn hamburger-menu [state on-click]
  [:button.c-hamburger.c-hamburger--htx
   {
     :class (if (:is-open? state) "" "is-active")
     :on-click (fn [ev]
                 (.preventDefault ev)
                 (on-click (not (:is-open? state))))}
   [:span "toggle menu"]
   ])

(defn share-component [state]
  [:div.share
   {:style {
             :justify-content "center"
             :flex-basis "50px"
             :background-color "rgba(121,121,121,0.5)"
             :padding 10
             :display "flex"
             }}
   (for [[text link] [["Facebook" "https://www.facebook.com/dan.bunea"] ["Youtube" "https://www.youtube.com/channel/UC39-QFlCl8yVELpyQHhFO4A"] ["Pinterest" "https://ro.pinterest.com/danbunea/"] ]]
     ^{:key (str "link_out_"  text)}
     [:a.desktop
      {:style {
                :margin 5

                }
       :href link
       :target "_blank"
       }
      [:img {
              :target "_blank"
              :width 48
              :src (str "/images/" text ".png")}]
      ])])

(defn full-menu [state]
  (let  [inner-state (r/atom {
                               :is-open? (not (-> state :context :is-horizontal?))
                               })]
    (fn [state]
      (let [is-horizontal? (-> state :context :is-horizontal?)]
        [:div.full_menu
         {:style {
                   :position "fixed"
                   :width (if is-horizontal? "250px" "100%")
                   :height (if (not (and (not is-horizontal?) (:is-open? @inner-state))) "100%" 140)
                   :display "flex"
                   :flex-direction "column"
                   :align-content "center"

                   }}



         [:div.icon
          {:style {
                    :display "flex"
                    :flex-direction (if is-horizontal? "column" "row")
                    :flex-basis "140px"
                    :justify-content "center"
                    :background-color "rgba(121,121,121,0.5)"
                    :align-items "center"
                    }}

          [:div.left
           {:style {
                     :display "flex"
                     :flex-direction (if is-horizontal? "column" "row")
                     :align-items "center"
                     :width "90%"
                     :padding-left (if is-horizontal? "0px" "30px")
                     }}
           [:div.me
            {:style {
                      :width 80
                      :height 80
                      :border-radius 40
                      :background "url(../images/meround.jpg) no-repeat"
                      :background-size "cover"
                      }}
            ]
           [:div.title
            {:style {
                      :display "flex"
                      :flex-direction "column"
                      :align-items "center"

                      }}
            [:div.me_name
             {:style {
                       :font-size "32px"
                       :font-weight "bold"
                       }}
             "Dan Bunea"]
            [:div.me_phrase
             "large living abstract paintings"]


            ]]
          (when (not is-horizontal?)
          [:div.bread
           {
             :style {:flex-basis 80
                     :width 80
                     :height 80}
             }
           [hamburger-menu @inner-state #(swap! inner-state assoc :is-open? %)]
           ])
          ]

         (when (not (and (not is-horizontal?) (:is-open? @inner-state)))
           [:div.sidemenu
            {:style {
                      :flex 1
                      :padding 10
                      :background-color "rgba(121,121,121,0.5)"
                      :visibility (if (and (not is-horizontal?) (:is-open? @inner-state))
                                    "hidden"
                                    "visible"
                                    )
                      :flex-basis 200

                      :display "flex"
                      :flex-direction "column"
                      :justify-content "center"
                      :align-items "center"
                      }}
            (for [[k v] (-> state :pages)]
              ^{:key (str "link_out_"  (name k))}

              [:div
               {
                 :style (merge {
                          :flex-basis 45
                          :text-transform "uppercase"
                          }
                               (if (not is-horizontal?)
                                {:font-size 28
                                 :font-weight "bold"
                                 }
                                {}))
                 :on-click #(do
                              (swap! inner-state assoc :is-open? true)
                              (controller/change-path [:pages k]))
                 }
               (if (not (:link v))
                 (:title v)
                 [:a {
                       :href (:link v)

                       } (:title v)])

               ])])

         (when (not (and (not is-horizontal?) (:is-open? @inner-state)))
          [share-component state])
         ]

        ))))








(defn page-component [state]
  [:div "hhfhdshfhdshfhdshf"]
  )


(defn iframe-component [state]
  (let [
         path (get-in state [:context :path])
         page (get-in state path)]
  [:iframe {
                       :style {:margin-left (if (-> state :context :is-horizontal?) 270 0)}
                       :src (:iframe-src page)
                       :width (if (-> state :context :is-horizontal?)
                                (- (get-in state [:context :width]) 290)
                                (get-in state [:context :width]))
                       :height (get-in state [:context :height])
                       :frame-border 0

                       :allow-full-screen true}]
  ))





(defn about-page-component [state]
  (let [about (get-in state [:pages :about])]
    [:div
     (if (-> state :context :is-horizontal?)
       {:style {
                 :margin-left "270px"
                 :padding "10px"}}
       {:style {
                 :padding "10px"
                 :padding-top "170px"
                 }}
       )
    (for [[k v] (:sections about)]
      ^{:key k}
      [:div
       [:h1 (:title v)]
       (for [p (:p v)]
         ^{:key p}
         [:p p])
       (for [{ text :text  href :href image :image} (:a v)]
         ^{:key text}
         [:p
         [:a {:href href
              :style {:font-weight "bold"}} text]
          [:br]
         [:a {:href href} href]
          (when image
            [:img {
                    :src (str "/images/" image)
                    :style {:width "100%"}
                    }])

          ])

       ]
    )]))

(defn tooltip-component []

  [:div.screen-tooltip
   {
     :on-click #(controller/hide-tooltip )

     }
   [:div.screen-tooltip-inside

    [:div "Scroll right (and left) to see more paintings. Scroll down for a painting's details"]

    [:div
     {
       :style {:font-weight "normal"
               :position "absolute"
               :bottom -140
               :right 20}
       } "Got it"]]])



(defn screen-component [state]
  (let [is-horizontal? (-> state :context :is-horizontal?)
        current-page (-> state
                         :context
                         :path
                         last
                         )
        pages  {
                 :gallery gallery-component
                 :about about-page-component
                 :newsletter iframe-component
                 }]
    [:div
     {:style {:color "white"
              :text-shadow "2px 2px #000"}}
     (when-not (-> state :selected :painting)
       [full-menu state])
     [(or (get pages current-page) page-component) state]
     (when (and
             (-> state :context :is-horizontal?)
             (-> state :context :show-tooltip))
       [tooltip-component ])
     ]))


