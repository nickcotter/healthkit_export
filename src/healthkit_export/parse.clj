(ns healthkit-export.parse
 (use [clj-xpath.core :only [$x $x:tag $x:text $x:attrs $x:attrs* $x:node]]))

(def export-path "data/small_export.xml")

(prn ($x:attrs* "//ExportDate" (slurp export-path) :value))



