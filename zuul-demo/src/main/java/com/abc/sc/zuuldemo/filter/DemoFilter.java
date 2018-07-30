package com.abc.sc.zuuldemo.filter;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import javax.servlet.http.HttpServletRequest;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

import org.springframework.util.StreamUtils;
import static com.netflix.zuul.context.RequestContext.getCurrentContext;

public class DemoFilter extends ZuulFilter{

	@Override
	public boolean shouldFilter() {
		return true;
	}
	@Override
	public Object run() {
		try {
			RequestContext context = getCurrentContext();
            HttpServletRequest request=(HttpServletRequest)context.getRequest();
			InputStream is=request.getInputStream();
			/*
			InputStream in = (InputStream) context.get("requestEntity");
			if (in == null) {
				in = context.getRequest().getInputStream();
			}
			*/
			String body = StreamUtils.copyToString(is, Charset.forName("UTF-8"));
			body = body.toUpperCase();
			context.set("requestEntity", new ByteArrayInputStream(body.getBytes("UTF-8")));
			System.out.println("Request content:"+body);
        } catch (IOException e) {
			e.printStackTrace();
        }
		return null;
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