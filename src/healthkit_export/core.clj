(ns healthkit-export.core
  (:gen-class)
  (use [clj-xpath.core]))

(refer 'clojure.string :only '[join split-lines])

(defn read-records
  "returns sequence of record maps containing each Record's attributes"
  [export-path]
  (map #(-> % :attrs) ($x "//Record" (slurp export-path))))

(defn to-csv-line
  "maps record map to single line for writing"
  [record]
  (join "|" [(record :type) (record :creationDate) (record :unit) (record :value)]))

(defn write-csv
  "writes a sequence of csv lines to the given filename"
  [csv-lines output-filename]
  (spit output-filename (join "\n" csv-lines))
  )

(defn -main [& args]
  (let [input-path (nth args 0)
        output-path (nth args 1)]
    (write-csv (map to-csv-line (read-records input-path)) output-path)
   ))
