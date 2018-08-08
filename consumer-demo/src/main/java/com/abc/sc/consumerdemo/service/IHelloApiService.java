package com.abc.sc.consumerdemo.service;

import com.abc.sc.providerdemoapi.HelloApiService;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name="spring-cloud-provider-demo")
public interface IHelloApiService extends HelloApiService{
}