(ns lc.core
  (:require [clojure.set :as set]))

(defprotocol LambdaTerm
  "Define the lambda-term protocol which must be implemented by variables, abstractions and applications"
  (to-string [this])
  (vars [this])
  (bound-vars [this])
  (free-vars [this]))

(extend-type clojure.lang.Keyword
  LambdaTerm
  (to-string [this]
    (name this))
  (vars [this]
    #{this})
  (bound-vars [this]
    #{})
  (free-vars [this]
    (vars this)))

(defrecord Abstraction [arg term]
  LambdaTerm
  (to-string [this]
    (str "(\\" (-> this .arg to-string)  ". " (-> this .term to-string) ")"))
  (vars [this]
    (conj (-> this .term vars) (.arg this)))
  (bound-vars [this]
    (conj (-> this .term bound-vars) (-> this .arg)))
  (free-vars [this]
    (reduce disj (-> this .term free-vars) (-> this .arg bound-vars))))

(defrecord Application [first-term second-term]
  LambdaTerm
  (to-string [this]
    (str "(" (-> this .first-term to-string) " " (-> this .second-term to-string) ")"))
  (vars [this]
    (set/union (-> this .first-term vars) (-> this .second-term vars)))
  (bound-vars [this]
    (set/union (-> this .first-term bound-vars) (-> this .second-term bound-vars))))

(defn abstraction [arg term]
  (Abstraction. arg term))

(defn application [first-term second-term]
  (Application. first-term second-term))

(defn variable? [term]
  (instance? clojure.lang.Keyword term))

(defn abstraction? [term]
  (instance? lc.core.Abstraction term))

(defn application? [term]
  (instance? lc.core.Application term))
