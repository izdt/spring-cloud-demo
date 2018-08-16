package com.abc.sc.consumerdemo.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class IHelloServiceWithRibbon{

    @Autowired
    RestTemplate restTemplate;
    @HystrixCommand(fallbackMethod = "helloMethodFallback")
    public String testHelloMethod(String name) {
        return restTemplate.getForObject("http://spring-cloud-provider-demo/demo/hello?name="+name,String.class);
    }
     public String helloMethodFallback(String name) {
        return "hello service from ribbon not available";
    }
}