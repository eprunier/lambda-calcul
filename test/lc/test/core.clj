(ns lc.test.core
  (:use [clojure.test]
        [lc.core]))

(deftest test-variable-to-string
  (is (= "x" (to-string :x))))

(deftest test-abstraction-to-string
  (is (= "(\\x. x)"
         (to-string (abstraction :x :x))))
  (is (= "(\\x. (\\y. x))"
         (to-string (abstraction :x
                                 (abstraction :y :x))))))

(deftest test-application-to-string
  (is (= "(u v)"
         (to-string (application :u :v)))))

(deftest test-to-string
  (is (= "(\\x. (u (\\y. v)))"
         (to-string (abstraction :x
                                 (application :u
                                              (abstraction :y :v)))))))

(deftest test-vars
  (is (= #{:x} (vars :x)))
  (is (= #{:x} (vars (abstraction :x :x))))
  (is (= #{:x :y} (vars (abstraction :x :y)))))