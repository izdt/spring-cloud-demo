package com.abc.sc.consumerdemo.bean;

import java.lang.invoke.MethodHandles;

import com.netflix.hystrix.HystrixInvokable;
import com.netflix.hystrix.HystrixInvokableInfo;
import com.netflix.hystrix.strategy.executionhook.HystrixCommandExecutionHook;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class AbcHystrixCommandExecutionHook extends HystrixCommandExecutionHook {
    private static final Logger log = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
   
    @Override
    public <T> Exception onExecutionError(HystrixInvokable<T> commandInstance, Exception e) {
        //log.debug(e.getStackTrace().toString());
        if(commandInstance instanceof HystrixInvokableInfo) {
            HystrixInvokableInfo invokableInfo = (HystrixInvokableInfo)commandInstance;
            
            String name = invokableInfo.getCommandKey().name();
            //invokableInfo.getExecutionEvents();
            //String fe = invokableInfo.getFailedExecutionException().toString();
            log.info("Hystrix execution at {}, exception message:{} ,cause:", name, e.getMessage(), e.getCause());
            //do something with specfied exception here
            log.error(e.getMessage());
        }
        return e;
    }
}