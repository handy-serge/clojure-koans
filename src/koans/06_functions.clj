(defn multiply-by-ten [n]
  (* 10 n))

(defn square [n] (* n n))

(meditations

  ;; SVS: Laughed aloud!
  "Calling a function is like giving it a hug with parentheses"
  (= 81 (square 9))

  "Functions are usually defined before they are used"
  (= 20 (multiply-by-ten 2))

  "But they can also be defined inline"
  (= 10 ((fn [n] (* 5 n)) 2))

  ;; SVS: Notation ofr defining inline functions is '#(...)', whereas
  ;; '#{...}' declares a set.
  "Or using an even shorter syntax"
  (= 60 (#(* 15 %) 4))

  "Even anonymous functions may take multiple arguments"
  (= 15 (#(+ %1 %2 %3) 4 5 6))

  ;; SVS: This works as alias for function.
  "One function can beget another"
  (= 9 (((fn [] +)) 4 5))

  "Functions can also take other functions as input"
  (= 20 ((fn [f] (f 4 5))
         *))

  ;; SVS: Here I went to the 'Clojure programming' at
  ;; my.safaribooksonline.com
  ;;
  ;; By the way, they have very nice way to take notes while working
  ;; on a books. They have tags on notes.
  ;;
  ;; So, initially, I thought that I had to use something like
  ;; 'partial', or 'apply'. But finally, what I need is just to define
  ;; function that calls the given function with the good argument.
  ;;
  ;; This made me learn proper meaning of positional arguments for
  ;; function literals:
  ;; - %  : means single argument (equivalent to %1)
  ;; - %1, %2, ..., %n : means positional arguments
  ;; - %& : means 'rest of arguments' for variadic functions.
  ;;
  ;; Also there are 3 differencies between functional literals and fn
  ;; form: 
  ;; - use of positional arguments
  ;; - they can not be nested
  ;; - and they do not have implicit do form 
  ;; (See 'Clojure programming' book.)
  ;; 
  ;; There is also discussion of the 'apply' and 'partial' at the end
  ;; of the chapter.
  "Higher-order functions take function arguments"
  (= 25 ( #(% 5)
          (fn [n] (* n n))))

  "But they are often better written using the names of functions"
  (= 25 (#(% 5) square)))
