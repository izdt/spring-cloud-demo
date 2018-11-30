package com.abc.sc.consumerdemo.controller;

import java.lang.invoke.MethodHandles;

import com.abc.sc.consumerdemo.service.IHelloService;
import com.abc.sc.consumerdemo.service.IHelloServiceWithRibbon;
import com.abc.sc.consumerdemo.service.IMiddleService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.metrics.MetricsEndpoint;
import org.springframework.boot.actuate.metrics.MetricsEndpoint.MetricResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import brave.Span;
import brave.Tracer;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Timer;


@RestController
public class LogController{
    private static final Logger log = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Autowired
    private Tracer tracer;
    @Autowired
    private IHelloService service;
    @Autowired
    private IHelloServiceWithRibbon ribbonService;
    @Autowired
    private IMiddleService middleService;
    @Autowired
    private MetricsEndpoint metricsEndpoint;
    @Autowired
    private MeterRegistry metricRegistry;    
  
    @Bean
    public Timer getTimer(){
        //Will add tag to all metrics
        metricRegistry.config().commonTags("serviceid","consumer-service","appid","SDC20170301");
        return metricRegistry.timer("acm.requests", "trcode","TESTO001");
    }
    @Autowired
    private Timer timer;  

    @RequestMapping("/log/hello/{name}")
    public String sayHello(@PathVariable(value="name") String name){
        log.info("Hello from spring cloud consumer sayHello with "+name);
        Span span = tracer.currentSpan();
        //tracer.currentSpan().context();
        span.annotate("request_send");
        span.tag("hello name", name);
        return service.testHelloWorld(name); 
    }
    @RequestMapping("/log/ribbon/{name}")
    public String sayHelloFromRibbon(@PathVariable(value="name") String name){
        log.info("Hello from spring cloud consumer sayHelloFromRibbon with "+name);
        return ribbonService.testHelloMethod(name); 
    }
    @RequestMapping("/log/show/{name}")
    public String showTrace(@PathVariable(value="name") String name){
        log.info("Hello from spring cloud consumer showTrace with "+name);
        return middleService.testMiddleMethod(name); 
    }
    @RequestMapping("/log/metrics/{name}")
    public MetricResponse showMetrics(@PathVariable(value="name") String name){
        Long random = (long) (Math.random() * 100);
        Timer.Sample sample = Timer.start(metricRegistry);
        try {
            Thread.sleep(random);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        sample.stop(timer);

        // Counter conunter = metricRegistry.find(name).counter();
        // metricRegistry.counter(name, tags);

        return metricsEndpoint.metric(name, null);
    }
}