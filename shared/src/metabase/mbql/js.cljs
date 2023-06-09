(ns metabase.mbql.js
  "JavaScript-friendly interface to metabase.mbql util functions."
  (:require
   [metabase.mbql.normalize :as mbql.normalize]
   [metabase.util :as u]))

(defn ^:export normalize
  "Normalize an MBQL query, and convert it to the latest and greatest version of MBQL."
  [query]
  (-> query js->clj mbql.normalize/normalize (clj->js :keyword-fn u/qualified-name)))
