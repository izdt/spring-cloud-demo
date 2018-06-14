package com.abc.sc.middledemo.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(path="/demo",name="spring-cloud-provider-demo")
public interface IHelloService{
    @RequestMapping("/hello")
    public String testHelloWorld(@RequestParam(value="name") String name);
}