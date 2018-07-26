package com.abc.sc.consumerdemo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AllController{
    @RequestMapping(value="/*/*",produces = "application/json")
    public String sayHello(){
       return "{\"name\":\"hello\"}";
    }

    @PostMapping(value="**",produces = "application/json")
    public ResponseEntity<String> handleRequest(RequestEntity<String> request){
        String requestBody = request.getBody();
        String requestPath = request.getUrl().getPath();

        System.out.println(requestBody);
        System.out.println(requestPath);

        String responseBody = "{\"name\":\"hello\"}";
        ResponseEntity<String> responseEntity = new ResponseEntity<>(responseBody,
        HttpStatus.OK);
        return responseEntity;
    }

}