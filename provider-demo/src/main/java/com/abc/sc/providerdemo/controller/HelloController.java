package com.abc.sc.providerdemo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
class HelloController{
    @Value("${server.port}")
    private String port;
    @Value("${app.config.delay}")
    private int delay;
    @RequestMapping("/hello")
    public String helloWorld(@RequestParam String name) throws Exception{
        Thread.sleep(delay);
        return "hello " + name + ", from " + port;
    }
}