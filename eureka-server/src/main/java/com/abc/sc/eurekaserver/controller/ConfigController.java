package com.abc.sc.eurekaserver.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
class ConfigController{

    @RequestMapping("/hello/{name}")
    public String sayHello(@PathVariable(value="name") String name){
		  return "hello " + name;
    }
}