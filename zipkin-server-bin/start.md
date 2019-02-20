# Start Zipkin Server:
```
curl -sSL https://zipkin.io/quickstart.sh | bash -s
java -jar zipkin.jar

# https://github.com/openzipkin/zipkin/blob/master/zipkin-server/README.md
# https://github.com/openzipkin/zipkin/tree/master/zipkin-autoconfigure/collector-kafka
# https://github.com/openzipkin/zipkin/tree/master/zipkin-storage
# https://github.com/openzipkin/zipkin/blob/master/zipkin-server/README.md#environment-variables

# https://github.com/spring-cloud/spring-cloud-sleuth/tree/master/spring-cloud-sleuth-samples
# https://cloud.spring.io/spring-cloud-sleuth/single/spring-cloud-sleuth.html#_sleuth_with_zipkin_over_rabbitmq_or_kafka

set KAFKA_BOOTSTRAP_SERVERS=127.0.0.1:9092
java -Dzipkin.collector.kafka.bootstrap-servers=127.0.0.1:9092 -jar zipkin.jar
elasticsearch
set STORAGE_TYPE=elasticsearch && set ES_HOST=http://localhost:9200 
echo %STORAGE_TYPE% && echo %ES_HOST%
java -jar zipkin.jar

# https://github.com/openzipkin/zipkin/blob/master/zipkin-server/src/main/resources/zipkin-server-shared.yml

elasticsearch
java -jar zipkin.jar --zipkin.collector.kafka.bootstrap-servers=127.0.0.1:9092 --zipkin.storage.type=elasticsearch --storage.elasticsearch.hosts=localhost:9200
```

# Run Zipkin Dependencies:
```
wget -O zipkin-dependencies.jar 'https://search.maven.org/remote_content?g=io.zipkin.dependencies&a=zipkin-dependencies&v=LATEST'

set STORAGE_TYPE=elasticsearch && set ES_HOST=http://localhost:9200 
echo %STORAGE_TYPE% && echo %ES_HOST%
java -jar zipkin-dependencies.jar
java -jar zipkin-dependencies-2.0.2.jar 2018-09-30
```


## Tips for run zipkin dependencies at windows
```
#https://stackoverflow.com/questions/35652665/java-io-ioexception-could-not-locate-executable-null-bin-winutils-exe-in-the-ha

Download winutils.exe from http://public-repo-1.hortonworks.com/hdp-win-alpha/winutils.exe
set HADOOP_HOME="d:\Projects\Github\learnCodes\spring-cloud-demo\zipkin-server-bin"

```


### Zipkin Environment Variables:

QUERY_PORT: Listen port for the http api and web ui; Defaults to 9411
QUERY_ENABLED: false disables the query api and UI assets. Search may also be disabled for the storage backend if it is not needed; Defaults to true
SEARCH_ENABLED: false disables trace search requests on the storage backend. Does not disable trace by ID or dependency queries. Disable this when you use another service (such as logs) to find trace IDs; Defaults to true
QUERY_LOG_LEVEL: Log level written to the console; Defaults to INFO
QUERY_LOOKBACK: How many milliseconds queries can look back from endTs; Defaults to 24 hours (two daily buckets: one for today and one for yesterday)
STORAGE_TYPE: SpanStore implementation: one of mem, mysql, cassandra, elasticsearch
COLLECTOR_SAMPLE_RATE: Percentage of traces to retain, defaults to always sample (1.0).
AUTOCOMPLETE_KEYS: list of span tag keys which will be returned by the /api/v2/autocompleteTags endpoint
AUTOCOMPLETE_TTL: How long in milliseconds to suppress calls to write the same autocomplete key/value pair. Default 3600000 (1 hr)

```
java -jar zipkin-server-0.0.1-SNAPSHOT.jar  --zipkin.storage.type=mem &
```


### Kafka配置
[Spring Boot Kafka使用文档](https://www.jianshu.com/p/5da86afed228)
