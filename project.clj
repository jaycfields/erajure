(defproject erajure "0.0.4"
  :description "clojure mockito wrapper"
  :url "https://github.com/jaycfields/erajure"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.4.0"]
                 [org.mockito/mockito-all "1.8.0"]]
  :profiles {:dev {:dependencies [[expectations "1.4.10"]]}}
  :plugins [[lein-expectations "0.0.7"]
            [lein-publishers "1.0.11"]]
  :hooks [leiningen.hooks.publish-fig]
  :jar-name "erajure.jar")
