(def the-world (ref "hello"))
(def bizarro-world (ref {}))

(meditations
  "In the beginning, there was a word"
  (= "hello" (deref the-world))

  "You can get the word more succinctly, but it's the same"
  (= "hello" @the-world)

  "You can be the change you wish to see in the world."
  (= "better" (do
          (dosync (ref-set the-world "better"))
          @the-world))

  ;;SVS: Here the return value of the 'alter' is discarded.
  ;; Only sideffects are captured in the reference to the world.
  "Alter where you need not replace"
  (= "better!!!" (let [exclamator (fn [x] (str x "!"))]
          (dosync
           (alter the-world exclamator)
           (alter the-world exclamator)
           (alter the-world exclamator))
          @the-world))

  "Don't forget to do your work in a transaction!"
  (= 0 (do (dosync (ref-set the-world 0))
           @the-world))

  "Functions passed to alter may depend on the data in the ref"
  (= 20 (do
          (dosync (alter the-world + 20))))

  "Two worlds are better than one"
  (= ["Real Jerry" "Bizarro Jerry"]
       (do
         (dosync
          (ref-set the-world {})
          (alter the-world assoc :jerry "Real Jerry")
          (alter bizarro-world assoc :jerry "Bizarro Jerry")
          (map :jerry [@the-world @bizarro-world]) ))))

  ;;SVS the same thing using sequence comprehesion
  "Two worlds are better than one"
  (= ["Real Jerry" "Bizarro Jerry"]
       (do
         (dosync
          (ref-set the-world {})
          (alter the-world assoc :jerry "Real Jerry")
          (alter bizarro-world assoc :jerry "Bizarro Jerry")
          (for [world [the-world bizarro-world]] 
            (:jerry @world) ))))
