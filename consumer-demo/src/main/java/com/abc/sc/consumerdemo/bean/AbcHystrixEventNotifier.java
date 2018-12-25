package com.abc.sc.consumerdemo.bean;

import java.lang.invoke.MethodHandles;

import com.netflix.hystrix.HystrixCommandKey;
import com.netflix.hystrix.HystrixEventType;
import com.netflix.hystrix.strategy.eventnotifier.HystrixEventNotifier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class AbcHystrixEventNotifier extends HystrixEventNotifier {
    private static final Logger log = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    @Override
    public void markEvent(HystrixEventType eventType, HystrixCommandKey key) {
        //log.debug("EventType is: %s, CommandKey is: %s",eventType.name(),key.name());
        switch(eventType){
            case EXCEPTION_THROWN:
            case FALLBACK_MISSING:

            case BAD_REQUEST:
            case FAILURE:
            case TIMEOUT:{
                log.error("Hsytrix {}, key: {}", eventType.name(),  key.name());
                break;
            }
            case FALLBACK_SUCCESS:{
                log.info("Hsytrix {}, key: {}", eventType.name(),  key.name());
                break;
            }
            default:{
                log.debug("EventType is: {}, CommandKey is: {}",eventType.name(),key.name());
            }
        }
    }
}