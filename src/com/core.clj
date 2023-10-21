(ns com.core
  (:require [tech.v3.dataset]
            [tablecloth.api :as tc])
  (:gen-class))

(def my-data
  (let [my-data (tech.v3.dataset/->dataset
                 (.getResourceAsStream (.getContextClassLoader (Thread/currentThread))
                                       "path/file.csv")
                 {:file-type :csv})]

    (-> my-data
        (tc/rename-columns {"date" :date
                            "value" :value}))))

(defn -main
  [& args]
  my-data)
