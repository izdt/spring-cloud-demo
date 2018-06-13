# Spring Cloud Demo

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