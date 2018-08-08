package com.abc.sc.providerdemo.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.abc.sc.providerdemoapi.HelloApiService;
import com.abc.sc.providerdemoapi.entity.HelloEntity;

@RestController
class HelloApiController implements HelloApiService{
    @Override
	public HelloEntity testHello(@RequestBody HelloEntity request) {
        request.setMessage("new message");
        return request;
	}
}