package com.abc.sc.consumerdemo.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.abc.sc.consumerdemo.fallback.MiddleServiceFallback;

@FeignClient(path="/demo",name="spring-cloud-middle-demo",fallback=MiddleServiceFallback.class)
public interface IMiddleService{
    @RequestMapping("/middle")
    public String testMiddleMethod(@RequestParam(value="name") String name);
}