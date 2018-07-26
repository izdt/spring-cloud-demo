package com.abc.sc.zuuldemo.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
class HelloController{

    @RequestMapping("/hello/{name}")
    public String sayHello(@PathVariable(value="name") String name){
		  return "hello " + name;
    }
}