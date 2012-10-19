(ns leiningen.hooks.publish-fig
  (:require [robert.hooke]
            [leiningen.publish-fig])
  (:use clojure.java.shell))

(defn copy-jar [publish-fig & args]
  (let [result  (sh "cp" "target/erajure.jar" "erajure.jar")]
    (println (:out result) (:err result)))
  (apply publish-fig args))

(defn activate []
  (robert.hooke/add-hook #'leiningen.publish-fig/publish-fig
                         copy-jar))
