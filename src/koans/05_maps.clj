(meditations
  "Don't get lost when creating a map"
  (= {:a 1 :b 2} (hash-map :a 1 :b 2))

  ;; SVS: is there are other flavors of maps?
  "A value must be supplied for each key"
  (= {:a 1} (hash-map :a 1))

  "The size is the number of entries"
  (= 2 (count {:a 1 :b 2}))

  ;; SVS: maps dereferencing is with 'get'
  "You can look up the value for a given key"
  (= 2 (get {:a 1 :b 2} :b))

  ;; SVS: This was non trivial!!!
  "Maps can be used as functions to do lookups"
  (= 1 ({:a 1 :b 2} :a))

  ;; SVS: This was non trivial also...
  "And so can keywords"
  (= 1 (:a {:a 1 :b 2}))

  "But map keys need not be keywords"
  (= "Vancouver" ({2006 "Torino" 2010 "Vancouver" 2014 "Sochi"} 2010))

  "You may not be able to find an entry for a key"
  (= nil (get {:a 1 :b 2} :c))

  ;; SVS: 'get' is used to get values from the map.
  ;; - or map itself.
  ;; - or keywords...
  "But you can provide your own default"
  (= :key-not-found (get {:a 1 :b 2} :c :key-not-found))

  "You can find out if a key is present"
  (= true (contains? {:a nil :b nil} :b))

  ;; SVS: 'false' is not equal to 'nil'...
  "Or if it is missing"
  (= false (contains? {:a nil :b nil} :c))

  ;; SVS: Assoc creates NEW map with additional content...
  "Maps are immutable, but you can create a new and improved version"
  (= {1 "January" 2 "February"} (assoc {1 "January" } 2 "February"))

  ;; SVS: Dissoc creates NEW map with content removed...
  "You can also create a new version with an entry removed"
  (= {1 "January"} (dissoc {1 "January" 2 "February"} 2))

  ;; SVS: 'keys' get keys.
  "Often you will need to get the keys, but the order is undependable"
  (= (list 2006 2010 2014)
     (sort (keys {2006 "Torino" 2010 "Vancouver" 2014 "Sochi"})))

  "You can get the values in a similar way"
  (= (list "Sochi" "Torino" "Vancouver")
     (sort (vals {2006 "Torino" 2010 "Vancouver" 2014 "Sochi"}))))
