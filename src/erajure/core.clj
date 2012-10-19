(ns erajure.core
  (:import [org.mockito Mockito]))

(defn mock
  ([klass]
    (Mockito/mock klass))
  ([klass behavior]
    (doto (Mockito/mock klass)
      behavior)))

(defmacro verify
  ([klass form]
    `(-> (Mockito/verify ~klass) ~form))
  ([klass times form]
    `(-> (Mockito/verify ~klass ~times) ~form)))

(defn ->when [[meth r]]
  (list '-> 'm meth 'Mockito/when (list '.thenReturn r)))

(defmacro behavior [& args]
  `(fn ~'[m]
    ~@(map ->when (partition 2 args))))

(def never (Mockito/never))
