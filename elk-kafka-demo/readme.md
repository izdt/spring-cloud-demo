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

# KAFKA CONFIG:

## Zookeeper
## Kafka broker