(ns danbunearo.db-model
  (:require [reagent.core :as r :refer [atom]]))


(def square (min (or (.-innerWidth js/window) 500) (or (.-innerHeight js/window) 500)))

(def initial-model {:title "Dan Bunea"
                    :context {
                               :path [:pages :gallery]
                               :is-mobile true
                               :width (.-innerWidth js/window)
                               :height (.-innerHeight js/window)
                               :square square
                               :is-horizontal? (> (.-innerWidth js/window) (.-innerHeight js/window))
                               :show-tooltip true
                               }

                    :paintings {
                                 :a5866 {
                                          :title "MEDITERRANEA #4",
                                          :description "170x96cm, mixed media on canvas",
                                          :picture "mediterranea 4 large living abstract paintings 1.jpg"
                                          :medium "mixed media",
                                          :year 2018,
                                          :videos ["https://player.vimeo.com/video/281167662"]
                                          :pictures [
                                                      ]

                                          :type "PaintingTemplate",
                                          :showOnHomepage 1,
                                          :position "a5866",
                                          :price "1700 EUR"
                                          :alias "enjoyadsafsfdsdssdfdcvdxxdvfdgiveupas",
                                          :id "sahfsfasdddfdxczzsdddscvzsdgsd",
                                          :etsy-link "https://www.etsy.com/listing/630607691/very-large-95x170cm-mediterranea-4?ref=listing-shop-header-0"
                                          }
                                 :a5867 {
                                          :title "MEDITERRANEA #5",
                                          :description "140x70cm, mixed media on wood panel, framed",
                                          :picture "mediterranea 5 140x70 1 full light.jpg"
                                          :medium "mixed media",
                                          :year 2018,
                                          :videos ["https://player.vimeo.com/video/278989544"]
                                          :pictures [
                                                     "mediterranea 5 140x70 5 wall night.jpg"
                                                      "mediterranea 5 140x70 3 detail.jpg"
                                                      "9237B9A2-5ECD-4472-BE29-2C072114404B.jpg"
                                                      "18AC54E5-E4C4-448D-BA72-3ED8AC4C4800.jpg"
                                                      ]

                                          :type "PaintingTemplate",
                                          :showOnHomepage 1,
                                          :position "a5867",
                                          :price "1200 EUR"
                                          :alias "enjoyadsadsdssdfdcvdxxdvfdgiveupas",
                                          :id "sahfsfasddxczzsdddscvzsdgsd",
                                          :etsy-link "https://www.etsy.com/listing/627055539/large-abstract-painting-by-dan-bunea?ref=shop_home_active_1"
                                          }
                                 :a5868 {
                                          :title "MEDITERRANEA #3 The miracle of a night",
                                          :description "100x100cm, mixed media on wood panel",
                                          :picture "Mediterranea 3 the miracle of a night dan bunea large living abstract paintings.jpeg"
                                          :medium "mixed media",
                                          :year 2018,
                                          :videos []
                                          :pictures [
                                                     "1F2C1E82-2DF0-4DB1-8611-B4240101ADB7.jpg"]

                                          :type "PaintingTemplate",
                                          :showOnHomepage 1,
                                          :position "a5868",
                                          :price "1000 EUR"
                                          :alias "enjoyadsadsdssdfdcvdxxdvfdgiveupas",
                                          :id "sahfsfasddxczzsdddscvzsdgsd",
                                          :etsy-link "https://www.etsy.com/listing/620076097/living-abstract-painting-by-dan-bunea?ref=shop_home_active_1"
                                          }
                                 :a5869 {
                                          :title "MEDITERRANEA #2",
                                          :description "80x80cm, mixed media on wood panel",
                                          :picture "mediteranea 2 large living abstract painting by dan bunea  500.jpg"
                                          :medium "mixed media",
                                          :year 2018,
                                          :videos []
                                          :pictures ["FE30FE13-C8A9-4E7E-B474-6947FBC38505.JPG"
                                                     ]

                                          :type "PaintingTemplate",
                                          :showOnHomepage 1,
                                          :position "a5869",
                                          :price "800 EUR"
                                          :alias "enjoyadsadssdfdcvdxxdvfdgiveupas",
                                          :id "sahfsfasddxzsdddscvzsdgsd",
                                          :etsy-link "https://www.etsy.com/listing/604882396/large-abstract-painting-by-dan-bunea?ref=listing-shop-header-0"
                                          }
                                 :a5870 {
                                          :title "MEDITERRANEA #1",
                                          :description "80x80cm, mixed media on wood panel",
                                          :picture "mediterranea 1 large living abstract painting by dan bunea  500.jpg"
                                          :medium "mixed media",
                                          :year 2018,
                                          :videos []
                                          :pictures [ "00959856-46C1-4B64-880E-DE47844D01FA.JPG"
                                                     ]

                                          :type "PaintingTemplate",
                                          :showOnHomepage 1,
                                          :position "a5870",
                                          :price "800 EUR"
                                          :alias "enjoyadsadssdfddxxdvfdgiveupas",
                                          :id "sahfsfasddxzsdddszsdgsd",
                                          :etsy-link "https://www.etsy.com/listing/618719139/large-abstract-painting-by-dan-bunea?ref=shop_home_active_2"
                                          }
                                 :a5871 {
                                          :title "SAMBA #12",
                                          :description "170x85cm, mixed media on canvas",
                                          :picture "samba 12 acrylics on canvas 170x85x4cm 1.jpg"
                                          :medium "mixed media",
                                          :year 2018,
                                          :videos ["https://player.vimeo.com/video/263554373"]
                                          :pictures ["samba 12 8.jpg"
                                                     "samba 12 acrylics on canvas 170x85x4cm7.jpg"
                                                     "samba 12 acrylics on canvas 170x85x4cm 9.jpg"
                                                     ]

                                          :type "PaintingTemplate",
                                          :showOnHomepage 1,
                                          :position "a5871",
                                          :price "1700 EUR"
                                          :alias "enjoyadsadssdfddxxdvfdgiveupas",
                                          :id "sahfsfasddxzsdddszsdgsd",
                                          :etsy-link "https://www.etsy.com/listing/605779917/very-large-85x170cm-samba-12-acrylics?ref=shop_home_active_1"
                                          }
                                 :a5872 {
                                          :title "SAMBA #8",
                                          :description "120x120cm, mixed media on wood panel",
                                          :picture "samba 8 large living abstract painting inspired by samba from brazil.jpg"
                                          :medium "mixed media",
                                          :year 2018,
                                          :videos ["https://player.vimeo.com/video/261624995"]
                                          :pictures ["F4AF07A0-B761-4DF8-B0AE-19718625B3ED.jpg" "large living abstract paintings dan bunea IMG_2164.jpg" "large living abstract paintings dan bunea IMG_2167.jpg" "large living abstract paintings dan bunea IMG_2358.jpg"]

                                          :type "PaintingTemplate",
                                          :showOnHomepage 1,
                                          :position "a5872",
                                          :price "1700 EUR"
                                          :alias "enjoyadsadssdfddxxddgiveupas",
                                          :id "sahfsfasddxzdszsdgsd",
                                          :etsy-link "https://www.etsy.com/listing/589010984/very-large-48x48in-or-120x120cm-samba-8?ref=shop_home_feat_3"
                                          }
                                 :a5873 {
                                          :title "SAMBA #1",
                                          :description "120x120cm, mixed media on wood panel",
                                          :picture "samba%201%20large%20living%20abstract%20painting%20by%20dan%20bunea%20rio%20de%20janeiro%20brazil.jpeg",
                                          :medium "mixed media",
                                          :year 2018,
                                          :videos ["https://www.youtube.com/watch?v=-Q-KgjRlhzo"]
                                          :pictures []

                                          :type "PaintingTemplate",
                                          :showOnHomepage 1,
                                          :position "a5873",
                                          :price ""
                                          :alias "enjoyadsadssdfddxxddgiveupas",
                                          :id "sahfsfasddxzdszsdgsd",
                                          }
                                 :a5874 {
                                          :title "THE BEAUTIFUL UNIVERSE X",
                                          :description "140x70cm, mixed media on wood panel",
                                          :picture "the beautiful universe x 140x70cm mixed media  bois.jpg",
                                          :medium "mixed media",
                                          :year 2017,
                                          :videos ["https://www.youtube.com/watch?v=beFwmhWq1N0"]
                                          :pictures []

                                          :type "PaintingTemplate",
                                          :showOnHomepage 1,
                                          :position "a5874",
                                          :price ""
                                          :alias "enjoyadsadsddxxddgiveupas",
                                          :id "sahfsfasddxzdssd",
                                          :etsy-link "https://www.etsy.com/listing/561964247/large-abstract-painting-by-dan-bunea-the?ref=shop_home_active_6"
                                          }

                                 :a5926 {:description "80x100x4cm or 32x40in", :medium "acrylics on canvas", :type "PaintingTemplate", :showOnHomepage 1, :title "ROMANCE", :year 2014, :alias "enjoy", :id "enjoy", :picture "romance.jpg",
                                         :position "a5926",
                                         :price "price on request"

                                         },
                                 :a6063 {:description "96x96cm", :medium "acrylics on canvas, framed", :type "PaintingTemplate", :showOnHomepage 1, :title "The beautiful universe 3", :year 2012, :alias "N107TBU3", :gallery "${ch.Gallery}", :id "dfb70991-87fa-4345-a8d5-fee1f93d053f", :picture "the beautiful universe 3-small.jpg", :position "a6063", :price "for sale in Galerie 30, Cannes, France"}, :a5910 {:description "150x100x4cm, mixed media on canvas", :medium "", :type "PaintingTemplate", :showOnHomepage 0, :title "FOLLOW YOUR HEART", :year 2014, :alias "enjoyadas", :id "enjoysadasf", :picture "follow your lrt.jpg", :position "a5910", :price ""}, :a5925 {:description "80x120x4cm or 32x48in", :medium "acrylics on canvas", :type "PaintingTemplate", :showOnHomepage 1, :title "COME FLY WITH ME", :year 2014, :alias "enjoy", :id "enjoy", :picture "come fly with me.jpg", :position "a5925", :price "price on request"}, :a5903 {:description "150x100x4cm, mixed media on canvas", :medium "", :type "PaintingTemplate", :showOnHomepage 1, :title "FOR UNBELIEVABLE NEW BEGINNINGS", :year 2014, :alias "enjoyadsddas", :id "sahfd", :picture "IMG_7355.jpg", :position "a5903", :price ""}, :a5902 {:description "150x100x4cm, gold/mixed media on canvas", :medium "", :type "PaintingTemplate", :showOnHomepage 1, :title "RISE AGAIN", :year 2014, :alias "enjoyadsddas", :id "sahfd", :picture "rise again.jpg", :position "a5902", :price ""}, :a5927 {:description "70x100x4cm or 28x40in", :medium "acrylics on canvas", :type "PaintingTemplate", :showOnHomepage 1, :title "SEA BREEZE", :year 2013, :alias "enjoy", :id "enjoy", :picture "sea breeze.jpg", :position "a5927", :price "price on request"}, :a5915 {:description "100x120x4cm, mixed media on canvas", :medium "", :type "PaintingTemplate", :showOnHomepage 0, :title "FLY WITH THE WIND", :year 2014, :alias "enjoyadas", :id "enjoysadasf", :picture "m2.jpg", :position "a5915", :price ""}, :a5880 {:description "80x80cm, mixed media on wood panel", :medium "", :type "PaintingTemplate", :showOnHomepage 1, :title "", :year 2017, :alias "enjoyadsadsxxddgiveupas", :id "sahfsfasssd", :picture "2017-0005.jpg", :position "a5880", :price ""}, :a5891 {:description "150x100x4cm, mixed media on canvas", :medium "", :type "PaintingTemplate", :showOnHomepage 1, :title "Joie de vivre", :year 2016, :alias "dfsddff", :id "sahfssd", :picture "joie de vivre.jpeg", :position "a5891", :price ""}, :a5898 {:description "240x120x4cm, mixed media on canvas", :medium "", :type "PaintingTemplate", :showOnHomepage 1, :title "EMOTIONAL REVOLUTION #3", :year 2015, :alias "enjoyadsxxddas", :id "sahfssd", :picture "big home.jpg", :position "a5898", :price ""}, :a5918 {:description "80x120x4 or 32x48x2.5", :medium "acrylics on canvas", :type "PaintingTemplate", :showOnHomepage 1, :title "THE ENCOUNTER", :year 2014, :alias "enjoyadas", :id "enjoysadasf", :picture "14041.jpg", :position "a5918", :price "price on request"}, :a5893 {:description "100x100x6cm, mixed media on canvas", :medium "", :type "PaintingTemplate", :showOnHomepage 1, :title "Magellan", :year 2016, :alias "enjoyadsxxddgiveupas", :id "sahfssd", :picture "16-02.jpg", :position "a5893", :price ""}, :a5995 {:description "80x120cm or 32x48in", :medium "acrylics on canvas, dypthyc", :type "PaintingTemplate", :showOnHomepage 1, :title "THE HERO IN YOU", :year 2013, :alias "TheHeroInYou", :id "theheroinyou", :picture "the hero in you - small.jpg", :position "a5995", :price "price on request"}, :a6003 {:description "80x80cm", :medium "acrylics on canvas", :type "PaintingTemplate", :showOnHomepage 0, :title "Sudden joy", :year 2013, :alias "No1SuddenJoy", :id "medium2", :picture "Screen Shot 2013-03-21 at 7.16.17 PM.jpg", :position "a6003", :price "price on request"}, :a5917 {:description "80x120x4 or 32x48x2.5", :medium "acrylics on canvas", :type "PaintingTemplate", :showOnHomepage 0, :title "MISTERIOUS NIGHTS 2", :year 2014, :alias "enjoyadas", :id "enjoysadasf", :picture "mn2.jpg", :position "a5917", :price "price on request"}, :a5922 {:description "80x120x4 or 32x48x2.5", :medium "acrylics on canvas", :type "PaintingTemplate", :showOnHomepage 0, :title "THE FAIRIES", :year 2014, :alias "enjoyadas", :id "enjoysadasf", :picture "14045.jpg", :position "a5922", :price "price on request"}, :a5882 {:description "100x100x6cm, mixed media on canvas", :medium "", :type "PaintingTemplate", :showOnHomepage 1, :title "", :year 2017, :alias "enjoyadsadsxxddgiveupas", :id "sahfsfasssd", :picture "2017-0003.jpg", :position "a5882", :price ""}, :a5936 {:description "70x100cm or 28x40in", :medium "acrylics on canvas, dypthyc", :type "PaintingTemplate", :showOnHomepage 1, :title "ENJOY THE FREEDOM", :year 2013, :alias "enjoy", :id "enjoy", :picture "ENJOY THE FREEDOM.jpg", :position "a5936", :price "price on request"}, :a6061 {:description "70x100cm", :medium "acrylics on canvas", :type "PaintingTemplate", :showOnHomepage 1, :title "CONQUERED BY LOVE", :year 2012, :alias "N110ConqueredByLove", :gallery "${ch.Gallery}", :id "d26159f4-7e8c-4de4-a2a4-899fd43e24a6", :picture "conquered by love - small.jpg", :position "a6061", :price "for sale"}, :a5890 {:description "150x100x4cm, mixed media on canvas", :medium "", :type "PaintingTemplate", :showOnHomepage 0, :title "Jungle Beauty", :year 2016, :alias "enjoyadfgdfsxxddgiveupas", :id "sahdsffssd", :picture "jungle beauty.jpeg", :position "a5890", :price ""}, :a5895 {:description "100x100x6cm, mixed media on canvas", :medium "", :type "PaintingTemplate", :showOnHomepage 1, :title "Curiosity", :year 2015, :alias "enjoyadsxxddgiveupas", :id "sahfssd", :picture "16-04.jpg", :position "a5895", :price ""}, :a5935 {:description "200x200cm or 80x80in", :medium "acrylics/silver on canvas", :type "PaintingTemplate", :showOnHomepage 1, :title "GALAXY BEYOND COLOR", :year 2013, :alias "enjoy", :id "enjoy", :picture "galaxy.jpg", :position "a5935", :price "price on request"}, :a5897 {:description "160x60x4cm, mixed media on canvas", :medium "", :type "PaintingTemplate", :showOnHomepage 1, :title "NO BLACK AND WHITE", :year 2015, :alias "enjoyadsxxddas", :id "sahfssd", :picture "no black.jpg", :position "a5897", :price ""}, :a6095 {:description "80x80cm", :medium "acrylics on stretched canvas, framed", :type "PaintingTemplate", :showOnHomepage 1, :title "On a day like this", :year 2011, :alias "No78OnADayLikeThis", :gallery "${ch.Gallery}", :id "4e0732a8-0e78-4f9d-983b-83142c757a7d", :picture "on a day like this-simple.jpg", :position "a6095", :price "price on request"}, :a5906 {:description "120x100x4cm, acrylics on canvas", :medium "", :type "PaintingTemplate", :showOnHomepage 1, :title "COMMING HOME", :year 2014, :alias "enjoyadddas", :id "enjoysadaddssd", :picture "comming home.jpg", :position "a5906", :price ""}, :a5933 {:description "70x100x4cm or 28x40in", :medium "acrylics/silver on canvas", :type "PaintingTemplate", :showOnHomepage 1, :title "COLLISION", :year 2013, :alias "enjoy", :id "enjoy", :picture "20.2.jpg", :position "a5933", :price "price on request"}, :a5932 {:description "70x100x4cm or 28x40in", :medium "acrylics/silver on canvas", :type "PaintingTemplate", :showOnHomepage 0, :title "SUNSHINE IN MY SOUL", :year 2013, :alias "enjoy", :id "enjoy", :picture "20.4.jpg", :position "a5932", :price "price on request"}, :a6076 {:description "70x80cm", :medium "acrylics canvas", :type "PaintingTemplate", :showOnHomepage 0, :title "INCREDIBLE FUN", :year 2011, :alias "N102IncredibleFun", :gallery "${ch.Gallery}", :id "095bc683-ac6c-4b0f-a3d3-5bc3a979c690", :picture "incredible fun.jpg", :position "a6076", :price "for sale"}, :a5914 {:description "100x120x4cm, mixed media on canvas", :medium "", :type "PaintingTemplate", :showOnHomepage 1, :title "PASSIONATE LOVE", :year 2014, :alias "enjoyadas", :id "enjoysadasf", :picture "m3.jpg", :position "a5914", :price ""}, :a5930 {:description "70x100x4cm or 28x40in", :medium "acrylics on canvas", :type "PaintingTemplate", :showOnHomepage 1, :title "SHE LOVED IT!", :year 2013, :alias "enjoy", :id "enjoy", :picture "20.3.jpg", :position "a5930", :price "price on request"}, :a6064 {:description "50x90cm", :medium "acrylics on canvas", :type "PaintingTemplate", :showOnHomepage 0, :title "AFTER THE STORM", :year 2012, :alias "N106AfterTheStorm", :gallery "${ch.Gallery}", :id "ec2867cc-6174-4aca-b5eb-b52d701c12a4", :picture "after the storm small.jpg", :position "a6064", :price "price on request"}, :a5919 {:description "80x120x4 or 32x48x2.5", :medium "acrylics on canvas", :type "PaintingTemplate", :showOnHomepage 1, :title "DREAMING BIG", :year 2014, :alias "enjoyadas", :id "enjoysadasf", :picture "14043.jpg", :position "a5919", :price "price on request"}, :a5920 {:description "80x120x4 or 32x48x2.5", :medium "acrylics on canvas", :type "PaintingTemplate", :showOnHomepage 0, :title "GOLDEN DAYS", :year 2014, :alias "enjoyadas", :id "enjoysadasf", :picture "14044.jpg", :position "a5920", :price "price on request"}, :a5996 {:description "150x150cm", :medium "acrylics on canvas", :type "PaintingTemplate", :showOnHomepage 0, :title "The beautiful universe 4", :year 2013, :alias "BU4", :gallery "${ch.Gallery}", :id "55e1438c-e55c-4eff-a816-sdg", :picture "the beautiful universe 4.jpg", :position "a5996", :price "for sale"}, :a5909 {:description "150x100x4cm, mixed media on canvas", :medium "", :type "PaintingTemplate", :showOnHomepage 1, :title "ACCOMPLISHMENT", :year 2014, :alias "enjoyadas", :id "enjoysadasf", :picture "accomplishment.jpg", :position "a5909", :price ""},
                                 :a5904 {:description "70x70x4cm, acrylics on canvas", :medium "", :type "PaintingTemplate", :showOnHomepage 1, :title "CAUSE I'M FEELING GOOD", :year 2014, :alias "enjoyadddas", :id "sahfd", :picture "cba.jpg"
                                         :position "a5904", :price ""}, :a5999 {:description "150x150cm or 60x60in", :medium "acrylics/gold on canvas", :type "PaintingTemplate", :showOnHomepage 0, :title "FOR THE BRAVE", :year 2013, :alias "ForTheBrave", :id "big", :picture "for the brave small.jpg", :position "a5999", :price "price on request"},
                                 :a5937 {:description "80x120cm or 32x48in", :medium "acrylics on canvas, dypthyc", :type "PaintingTemplate", :showOnHomepage 1, :title "SOMETIMES I WONDER", :year 2013, :alias "sometimes", :id "sometimes", :picture "SOMETIMES I WONDER.jpg", :position "a5937", :price "price on request"}, :a5894 {:description "100x100x6cm, mixed media on canvas", :medium "", :type "PaintingTemplate", :showOnHomepage 1, :title "Sauvage", :year 2016, :alias "enjoyadsxxddgiveupas", :id "sahfssd", :picture "16-03.jpg", :position "a5894", :price ""}, :a5896 {:description "150x100x4cm, mixed media on canvas", :medium "", :type "PaintingTemplate", :showOnHomepage 1, :title "NEVER GIVE UP", :year 2015, :alias "enjoyadsxxddgiveupas", :id "sahfssd", :picture "never give up.jpg", :position "a5896", :price ""}, :ac89 {:description "70x100cm", :medium "acrylics on hard paper, framed", :type "PaintingTemplate", :showOnHomepage 0, :title "Enjoyable takeover", :year 2010, :alias "No51EnjoyableTakeover", :gallery "${ch.Gallery}", :id "a93fa55b-303f-46d7-b002-238b67430862", :picture "Enjoyable takeover.jpg", :position "ac89", :price "price on request"}, :a5892 {:description "100x100x6cm, mixed media on canvas", :medium "", :type "PaintingTemplate", :showOnHomepage 1, :title "Come with me", :year 2016, :alias "enjoyadsxxddgiveupas", :id "sahfssd", :picture "16-01.jpg", :position "a5892", :price ""}, :a5905 {:description "70x70x4cm, acrylics on canvas", :medium "", :type "PaintingTemplate", :showOnHomepage 0, :title "RELAXING", :year 2014, :alias "enjoyadddas", :id "sdfgads", :picture "abc.jpg", :position "a5905", :price ""}, :a5997 {:description "150x150cm", :medium "acrylics on canvas", :type "PaintingTemplate", :showOnHomepage 0, :title "Joining the divinity", :year 2013, :alias "Div", :gallery "${ch.Gallery}", :id "55e1438c-e55c-4eff-a816-sadfga", :picture "big blue.jpg", :position "a5997", :price "for sale"}, :a6082 {:description "70x100cm", :medium "acrylics on cardboard, framed", :type "PaintingTemplate", :showOnHomepage 1, :title "I BELIEVE", :year 2011, :alias "No98IBelieve", :gallery "${ch.Gallery}", :id "6ec5ee5e-214d-4fd2-91b8-1ab2ebe6cc41", :picture "2.jpg", :position "a6082", :price "price on request"}, :a5908 {:description "150x100x4cm, mixed media on canvas", :medium "", :type "PaintingTemplate", :showOnHomepage 1, :title "BREAKING THE MONOTONY", :year 2014, :alias "enjoyadas", :id "enjoysadassd", :picture "monotony.jpg", :position "a5908", :price ""}, :a5939 {:description "80x120cm or 32x48in", :medium "acrylics on canvas, dypthyc", :type "PaintingTemplate", :showOnHomepage 0, :title "DEEP SPACE", :year 2013, :alias "DeepSpace", :id "deepspace", :picture "deep space.jpg", :position "a5939", :price "price on request"},


                                 , :a5875 {:description "100x100cm, mixed media on canvas", :medium "mixed media", :type "PaintingTemplate", :showOnHomepage 1, :title "RARITIES", :year 2017, :alias "enjoyadsadsxxddgiveupas", :id "sahfsfasxzdssd", :picture "Large abstract painting RARITIES acrylics mixed media on canvas.jpg", :position "a5875", :price ""}, :a6091 {:description "70x100cm", :medium "acrylics on cardboard, framed", :type "PaintingTemplate", :showOnHomepage 0, :title "The spirit of the champions", :year 2011, :alias "No79TheSpiritOfTheChampions", :gallery "${ch.Gallery}", :id "93fb4500-d38a-4d47-a344-5a91b1f64a18", :picture "the spirit of ch - small.JPG", :position "a6091", :price ""}, :a5883 {:description "170x80x4cm, mixed media on canvas", :medium "", :type "PaintingTemplate", :showOnHomepage 1, :title "Obsession", :year 2017, :alias "enjoyadsadsxxddgiveupas", :id "sahfsfasssd", :picture "2017-0002.jpg", :position "a5883", :price ""}, :a5878 {:description "120x120cm, mixed media on wood panel", :medium "", :type "PaintingTemplate", :showOnHomepage 1, :title "", :year 2017, :alias "enjoyadsadsxxddgiveupas", :id "sahfsfasssd", :picture "2017-0007.jpg", :position "a5878", :price ""}, :a6085 {:description "80x80cm", :medium "acrylics canvas", :type "PaintingTemplate", :showOnHomepage 0, :title "Hard gained confidence", :year 2011, :alias "No91HardGained", :gallery "${ch.Gallery}", :id "fb8dbb0b-8671-4d5b-9046-b213588faac0", :picture "hard gained confidence.jpg", :position "a6085", :price ""}, :a5907 {:description "70x100x4cm, acrylics on canvas", :medium "", :type "PaintingTemplate", :showOnHomepage 1, :title "SUMMERTIME", :year 2014, :alias "enjoyadas", :id "enjoysadassd", :picture "summertime.jpg", :position "a5907", :price ""}, :a5924 {:description "150x150x4cm or 60x60in", :medium "acrylics on canvas", :type "PaintingTemplate", :showOnHomepage 1, :title "SPACE ODISEY", :year 2014, :alias "enjoy", :id "enjoy", :picture "space odisey.jpg", :position "a5924", :price "price on request"}, :a5916 {:description "80x120x4cm, mixed media on canvas", :medium "", :type "PaintingTemplate", :showOnHomepage 1, :title "SOMEDAY", :year 2014, :alias "enjoyadas", :id "enjoysadasf", :picture "m1.jpg", :position "a5916", :price ""}, :a6094 {:description "70x100cm", :medium "acrylics on cardboard, framed", :type "PaintingTemplate", :showOnHomepage 1, :title "The showwill go on", :year 2011, :alias "No79TheShow", :gallery "${ch.Gallery}", :id "cd4465d6-c8e1-49aa-b7ac-93256c5123fc", :picture "the show will go on small.JPG", :position "a6094", :price "price on request"}, :lz {:description "25x25 inch, no transport included", :medium "acrylic and oil on canvas", :type "PaintingTemplate", :showOnHomepage 0, :title "the triumph of light", :year 2008, :alias "No9", :gallery "${ch.Gallery}", :id "1b855110-cf87-411c-ad65-b85f79607db9", :picture "IMG_0671.JPG", :position "lz", :price "price on demand"}, :a5899 {:description "150x100x4cm, mixed media on canvas", :medium "", :type "PaintingTemplate", :showOnHomepage 1, :title "EMOTIONAL REVOLUTION #2", :year 2015, :alias "enjoyadsxxddas", :id "sahfssd", :picture "db_0001.JPG", :position "a5899", :price ""}, :a5885 {:description "170x80x4cm, mixed media on canvas", :medium "", :type "PaintingTemplate", :showOnHomepage 1, :title "Obsession", :year 2016, :alias "enjoyadsadsxxddgiveupas", :id "sahfsfasssd", :picture "obsession-1.jpg", :position "a5885", :price ""}, :a5900 {:description "150x100x4cm, mixed media on canvas", :medium "", :type "PaintingTemplate", :showOnHomepage 1, :title "FOR UNBELIEVABLE NEW BEGINNINGS #2", :year 2015, :alias "enjoyadsxxddas", :id "sahfssd", :picture "bf13.jpg", :position "a5900", :price ""}, :a5879 {:description "80x80cm, mixed media on wood panel", :medium "", :type "PaintingTemplate", :showOnHomepage 1, :title "", :year 2017, :alias "enjoyadsadsxxddgiveupas", :id "sahfsfasssd", :picture "2017-0006.jpg", :position "a5879", :price ""}, :a5889 {:description "60x60cm, mixed media on canvas", :medium "", :type "PaintingTemplate", :showOnHomepage 0, :title "Lost in dreams ", :year 2016, :alias "enjoyadsxxddgiveupas", :id "sahfssd", :picture "blue2016-1.jpg", :position "a5889", :price ""}, :ac90 {:description "70*100cm", :medium "acrylics on paper, framed", :type "PaintingTemplate", :showOnHomepage 1, :title "Stay young, stay dynamic!", :year 2010, :alias "No50StayYoungStayDynamic", :gallery "${ch.Gallery}", :id "bd5aa673-b7f5-4997-886e-444e40c21a43", :picture "Stay young stay dynamic.jpg", :position "ac90", :price "price on demand"}, :a5884 {:description "100x100x6cm, mixed media on canvas", :medium "", :type "PaintingTemplate", :showOnHomepage 1, :title "", :year 2016, :alias "enjoyadsadsxxddgiveupas", :id "sahfsfasssd", :picture "2017-0001.jpg", :position "a5884", :price ""}, :a5888 {:description "100x100x6cm, mixed media on canvas", :medium "", :type "PaintingTemplate", :showOnHomepage 1, :title "The call", :year 2016, :alias "enjoyadsxxddgiveupas", :id "sahfssd", :picture "the call.jpg", :position "a5888", :price ""}, :a6075 {:description "80x80cm", :medium "acrylics canvas", :type "PaintingTemplate", :showOnHomepage 0, :title "CHAOTIC MARVELS", :year 2011, :alias "N101ChaoticMarvels", :gallery "${ch.Gallery}", :id "487c3144-1efb-48dc-b70e-8ea9ab3161aa", :picture "chaotic marvels - small.jpg", :position "a6075", :price "for sale"}, :a5923 {:description "120x240cm or 48x96in", :medium "acrylics on canvas", :type "PaintingTemplate", :showOnHomepage 1, :title "EMOTIONAL BIG BANG", :year 2014, :alias "enjoyadas", :id "enjoysadasf", :picture "furDenisse.jpg", :position "a5923", :price "price on request"}, :a5881 {:description "80x80cm, mixed media on wood panel", :medium "", :type "PaintingTemplate", :showOnHomepage 1, :title "", :year 2017, :alias "enjoyadsadsxxddgiveupas", :id "sahfsfasssd", :picture "2017-0004.jpg", :position "a5881", :price ""}, :ac78 {:description "70*100cm", :medium "acrylics on wood, framed", :type "PaintingTemplate", :showOnHomepage 1, :title "Hoping in the new beginning", :year 2010, :alias "No64HopingInTheNewBeggining", :gallery "${ch.Gallery}", :id "5c2abf55-7ffe-42ed-a5aa-eb1ca20732e1", :picture "f5.jpg", :position "ac78", :price "price on demand"}, :a6090 {:description "80x80cm", :medium "acrylics canvas", :type "PaintingTemplate", :showOnHomepage 1, :title "The mediteranean clash", :year 2011, :alias "No84MediteraneanClash", :gallery "${ch.Gallery}", :id "5c930a5a-acb9-4609-9dd4-739d06923c46", :picture "the mediteranean clash.JPG", :position "a6090", :price ""},
                                 :a5886 {:description "140x70x4cm, mixed media on canvas"
                                        :medium "", :type "PaintingTemplate", :showOnHomepage 1, :title "Summer dreaming", :year 2016, :alias "enjoyadsxxddgiveupas", :id "sahfssd", :picture "summer dreaming.jpg", :position "a5886", :price ""}, :a5876 {:description "120x120cm, mixed media on wood panel", :medium "", :type "PaintingTemplate", :showOnHomepage 1, :title "", :year 2017, :alias "enjoyadsadsxxddgiveupas", :id "sahfsfasssd", :picture "2017-0009.jpg", :position "a5876", :price ""}, :a5913 {:description "100x120x4cm, mixed media on canvas", :medium "", :type "PaintingTemplate", :showOnHomepage 1, :title "GORGEOUS BEAST", :year 2014, :alias "enjoyadas", :id "enjoysadasf", :picture "power2.jpg", :position "a5913", :price ""}, :ad0 {:description "70x100cm", :medium "acrylics on paper", :type "PaintingTemplate", :showOnHomepage 1, :title "Morning wonder", :year 2010, :alias "No42MorningWonder", :gallery "${ch.Gallery}", :id "d7efc518-2138-4b6b-9549-0e7db470701f", :picture "morningWonder2.jpg", :position "ad0", :price "price on demand"}, :a6002 {:description "80x80cm", :medium "acrylics on canvas", :type "PaintingTemplate", :showOnHomepage 1, :title "Restless", :year 2013, :alias "No1Restless", :id "medium1", :picture "600964_10151467218262318_1383140414_n.jpg", :position "a6002", :price "price on request"}, :a5877 {:description "120x120cm, mixed media on wood panel", :medium "", :type "PaintingTemplate", :showOnHomepage 1, :title "", :year 2017, :alias "enjoyadsadsxxddgiveupas", :id "sahfsfasssd", :picture "2017-0008.jpg", :position "a5877", :price ""}, :a5912 {:description "150x100x4cm, mixed media on canvas", :medium "", :type "PaintingTemplate", :showOnHomepage 1, :title "GLORIOUS", :year 2014, :alias "enjoyadas", :id "enjoysadasf", :picture "gloriouos.jpg", :position "a5912", :price ""}, :a5911 {:description "150x100x4cm, mixed media on canvas", :medium "", :type "PaintingTemplate", :showOnHomepage 0, :title "PARADISE", :year 2014, :alias "enjoyadas", :id "enjoysadasf", :picture "paradise.jpg", :position "a5911", :price ""}, :a6067 {:description "70x100cm", :medium "acrylics, gold on canvas", :type "PaintingTemplate", :showOnHomepage 0, :title "I'M FEELING LUCKY", :year 2012, :alias "N103ImFeelingLucky", :gallery "${ch.Gallery}", :id "748c6dc3-5715-458e-9f7b-4f67592162cb", :picture "Im feeling lucky.jpg", :position "a6067", :price "price on request"}, :a5901 {:description "150x100x4cm, mixed media on canvas", :medium "", :type "PaintingTemplate", :showOnHomepage 1, :title "BECAUSE YOU DESERVE COLOR", :year 2015, :alias "enjoyadsxxddas", :id "sahfssd", :picture "db_0002.jpg", :position "a5901", :price ""
                                        }

                                 }
                    :pages {:gallery {:title "Home"}
                            :about {:title "About Me"
                                    :sections
                                    {
                                      :danbunea {
                                                  :title "DAN BUNEA"
                                                  :p [

                                                       "My name is Dan Bunea, \nand I love life,colour,people,beauty,journeys, new discoveries,learning. Painting is for me, my journey,my learning,my discoveries,my encounter with beauty, my encounter with the universe. \nMy painting is full of energy, of hope, of passion, of joy of life. I want to take the watcher out of his day to day mood, and give him/her an excape from reality even for a split second."
                                                       "I am inspired by images from the universe, by great lanscapes, by flowers, by light, by fire, by passion, by anything. I love to have drama and intensity in my work."
                                                       "I want my paintings to look not painted, not made with a brush by a human, but more like incredible, beautiful accidents. \n "
                                                       "My works can be found in private and corporate collections in USA, Canada, Romania, United Kingdom, France, Puerto Rico, Switzerland, Italy, Norway even India."
                                                       "I have organized numerous personal exhibitions and I have participated  to group exhibitions  in Romania, Canada, France, Belgium, Germany and the USA. "

                                                       ]
                                                  }
                                      :interviews {
                                                    :title "INTERVIEWS / PRESS"
                                                    :a [
                                                         {
                                                           :href "http://artindex.ro/2014/05/09/bunea-dan/"
                                                           :text "Dan Bunea on artindex.ro, the romanian artist's index (romanian only)"}
                                                         {
                                                           :href "http://business-review.eu/featured/romanian-artist-dan-bunea-featured-in-nyc-exhibition/"
                                                           :text "Romanian artist Dan Bunea featured in NYC exhibition"}
                                                         {
                                                           :href "http://www.michele-andree-unblugged.com/dan-buneas-return-to-his-first-love"
                                                           :text "Dan Bunea's return to his first love"}
                                                         {
                                                           :href "http://business-review.ro/talent/the-art-of-business/10633/"
                                                           :text "Dan Bunea - the art of business"}
                                                         {
                                                           :href "http://www.internationalekunstheute.com/english/the-artists/"
                                                           :text "Internationale Kunst Heute 2014 - catalog appearance"}
                                                         ]
                                                    }
                                      :exhitions {
                                                   :title "EXHIBITIONS"
                                                   :a [
                                                                {
                                                                  :href "http://www.l-art-pour-lahr.de/index.php?action=aktuell"
                                                                  :text "2018 Exhibition at L'art pour Lahr - 08.03.2018 - 07.04.2018, Lahr, Germany"
                                                                  :image nil
                                                                  }
                                                                {
                                                                  :href "http://ete.lescarroz.com/agenda/1/878461-expo-dan-bunea.html"
                                                                  :text "2017 Exhibition at Le Centre Culturel - 01.01.2017 - 07.01.2017, Les Carroz, France"
                                                                  :image nil
                                                                  }
                                                                {
                                                                  :href "http://www.cafmeyer.be/eng/artist.php?id=318&soort=Paintings"
                                                                  :text "2016 Exhibition at Cafmeyer Gallery -  17.04.2016-17.08.2016, Knokke-Heist, Belgium"
                                                                  :image "cafmeyer1.jpg"
                                                                  }
                                                                {
                                                                  :href "http://www.artistesdumondecannes.fr"
                                                                  :text "2014 Exposition internationale \"Artistes du Monde\" - 17.04.2014 - 20.04.2014, Espace Leo Ferre - Monaco Ville, Monaco "
                                                                  :image "monaco.JPG"
                                                                  }
                                                                {
                                                                  :href "http://www.agora-gallery.com/artistpage/Dan_Bunea.aspx"
                                                                  :text "2013-2014 Pathway to abstraction - 17.12.2013 - 9.01.2014, NEW YORK, USA "
                                                                  :image "ny.png"
                                                                  }
                                                                {
                                                                  :href "http://www.highhorsegallery.com/#!artist/cfvg"
                                                                  :text "2013 High Horse Gallery - 11.2013 - 11.2014 High Horse Gallery - Greenville, USA "
                                                                  :image nil
                                                                  }
                                                                {
                                                                  :href ""
                                                                  :text "2012-2013 Art Contemporain - 10.2012 and 04.2013, Cannes, France"
                                                                  :image nil
                                                                  }
                                                                {
                                                                  :href ""
                                                                  :text "2012 - With\"Artistes du Monde\" - 10-13 Mai 2011, Cercle de Lorraine - Bruxelles, Belgium"
                                                                  :image nil
                                                                  }
                                                                {
                                                                  :href ""
                                                                  :text "2010 - Energized Radiance, with the Energy art movement - July 2010, The Summer Exhibition in Memphis, USA"
                                                                  :image nil
                                                                  }
                                                                {
                                                                  :href ""
                                                                  :text "2010 - With Energy Art Movement, project We are connected, Murphy Hill Gallery, Chicago"
                                                                  :image nil
                                                                  }
                                                                {
                                                                  :href ""
                                                                  :text "2008 -  at Cafe de Bouquinistes, In Timisoara, on Bolyai street, no 3"
                                                                  :image nil
                                                                  }

                                                                ]
                                                   }
                                      }}

                            :shop {:title "Etsy Shop"
                                    :link "https://www.etsy.com/shop/danbunea"}
;;                             :newsletter {:title "Newsletter"
;;                                     :iframe-src "http://www.danbunea.ro/newsletter.htm"}

;;                             :contact {:title "Contact"}
                            }
                    })

(defonce model (r/atom initial-model))


(defn ^:export jsmodel []
  (clj->js @model))
