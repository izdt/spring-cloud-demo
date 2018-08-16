package com.abc.sc.providerdemoapi;

import com.abc.sc.providerdemoapi.entity.HelloEntity;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import io.swagger.annotations.ApiOperation;

public interface HelloApiService {
    @PostMapping("/v1/HELLO001")
    @ApiOperation(value = "HELLO001查询用户信息(V1)", notes = "获取所有用户信息")    
    HelloEntity testHello(@RequestBody HelloEntity request);
}