(meditations

  ;; The notation #{...} denotes set.
  ;; Set function creates it from collection
  "You can create a set by converting another collection"
  (= #{3} (set '(3)))
 
  "SVS: Creating set from the vector."
  (= #{3} (set [3]))

  ;;SVS: Note like it treats map as a sequence of vectors...
  "SVS: Creating from map."
  (= #{[:a :b] [:c :d]} (set {:a :b :c :d}))

  "Counting them is like counting other collections"
  (= 3 (count #{1 2 3}))

  "Remember that a set is a *mathematical* set"
  (= #{1 2 3 4 5} (set '(1 1 2 2 3 3 4 4 5 5)))

  "You can ask clojure for the union of two sets"
  (= #{1 2 3 4 5} (clojure.set/union #{1 2 3 4} #{2 3 5}))

  "And also the intersection"
  (= #{2 3} (clojure.set/intersection #{1 2 3 4} #{2 3 5}))

  ;; SVS: Difference contains elements of the first set that are not in
  ;; the second set.
  "But don't forget about the difference"
  (= #{1 4} (clojure.set/difference #{1 2 3 4 5} #{2 3 5})))
