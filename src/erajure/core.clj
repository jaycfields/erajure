(ns erajure.core
  (:import [org.mockito]))

(defn mock
  ([klass]
    (org.mockito.Mockito/mock klass))
  ([klass behavior]
    (doto (org.mockito.Mockito/mock klass)
      behavior)))

(defmacro verify
  ([klass form]
    `(-> (org.mockito.Mockito/verify ~klass) ~form))
  ([klass times form]
    `(-> (org.mockito.Mockito/verify ~klass ~times) ~form)))

(defn ->when [[meth r]]
  (list '-> 'm meth 'org.mockito.Mockito/when (list '.thenReturn r)))

(defmacro behavior [& args]
  `(fn ~'[m]
    ~@(map ->when (partition 2 args))))

(def never (org.mockito.Mockito/never))
