package com.abc.sc.consumerdemo.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.abc.sc.consumerdemo.fallback.HelloServiceFallback;

@FeignClient(path="/demo",name="spring-cloud-provider-demo",fallback=HelloServiceFallback.class)
public interface IHelloService{
    @RequestMapping("/hello")
    public String testHelloWorld(@RequestParam(value="name") String name);
}