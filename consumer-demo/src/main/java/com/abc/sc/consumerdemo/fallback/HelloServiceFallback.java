package com.abc.sc.consumerdemo.fallback;

import java.lang.invoke.MethodHandles;

import com.abc.sc.consumerdemo.service.IHelloService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class HelloServiceFallback implements IHelloService{
    private static final Logger log = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
	
	public String testHelloWorld(String name, Throwable e) {
		log.error(e.getMessage(), e);
		return testHelloWorld(name);
	}

	@Override
	public String testHelloWorld(String name) {
		return "hello service not available";
	}
}