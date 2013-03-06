(meditations
  "Lists can be expressed by function or a quoted form"
  (= '(1 2 3 4 5) (list 1 2 3 4 5))

  "They are Clojure seqs (sequences), so they allow access to the first"
  (= 1 (first '(1 2 3 4 5)))

  "As well as the rest"
  (= '(2 3 4 5) (rest '(1 2 3 4 5)))

  "Count your blessings"
  (= 3 (count '(dracula dooku chocula)))

  "Before they are gone"
  (= 0 (count '()))

  "The rest, when nothing is left, is empty"
  (= '() (rest '(100)))

  " SVS: Empty vector IS equal to empty list"
  (= [] (rest '(100))) ; SVS: This was added by myself.
  
  "SVS: BUT Empty string IS NOT equal to empty list"
  (not= "" (rest '(100))) ; SVS: This was added by myself.

  "SVS: BUT Empty dictionary IS NOT equal to empty list"
  (not= {} (rest '(100))) ; SVS: This was added by myself.


  "Construction by adding an element to the front is easy"
  (= '(:a :b :c :d :e) (cons :a '(:b :c :d :e)))

  ; SVS: But what are the difference between 'cons' and 'conj'?
  ;; From 
  ;;  http://bpeirce.me/clojure-sequence-implementations.html
  ;;
  ;; The main difference between cons and conj is that cons returns
  ;;  sequences (of type clojure.lang.Cons) regardless of its input,
  ;;  while conj returns the type of collection that was passed to it.
  ;;  Also, conj can add multiple items to a collection, whereas cons
  ;;  can only add one at a time. This means the collection argument
  ;;  comes first in conj, so that there can be a variable number of
  ;;  items added to the collection.
  ;;
  ;;  A more subtle difference is that conj operates on the
  ;;  collection's underlying data structure, rather than on the ISeq
  ;;  interface, so it can be more efficient. As a consequence, conj
  ;;  doesn't always append items to the beginning of collections.
  ;;  Here are some illustrations.

  "Conjoining an element to a list isn't hard either"
  (= '(:e :a :b :c :d)  (conj '(:a :b :c :d) :e))

  "You can use a list like a stack to get the first element"
  (= :a (peek '(:a :b :c :d :e)))

  "Or the others"
  (= '(:b :c :d :e)  (pop '(:a :b :c :d :e)))

  "But watch out if you try to pop nothing"
  (= "No dice!" (try
          (pop '())
          (catch IllegalStateException e
            "No dice!")))

  ;; SVS: 'pop' will throw exception, 'rest' will return empty sequence.
  "The rest of nothing isn't so strict"
  (= '() (try
          (rest '())
          (catch IllegalStateException e
            "No dice!"))))

