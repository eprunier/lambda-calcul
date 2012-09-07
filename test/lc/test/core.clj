(ns lc.test.core
  (:use [clojure.test]
        [lc.core]))

;;; to-string
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

;;; vars
(deftest test-vars
  (is (= #{:x} (vars :x))))

(deftest test-abstraction-vars
  (is (= #{:x} (vars (abstraction :x :x))))
  (is (= #{:x :y} (vars (abstraction :x :y)))))

(deftest test-application-vars
  (is (= #{:x} (vars (application :x :x))))
  (is (= #{:x :y} (vars (application :x :y)))))

;;; bound-vars
(deftest test-bound-vars
  (is (= #{} (bound-vars :x))))

(deftest test-abstraction-bound-vars
  (is (= #{:x} (bound-vars (abstraction :x :y))))
  (is (= #{:y :x} (bound-vars (abstraction :x (abstraction :y :y))))))

(deftest test-application-bound-vars
  (is (= #{} (bound-vars (application :x :y)))))

;;; free-vars
