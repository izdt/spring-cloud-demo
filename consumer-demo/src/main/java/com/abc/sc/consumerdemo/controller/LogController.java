package com.abc.sc.consumerdemo.controller;

import java.lang.invoke.MethodHandles;

import com.abc.sc.consumerdemo.service.IHelloService;
import com.abc.sc.consumerdemo.service.IHelloServiceWithRibbon;
import com.abc.sc.consumerdemo.service.IMiddleService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import brave.Tracer;


@RestController
public class LogController{
    private static final Logger log = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    @Autowired
    private Tracer tracer;
    @Autowired
    private IHelloService service;
    @Autowired
    private IHelloServiceWithRibbon ribbonService;
    @Autowired
    private IMiddleService middleService;

    @RequestMapping("/log/hello/{name}")
    public String sayHello(@PathVariable(value="name") String name){
        log.info("Hello from spring cloud consumer sayHello with "+name);
        //tracer.currentSpan().context();
        tracer.currentSpan().tag("hello name", name);
        return service.testHelloWorld(name); 
    }
    @RequestMapping("/log/ribbon/{name}")
    public String sayHelloFromRibbon(@PathVariable(value="name") String name){
        log.info("Hello from spring cloud consumer sayHelloFromRibbon with "+name);
        return ribbonService.testHelloMethod(name); 
    }
    @RequestMapping("/log/show/{name}")
    public String showTrace(@PathVariable(value="name") String name){
        log.info("Hello from spring cloud consumer showTrace with "+name);
        return middleService.testMiddleMethod(name); 
    }
}