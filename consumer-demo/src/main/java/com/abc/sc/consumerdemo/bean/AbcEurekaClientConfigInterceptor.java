package com.abc.sc.consumerdemo.bean;

import com.netflix.discovery.EurekaClientConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.eureka.EurekaClientConfigBean;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component//("eurekaClientConfigInterceptor")
public class AbcEurekaClientConfigInterceptor implements EurekaClientConfigInterceptor {
    Logger logger = LoggerFactory.getLogger(getClass());
    @Override
    public void apply(EurekaClientConfig config) {
        if(config instanceof  EurekaClientConfigBean){
            EurekaClientConfigBean configBean = (EurekaClientConfigBean) config;
            logger.info("Eureka Config {}",configBean);
            Map<String, String> serviceUrls = new HashMap<>();
            serviceUrls.put("defaultZone", "http://127.0.0.1:8762/eureka/");
            configBean.setServiceUrl(serviceUrls);
        }
    }
}
