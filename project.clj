(defproject phantomcljs "0.1.0-SNAPSHOT"
  :plugins [[lein-cljsbuild "1.1.2"]]
  :description "PhantomJS and ClojureScript interoperating"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.7.0"]
                 [org.clojure/clojurescript "1.7.228"]]
  :main ^:skip-aot phantomcljs.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}}
  :cljsbuild {:builds
              [{:id "app"
                :source-paths ["src-cljs"]
                :compiler {:optimizations :whitespace
                           :pretty-print true
                           :preamble ["react/react.min.js"]
                           :output-to "resources/public/js/app.js"}}]})
                           ;; :output-dir "resources/public/js/"
                           ;; :source-map "resources/public/js/app.js.map"
