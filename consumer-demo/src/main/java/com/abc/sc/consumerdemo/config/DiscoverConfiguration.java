package com.abc.sc.consumerdemo.config;

import java.util.*;

import com.abc.sc.consumerdemo.bean.DiscoverEventListener;
import com.netflix.appinfo.ApplicationInfoManager;
import com.netflix.discovery.DefaultEurekaClientConfig;
import com.netflix.discovery.DiscoveryClient;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.EurekaClientConfig;

import com.netflix.discovery.shared.transport.jersey.EurekaJerseyClientImpl;
import com.sun.jersey.api.client.filter.ClientFilter;
import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.SearchStrategy;
import org.springframework.cloud.netflix.eureka.EurekaClientAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EurekaClientConfigBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import javax.annotation.PostConstruct;

@Configuration
//@AutoConfigureAfter(EurekaClientAutoConfiguration.class)
public class DiscoverConfiguration{
    @Autowired
    private EurekaClient discoveryClient;
    @Autowired
    private DiscoverEventListener eventListener;
    @Autowired
    private ApplicationInfoManager appInfoManager;
    @Autowired
    private EurekaClientConfigBean eurekaClientConfigBean;
    @Autowired
    EurekaClientConfig eurekaConfig;


    @PostConstruct
    public void run(){
        discoveryClient.registerEventListener(eventListener);
        appInfoManager.getInfo().getMetadata().put("appid-new","ABC");

        Map<String, String> serviceUrls = new HashMap<>();
        //serviceUrls.put("defaultZone", "http://abc:abcabc@localhost:10101/eureka/");

        eurekaClientConfigBean.setServiceUrl(serviceUrls);
    }
    @Bean
    @ConditionalOnMissingBean(DiscoveryClient.DiscoveryClientOptionalArgs.class)
    public DiscoveryClient.DiscoveryClientOptionalArgs discoveryClientOptionalArgs(){

        DiscoveryClient.DiscoveryClientOptionalArgs args = new DiscoveryClient.DiscoveryClientOptionalArgs();
        /*
        EurekaJerseyClientImpl.EurekaJerseyClientBuilder builder = new EurekaJerseyClientImpl.EurekaJerseyClientBuilder();
        args.setEurekaJerseyClient(builder.build());
        */
        List<ClientFilter> filters = new ArrayList<>();
        filters.add(new HTTPBasicAuthFilter("abc", "abcabc"));
        args.setAdditionalFilters(filters);
        return args;
    }
    //@Bean
    public EurekaClientConfig eurekaClientConfigBean() {
        //EurekaClientConfigBean eurekaClientConfigBean = new EurekaClientConfigBean();

        Map<String, String> serviceUrls = new HashMap<>();
        serviceUrls.put("defaultZone", "http://127.0.0.1:8762/eureka/");
        eurekaClientConfigBean.setServiceUrl(serviceUrls);



        /*
        Map<String, String> env = System.getenv();

        if (env.get("REGISTRY_SERVICE_HOST") != null) {

            String host = env.get("REGISTRY_SERVICE_HOST");
            Map<String, String> serviceUrls = new HashMap<>();
            serviceUrls.put("defaultZone", "http://"+host+":8761/eureka/");
            eurekaClientConfigBean.setServiceUrl(serviceUrls);

        }
        */
        return eurekaClientConfigBean;
    }
}