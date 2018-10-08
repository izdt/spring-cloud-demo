package com.abc.sc.zipkinserver.bean;

import com.abc.sc.zipkinserver.utility.LogInitializer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LogInitializerBean {
    @Bean
    public Runnable logInitializer() {
        String zipkinLogLevel = System.getenv("ZIPKIN_LOG_LEVEL");
        if (zipkinLogLevel == null) zipkinLogLevel = "INFO";
        Runnable logInitializer = LogInitializer.create(zipkinLogLevel);
        logInitializer.run(); 
        return logInitializer;
    }
}