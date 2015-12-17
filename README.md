# healthkit-export

This project exists primarily to help me learn Clojure, but it also happens to convert Apple HealthKit export xml files into pipe-delimited csv files. With a bit of tweaking.

## Installation

Clone me!

## Usage

Run it with leiningen or similar, supplying the export filename and where you want to export your csv, eg:

    $ lein run export.xml output.csv

Note that the export file must not contain the DOCTYPE section at the moment (see below).

### Bugs

This is all experimental and largely untested except manually with my own HealthKit export files, so quality is not at all assured!

Furthermore there is an issue with DOCTYPES in the otherwise excellent [clj-xpath](https://github.com/kyleburton/clj-xpath) library. If you try to process an export file with the DOCTYPE still present, you will end up with an error like this:

    DOCTYPE is disallowed when the feature "http://apache.org/xml/features/disallow-doctype-decl" set to true.

So you will need to strip out these parts first.

Fortunately there is a change to clj-xpath on the way that will disable this feature, and then you'll no longer need to strip the DOCTYPE.

## License

Copyright © 2015 Nick Cotter

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
