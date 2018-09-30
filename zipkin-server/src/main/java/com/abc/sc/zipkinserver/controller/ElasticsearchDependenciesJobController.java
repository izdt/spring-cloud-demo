package com.abc.sc.zipkinserver.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

 
@RestController
public class ElasticsearchDependenciesJobController{
    @RequestMapping("/run")
    public String runJob(@RequestParam String date){
        
        return "Run!";
    }
   
}