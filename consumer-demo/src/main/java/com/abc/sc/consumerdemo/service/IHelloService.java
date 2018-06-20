package com.abc.sc.consumerdemo.service;

import com.abc.sc.consumerdemo.model.DemoRequest;
import com.abc.sc.consumerdemo.model.DemoResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name="spring-cloud-provider-demo")
public interface IHelloService{
    @PostMapping("/hello")
    public DemoResponse helloWorld(@RequestBody DemoRequest request);
}