(ns metabase.mbql.predicates
  "Predicate functions for checking whether something is a valid instance of a given MBQL clause."
  (:require
   [metabase.mbql.schema :as mbql.s]
   [schema.core :as s]))

;; This namespace only covers a few things, please add more stuff here as we write the functions so we can use them
;; elsewhere

(def ^{:arglists '([unit])} TimeUnit?
  "Is `unit` a datetime bucketing unit referring only to time, such as `hour` or `minute`?"
  (complement (s/checker mbql.s/TimeUnit)))

(def ^{:arglists '([unit])} DateUnit?
  "Is `unit` a valid date bucketing unit?"
  (complement (s/checker mbql.s/DateUnit)))

(def ^{:arglists '([unit])} DateTimeUnit?
  "Is `unit` a valid datetime bucketing unit?"
  (complement (s/checker mbql.s/DateTimeUnit)))

(def ^{:arglists '([unit])} TimezoneId?
  "Is `unit` a valid datetime bucketing unit?"
  (complement (s/checker mbql.s/TimezoneId)))

(def ^{:arglists '([ag-clause])} Aggregation?
  "Is this a valid Aggregation clause?"
  (complement (s/checker mbql.s/Aggregation)))

(def ^{:arglists '([field-clause])} Field?
  "Is this a valid Field clause?"
  (complement (s/checker mbql.s/Field)))

(def ^{:arglists '([filter-clause])} Filter?
  "Is this a valid `:filter` clause?"
  (complement (s/checker mbql.s/Filter)))

(def ^{:arglists '([filter-clause])} DatetimeExpression?
  "Is this a valid DatetimeExpression clause?"
  (complement (s/checker mbql.s/DatetimeExpression)))

(def ^{:arglists '([field-clause])} FieldOrExpressionDef?
  "Is this a something that is valid as a top-level expression definition?"
  (complement (s/checker mbql.s/FieldOrExpressionDef)))
