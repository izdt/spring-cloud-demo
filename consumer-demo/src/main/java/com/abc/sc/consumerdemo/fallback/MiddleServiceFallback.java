package com.abc.sc.consumerdemo.fallback;

import com.abc.sc.consumerdemo.service.IMiddleService;

import org.springframework.stereotype.Component;

@Component
public class MiddleServiceFallback implements IMiddleService{

	@Override
	public String testMiddleMethod(String name) {
		return "service not available";
	}
}