package com.abc.sc.consumerdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class IHelloServiceWithRibbon{

    @Autowired
    RestTemplate restTemplate;
    public String testHelloMethod(String name) {
        return restTemplate.getForObject("http://spring-cloud-provider-demo/demo/hello?name="+name,String.class);
    }
}