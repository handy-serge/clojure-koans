(meditations
  "You can use vectors in clojure as array-like structures"
  (= 1 (count [42]))

  "You can create a vector from a list"
  (= [1] (vec '(1)))


  ;;SVS: Function 'vec' creates vector from a sequence. Whereas
  ;; function 'vector' creates vector from the elements.
  "Or from some elements"
  (= [nil nil] (vector nil nil))

  "But you can populate it with any number of elements at once"
  (= [1 2] (vec '(1 2)))

  ;;SVS: For vector it puts it in the end
  "Conjoining to a vector is different than to a list"
  (= [111 222 333] (conj [111 222] 333))

  "SVS: Conjoining to a vector. Do not forget to quote"
  (= '(333 111 222)  (conj '(111 222) 333))

  "You can get the first element of a vector like so"
  (= :peanut (first [:peanut :butter :and :jelly]))

  "And the last in a similar fashion"
  (= :jelly (last [:peanut :butter :and :jelly]))

  "Or any index if you wish"
  (= :jelly  (nth [:peanut :butter :and :jelly] 3))

  ;; SVS: First argument of 'subvec' is inclusive, second is exclusive.
  "You can also slice a vector"
  (= [:butter :and ] (subvec [:peanut :butter :and :jelly] 1 3))

  "Equality with collections is in terms of values"
  (= (list 1 2 3) (vector 1 2 3)))
