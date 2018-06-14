package com.abc.sc.middledemo.controller;

import com.abc.sc.middledemo.service.IHelloService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
class MiddleController{
    @Value("${server.port}")
    private String port;
    @Autowired
    private IHelloService service;
    @RequestMapping("/middle")
    public String middleMethod(@RequestParam String name){
        String providerString = service.testHelloWorld(name);
        return "Middle Server from "+port+", remote message: "+providerString;
    }
}