(ns erajure.core-expectations
  (:use expectations erajure.core))

(expect "it worked" (.get (mock java.util.List (behavior (.get 0) "it worked")) 0))
