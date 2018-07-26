package com.abc.sc.zuuldemo.filter;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.Charset;

import javax.servlet.http.HttpServletRequest;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

import org.springframework.util.StreamUtils;

public class DemoFilter extends ZuulFilter{

	@Override
	public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        try {
            InputStream in = (InputStream) ctx.get("requestEntity");
            if (in == null) {
                in = request.getInputStream();
            }
            String body = StreamUtils.copyToString(in, Charset.forName("UTF-8"));
            body = body.toUpperCase();//TODO
            ctx.set("requestEntity", new ByteArrayInputStream(body.getBytes("UTF-8")));
        } catch (Exception e) {
            //TODO: handle exception
        }
        System.out.println(String.format("%s DemoFilter request to %s", request.getMethod(), request.getRequestURL().toString()));        
        return request;
	}

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public int filterOrder() {
		return 0;
	}

	@Override
	public String filterType() {
		return "pre";
	}

}