package com.abc.sc.consumerdemo.controller;
import com.abc.sc.consumerdemo.service.IHelloService;
import com.abc.sc.consumerdemo.service.IHelloServiceWithRibbon;
import com.abc.sc.consumerdemo.service.IMiddleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController{
    @Autowired
    private IHelloService service;
    @Autowired
    private IHelloServiceWithRibbon ribbonService;
    @Autowired
    private IMiddleService middleService;

    @RequestMapping("/hello/{name}")
    public String sayHello(@PathVariable(value="name") String name){
        return service.testHelloWorld(name); 
    }
    @RequestMapping("/ribbon/{name}")
    public String sayHelloFromRibbon(@PathVariable(value="name") String name){
        return ribbonService.testHelloMethod(name); 
    }
    @RequestMapping("/show/{name}")
    public String showTrace(@PathVariable(value="name") String name){
        return middleService.testMiddleMethod(name); 
    }
}