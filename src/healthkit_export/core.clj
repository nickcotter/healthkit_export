(ns healthkit-export.core
  (:gen-class)
  (use [clj-xpath.core]))

(defn read-records
  "returns sequence of record maps containing each Record's attributes"
  [export-path]
  (map #(-> % :attrs) ($x "//Record" (slurp export-path))))

(defn to-csv-line
  "maps record map to single line for writing"
  [record]
  (clojure.string/join "\t" [(record :type) (record :creationDate) (record :unit) (record :value)]))

(defn write-csv
  "writes a sequence of csv lines to the given filename"
  [csv-lines output-filename]
  (spit output-filename (clojure.string/join "\n" csv-lines))
  )

;; (write-csv (map to-csv-line (read-records "data/small_export.xml")) "health.csv")

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (printf args))
