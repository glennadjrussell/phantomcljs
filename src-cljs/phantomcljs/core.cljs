(ns phantomcljs.core
  (:require [goog.dom :as dom]
            [goog.object :as obj]
            [goog.string :as str]))

(extend-type js/HTMLCollection
  ISeqable
  (-seq [array] (array-seq array 0))

  ICounted
  (-count [a] (alength a))

  IIndexed
  (-nth
    ([array n]
     (if (< n (alength array)) (aget array n)))
    ([array n not-found]
     (if (< n (alength array)) (aget array n) not-found)))

  ILookup
  (-lookup
    ([array k]
     (aget array k))
    ([array k not-found]
     (-nth array k not-found)))

  IReduce
  (-reduce
    ([array f]
     (ci-reduce array f))
    ([array f start]
     (ci-reduce array f start))))

(defn elem-attr [node attr]
  {:pre [(some? node)
         (some? attr)]}
  (.getAttribute node attr))

(defn walk-form [form]
  ;;(println (.-action form))
  (println (elem-attr form "action"))
  (println (.-id form)))

(defn walk-dom []
  (let [doc (dom/getDocument)
        forms (.-forms doc)]
    (try
      (do
        (doseq [fm forms]
          (walk-form fm)))
      (catch js/Error err (println err)))))


(defn main []
  (enable-console-print!)
  (walk-dom))

(main)
