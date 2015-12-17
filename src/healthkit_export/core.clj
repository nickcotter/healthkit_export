(ns healthkit-export.core
  (:gen-class)
  (use [clj-xpath.core]))

(refer 'clojure.string :only '[join split-lines])
(refer 'clojure.java.io)

;; clunky stuff to strip out doc type
;; when doc type can be excluded in clj-xpath.core then replace
;; read-xml with slurp

(defn read-lines
  "converts file into lines"
  [file-path]
  (split-lines (slurp file-path))
)

(defn read-xml
  "converts xml file to string, sans doctype"
  [file-path]
  (join "\n"
        (filter #(.contains % "<")
(filter #(not (.startsWith % "<!")) (read-lines "data/export_no_workouts.xml")))
        )
  )


;; main parsing stuff


(defn read-records
  "returns sequence of record maps containing each Record's attributes"
  [export-path]
  (map #(-> % :attrs) ($x "//Record" (read-xml export-path))))

(defn to-csv-line
  "maps record map to single line for writing"
  [record]
  (join "|" [(record :type) (record :creationDate) (record :unit) (record :value)]))

(defn write-csv
  "writes a sequence of csv lines to the given filename"
  [csv-lines output-filename]
  (spit output-filename (join "\n" csv-lines))
  )

;; (write-csv (map to-csv-line (read-records "data/small_export.xml")) "health.csv")

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
;;   (printf args)
  )
