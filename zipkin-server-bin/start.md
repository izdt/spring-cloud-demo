# Start Zipkin Server:
```
curl -sSL https://zipkin.io/quickstart.sh | bash -s
java -jar zipkin.jar

# https://github.com/openzipkin/zipkin/blob/master/zipkin-server/README.md
?java -DKAFKA_ZOOKEEPER=localhost:2181 -DSTORAGE_TYPE=cassandra -jar zipkin-server-1.19.2-exec.jar

# https://github.com/openzipkin/zipkin/tree/master/zipkin-autoconfigure/collector-kafka
java -Dzipkin.collector.kafka.bootstrap-servers=127.0.0.1:9092 -jar zipkin.jar

java -jar zipkin.jar --STORAGE_TYPE=elasticsearch --DES_HOSTS=http://localhost:9200 
# https://github.com/openzipkin/zipkin/blob/master/zipkin-server/src/main/resources/zipkin-server-shared.yml


java -jar zipkin.jar --zipkin.collector.kafka.bootstrap-server=127.0.0.1:9092 --zipkin.storage.type=elasticsearch --storage.elasticsearch.hosts=localhost:9200
```