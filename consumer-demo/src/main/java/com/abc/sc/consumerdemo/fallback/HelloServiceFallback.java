package com.abc.sc.consumerdemo.fallback;

import com.abc.sc.consumerdemo.service.IHelloService;
import org.springframework.stereotype.Component;

@Component
public class HelloServiceFallback implements IHelloService{
	@Override
	public String testHelloWorld(String name) {
		return "service not available";
	}
}