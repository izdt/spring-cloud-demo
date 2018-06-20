package com.abc.sc.providerdemo.controller;

import com.abc.sc.providerdemo.model.DemoRequest;
import com.abc.sc.providerdemo.model.DemoResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
class DemoController{
    @Value("${server.port}")
    private String port;
    @Value("${app.config.delay}")
    private int delay;
    @PostMapping("/hello")
    public DemoResponse helloWorld(@RequestBody DemoRequest request) throws Exception{
        Thread.sleep(delay);
        DemoResponse response = new DemoResponse();
        response.setId(request.getId());
        response.setName(request.getName());
        response.setItems(request.getItems());
        response.setPort(port);
		return response;
    }
}