(ns com.core
  (:require
   [clojure.java.io :as io]
   [tablecloth.api :as tc]
   [tech.v3.dataset])
  (:gen-class))

(def my-data
  (let [my-data (tech.v3.dataset/->dataset
                 (.getResourceAsStream (.getContextClassLoader (Thread/currentThread))
                                       "path/file.csv")
                 {:file-type :csv})]

    (-> my-data
        (tc/rename-columns {"date" :date
                            "value" :value}))))

(def io-data
  (let [my-data (io/file (io/resource "./path/file.csv"))]

    (-> my-data
        (tc/dataset)
        (tc/rename-columns {"date" :date
                            "value" :value}))))

(defn -main
  [& args]
  (println {:daniel-method my-data
            :io-methd io-data}))
