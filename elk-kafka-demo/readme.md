# ELK CONFIG

## Elasticsearch
start elasticsearch by runing:

```
> elasticsearch-6.4.1\bin>elasticsearch.bat
```

## Kibana
run kibana

## LogStash

config logstash:
```
# Sample Logstash configuration for creating a simple
# Beats -> Logstash -> Elasticsearch pipeline.
# input {
#   beats {
#     port => 5044
#   }
# }

input {
    # beats {
    #   port => 5044
    # }
    tcp {  
        host => "localhost"  
        port => 9601  
        mode => "server"  
        tags => ["tags"]  
        codec => json_lines         
    }  

} 
output {
  elasticsearch {
    hosts => ["http://localhost:9200"]
    index => "applog-%{+appname}-%{+YYYY.MM.dd}"
    #user => "elastic"
    #password => "changeme"
  }
}

```

run logstash:
```
> logstash -f ../config/logstash.conf
```

## FileBeat
config filebeat.yml
```
filebeat.inputs:
- type: log
   enabled: true
   paths:
       - d:\logs\*.json
filebeat.config.modules:
   path: ${path.config}/modules.d/*.yml
   reload.enabled: false
setup.template.settings:
  index.number_of_shards: 3
output.elasticsearch:
  # Array of hosts to connect to.
  hosts: ["localhost:9200"]

#output.logstash:
#   hosts: ["localhost:5044"]
```

## KAFKA CONFIG:

kafka-server-start.bat ../../config/server.properties
```
# tar xvzf kafka_2.11-2.0.0.tgz
# bin/zkServer.sh start

edit server.properties

#advertised.listeners=PLAINTEXT://your.host.name:9092
advertised.listeners=PLAINTEXT://10.11.11.11:9092


# bin/kafka-server-start.sh config/server.properties &
```

### 查看kafka的topic：
```
# 产生消息
# bin/kafka-console-producer.sh --broker-list localhost:9092 --topic test
# 消费消息
# bin/kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic zipkin
# bin/kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic test --from-beginning
# bin/kafka-topics.sh --zookeeper localhost:2181 --list
# 查看产生的消息数
kafka-run-class.sh kafka.tools.GetOffsetShell --broker-list localhost:9092 --topic test --time -1



```

### 查看ES中的trace数据：
curl http://localhost:9200/zipkin:span-2018-05-29/_search

## Zookeeper

### windows 
zookeeper:
1. #unzip zookeeper-3.4.12.tar.gz
2. #md data logs
3. #cd confg and copy zoo_sample.cfg  to zoo.cfg
4. eidt zoo.cfg
#dataDir=/tmp/zookeeper
dataDir=C:\\softwares\\zookeeper-3.4.12\\data
dataLogDir=C:\softwares\zookeeper-3.4.12\logs
5. double click bin\zkServer.cmd


## Kafka broker