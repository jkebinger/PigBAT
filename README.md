PigBAT
======

A set of User Defined functions (UDF) for pig to decode shorts, ints, and longs from byte arrays in pig. 

Requires hbase.jar to be on the classpath because these UDF pass through to org.apache.hadoop.hbase.util.Bytes.

Primary use case is to decode information encoded in an Hbase rowkey as below:


    register 'hbase-0.90.4-cdh3u3.jar';
    register 'zookeeper.jar';
    register 'PigBAT-0.0.1-SNAPSHOT.jar';

    counts_raw = LOAD 'hbase://some-table' USING org.apache.pig.backend.hadoop.hbase.HBaseStorage('0:cd', '-loadKey true')  AS (key:bytearray, data:bytearray);
    -- extract an int
    expanded = FOREACH counts_raw GENERATE com.kebinger.pigbat.BYTES_TO_INT(key,0) as some_id, data;
    -- count 
    grouped = GROUP expanded by some_id;
    counted = FOREACH grouped GENERATE group, count(expanded);



