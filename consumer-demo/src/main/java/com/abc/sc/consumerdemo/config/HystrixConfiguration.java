package com.abc.sc.consumerdemo.config;

import javax.annotation.PostConstruct;

import com.abc.sc.consumerdemo.bean.AbcHystrixCommandExecutionHook;
import com.abc.sc.consumerdemo.bean.AbcHystrixEventNotifier;
import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import com.netflix.hystrix.strategy.HystrixPlugins;
import com.netflix.hystrix.strategy.eventnotifier.HystrixEventNotifier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HystrixConfiguration {
    @Autowired
    AbcHystrixEventNotifier abcHystrixEventNotifier;
    @Autowired
    AbcHystrixCommandExecutionHook abcHystrixCommandExecutionHook;

    @PostConstruct
    public void init(){
        HystrixPlugins.getInstance().registerEventNotifier(abcHystrixEventNotifier);
    }

    @Autowired
    public void configHystrixPlugin() {
        HystrixPlugins.getInstance().registerCommandExecutionHook(abcHystrixCommandExecutionHook);
    }

    
    @Bean
    public ServletRegistrationBean<HystrixMetricsStreamServlet> getServlet(){
        HystrixMetricsStreamServlet hystrixMetricsStreamServlet = new HystrixMetricsStreamServlet();
        ServletRegistrationBean<HystrixMetricsStreamServlet> servletRegistrationBean = new ServletRegistrationBean<HystrixMetricsStreamServlet>();
        servletRegistrationBean.setServlet(hystrixMetricsStreamServlet);
        servletRegistrationBean.addUrlMappings("/hystrix.stream");
        servletRegistrationBean.setName("HystrixMetricsStreamServlet");
        return servletRegistrationBean;
    }

}