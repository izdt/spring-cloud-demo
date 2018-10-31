package com.abc.sc.consumerdemo.bean;

import org.springframework.stereotype.Component;

import feign.RequestInterceptor;
import feign.RequestTemplate;

@Component
public class FeignInterceptor implements RequestInterceptor{
    
    @Override
    public void apply(RequestTemplate requestTemplate) {
        requestTemplate.header("hotelId", "111111");
	}
}