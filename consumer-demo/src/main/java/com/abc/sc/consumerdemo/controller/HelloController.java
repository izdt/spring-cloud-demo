package com.abc.sc.consumerdemo.controller;
import com.abc.sc.consumerdemo.service.IHelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController{
    @Autowired
    private IHelloService service;
    @RequestMapping("/hello/{name}")
    public String sayHello(@PathVariable(value="name") String name){
        return service.testHelloWorld(name); 
    }
}