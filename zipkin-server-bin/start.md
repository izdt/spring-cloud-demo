# Start Zipkin Server:
```
curl -sSL https://zipkin.io/quickstart.sh | bash -s
java -jar zipkin.jar

# https://github.com/openzipkin/zipkin/blob/master/zipkin-server/README.md
# https://github.com/openzipkin/zipkin/tree/master/zipkin-autoconfigure/collector-kafka
set KAFKA_BOOTSTRAP_SERVERS=127.0.0.1:9092
java -Dzipkin.collector.kafka.bootstrap-servers=127.0.0.1:9092 -jar zipkin.jar
elasticsearch
set STORAGE_TYPE=elasticsearch && set ES_HOST=http://localhost:9200 
echo %STORAGE_TYPE% && echo %ES_HOST%
java -jar zipkin.jar

# https://github.com/openzipkin/zipkin/blob/master/zipkin-server/src/main/resources/zipkin-server-shared.yml

elasticsearch
java -jar zipkin.jar --zipkin.collector.kafka.bootstrap-server=127.0.0.1:9092 --zipkin.storage.type=elasticsearch --storage.elasticsearch.hosts=localhost:9200
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