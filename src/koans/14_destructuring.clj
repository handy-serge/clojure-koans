(def test-address
  {:street-address "123 Test Lane"
   :city "Testerville"
   :state "TX"})

(meditations
  "Destructuring is an arbiter: it breaks up arguments"
  (= ":bar:foo" ((fn [[a b]] (str b a))
         [:foo :bar]))

  "Whether in function definitions"
  (= (str "First comes love, "
          "then comes marriage, "
          "then comes Clojure with the baby carriage")
     ((fn [[a b c]] 
        (str "First comes " a ", "
             "then comes " b ", "
             "then comes " c " with the baby carriage" ))
      ["love" "marriage" "Clojure"]))

  ;;SVS: Here I used the same trick with 'apply', 'str' and
  ;; 'interpose' as it was used in koan 09_runtime_polymorphism.
  "Or in let expressions"
  (= "Rich Hickey aka The Clojurer aka Go Time aka Macro Killah"
     (let [[first-name last-name & aliases]
           (list "Rich" "Hickey" "The Clojurer" "Go Time" "Macro Killah")]
       (apply str 
              (interpose " aka " 
                         (cons (str first-name " " last-name)
                               aliases )))))


  "You can regain the full argument if you like arguing"
  (= {:original-parts ["Steven" "Hawking"] :named-parts {:first "Steven" :last "Hawking"}}
     (let [[first-name last-name :as full-name] ["Steven" "Hawking"]]
       {:original-parts full-name 
        :named-parts {:first first-name :last last-name}}))

  "Break up maps by key"
  (= "123 Test Lane, Testerville, TX"
     (let [{street-address :street-address, city :city, state :state} test-address]
       (apply str (interpose ", " [street-address, city, state])) ))

  "Or more succinctly"
  (= "123 Test Lane, Testerville, TX"
     (let [{:keys [street-address city state]} test-address]
       (apply str (interpose ", " [street-address, city, state])) ))

  ;;SVS: Here I first need to define function, because I can replace
  ;; only placeholder at the start. Second, I destructure it to two
  ;; arguments, first one will be bound to vector, second to a map.
  ;; Third, I further destructure first element, use it to calculate
  ;; string representation, then I destructure second argument. And
  ;; finally I write the function body which applies common operation
  ;; to uniform data. And it is a destructuring let that makes data
  ;; uniform.  
  "All together now!"
  (= "Test Testerson, 123 Test Lane, Testerville, TX"
     ( (fn [full-name address] 
         (let [ [first-name last-name] full-name
                , name-as-string (str first-name " " last-name)
                  , {street-address :street-address
                     city :city
                     state :state } address ]
           (apply str (interpose ", " [name-as-string street-address city state])) )) 
       ["Test" "Testerson"] test-address )))
