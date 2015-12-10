(ns healthkit-export.parse
 (use [clj-xpath.core :only [$x $x:tag $x:text $x:attrs $x:attrs* $x:node]]))

(def *some-xml*
     "<?xml version=\"1.0\" encoding=\"UTF-8\"?>
<books>
  <book title=\"Some Guide To XML\">
    <author>
      <name>P.T. Xarnum</name>
      <email>pt@x.m.l</email>
    </author>
    <description>
      Simply the most comprehensive XML Book on the market today.
    </description>
  </book>
  <book title=\"Some Guide To Functional Programming\">
    <author>
      <name>S. Hawking</name>
      <email>universe@cambridge.ed.u</email>
    </author>
    <description>
      This book is too smart for you, try 'Head first Quantum Mechanics for Dummies' instead.
    </description>
  </book>
</books>")

(prn ($x:tag "/*" *some-xml*))
