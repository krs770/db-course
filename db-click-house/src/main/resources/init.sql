create database measurement;

create table if not exists measurement.test
(
    source String,
    timestamp DateTime64(3),
    value DOUBLE
)
engine = AggregatingMergeTree
order by (source, timestamp);


-- engine = SummingMergeTree(count)
-- select source, value,  timestamp, count(1) as count from clickdb.clicks where domain = :domain group by domain, path, d

