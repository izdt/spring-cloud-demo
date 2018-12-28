package com.abc.sc.consumerdemo.config;

import com.abc.sc.consumerdemo.bean.DiscoverEventListener;
import com.netflix.discovery.EurekaClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DiscoverConfiguration{
    @Autowired
    private DiscoverEventListener eventListener;

    @Autowired
    public void run(){
        discoveryClient.registerEventListener(eventListener);
    }
}