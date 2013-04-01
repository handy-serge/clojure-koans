(defn is-even? [n]
  (if (= n 0)
    true
    (not (is-even? (dec n)))))

;;SVS: loop creates anonimous function with 2 arguments
;; and calls it immediately with n  and true as argument values.
;; at eache subsequent recursive call n is decremented and acc is
;; inverted. 
;; 'recur' assures that this call will not consume the stack.
(defn is-even-bigint? [n]
  (loop [n   n
         acc true]
    (if (= n 0)
      acc
      (recur (dec n) (not acc)))))

;;SVS:  Second argument in loop ('reversed') is used to accumulate returned
;; value - it will contain reversed collection.
;; First of the argument ('tail') would keep track of the part of the
;; collection which is not processed yet.
(defn recursive-reverse [coll]
  ( loop [tail coll
          reversed () ]
    (if (empty? tail)
      reversed
      (recur (rest tail) (cons (first tail) reversed)) )))

(defn factorial [n]
  (loop [number n
         result 1]
    (if (= number 0)
      result
      (recur (dec number) (* number result)) )))

(meditations
  "Recursion ends with a base case"
  (= true (is-even? 0))

  "And starts by moving toward that base case"
  (= false (is-even? 1))

  "Having too many stack frames requires explicit tail calls with recur"
  (= false (is-even-bigint? 100003N))

  "Reversing directions is easy when you have not gone far"
  (= '(1) (recursive-reverse [1]))

  "Yet more difficult the more steps you take"
  (= '(5 4 3 2 1) (recursive-reverse [1 2 3 4 5]))

  "Simple things may appear simple."
  (= 1 (factorial 1))

  "They may require other simple steps."
  (= 2 (factorial 2))

  "Sometimes a slightly bigger step is necessary"
  (= 6 (factorial 3))

  "And eventually you must think harder"
  (= 24 (factorial 4))

  "You can even deal with very large numbers"
  (< 1000000000000000000000000N (factorial 1000N))

  ;;SVS: This computes, but trying to print out the result hangs Emacs.
  "But what happens when the machine limits you?"
  (< 1000000000000000000000000N (factorial 100003N)))
