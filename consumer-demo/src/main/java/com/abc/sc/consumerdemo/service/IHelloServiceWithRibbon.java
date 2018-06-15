package com.abc.sc.consumerdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@EnableEurekaClient
@Service
public class IHelloServiceWithRibbon{

    @Bean
    @LoadBalanced
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Autowired
    RestTemplate restTemplate;

    public String testHelloMethod(String name) {
        return restTemplate.getForObject("http://spring-cloud-provider-demo/demo/hello?name="+name,String.class);
    }
}