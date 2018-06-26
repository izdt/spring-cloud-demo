# Spring Cloud Demo

## Apps:

| project | port | app name | notes |
|-|-|-|-|
| eureka-server | 10101 | eureka-server | 
| provider-demo | 10201 | spring-cloud-provider-demo | 
| consumer-demo | 10301 | spring-cloud-consumer-demo | use fegin/hystrix/zipkin
| middle-server | 10401 | spring-cloud-middle-service-demo | 
| turbine-server | 10501 |  turbine-server |
| zuul-server | 1601 |  zuul-server |
| zipkin-server | 9411 | zipkin-server | 


## Eureka Server:
```
1. generate eureka server from start.spring.io
2. add @EnableEurekaServer to main class
3. add configuration to application.yml
```

## Provider Demo:
```
1. generate eureka provider from spring initializr
2. add @EnableEurekaClient to main class and add controller
3. add configuration to application.yml
```

## Consumer Demo:
```
1. generate eureka consumer from spring initializr
2. add @EnableEurekaClient @EnableFeignClients to main class
3. define a feign interface to match controller of provider
4. add EnableHystrix @EnableCircuitBreaker @EnableHystrixDashboard to support hystrix
5. add feign.hystrix.enable=true to enable hystrix
6. add configuration to application.yml
7. visist hystrix dashboard and invoke from consumer
```

### hystrx configuration:
https://github.com/Netflix/Hystrix/wiki/Configuration#execution.timeout.enabled


## Start zipkin server
```
curl -sSL https://zipkin.io/quickstart.sh | bash -s
java -jar zipkin.jar
```