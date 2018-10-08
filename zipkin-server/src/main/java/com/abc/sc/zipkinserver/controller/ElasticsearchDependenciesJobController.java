package com.abc.sc.zipkinserver.controller;

import com.abc.sc.zipkinserver.utility.ZipkinDependenciesUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import zipkin2.dependencies.elasticsearch.ElasticsearchDependenciesJob;

 
@RestController
public class ElasticsearchDependenciesJobController{
    @Autowired
    Runnable logInitializer;

    @RequestMapping("/run")
    public String runJob(@RequestParam(required=false) String date) throws Exception {
        String[] jarPath = ZipkinDependenciesUtility.pathToUberJar();
        long day = date!=null? ZipkinDependenciesUtility.parseDay(date) : System.currentTimeMillis();
        ElasticsearchDependenciesJob.builder()
        .logInitializer(logInitializer)
        .jars(jarPath)
        .day(day)
        .build()
        .run();
        return "Run!"+day;
    }
   
}