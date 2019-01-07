package com.abc.sc.consumerdemo.bean;

import java.lang.invoke.MethodHandles;
import java.util.Arrays;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.netflix.discovery.CacheRefreshedEvent;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.EurekaEvent;
import com.netflix.discovery.EurekaEventListener;
import com.netflix.discovery.StatusChangeEvent;
import com.netflix.discovery.shared.Applications;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Component;

@Component
public class DiscoverEventListener implements EurekaEventListener {
    private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    //protected final Log logger = LogFactory.getLog(getClass());
    @Autowired
    private DiscoveryClient discoveryClient;
    @Autowired
    private EurekaClient eurekaClient;

    private Applications currentApps;
    private String currentAppHashCode="N/A";
    @Override
    public void onEvent(EurekaEvent event) {
        if(event instanceof CacheRefreshedEvent){
            Applications apps = eurekaClient.getApplications();
            String hashcode = apps.getReconcileHashCode();
            if(!currentAppHashCode.equals(hashcode)){
                logger.info("Eureka Applications has been changed, current hashcode {}, previous hashcode {}",hashcode,currentAppHashCode);
                if(logger.isDebugEnabled()){
                    ObjectMapper mapper = new ObjectMapper();
                    try {
                        String preStr = mapper.writeValueAsString(currentApps);
                        String appStr = mapper.writeValueAsString(apps);
                        logger.debug("current applications:{}, previous applications:{}", appStr,preStr);
                    } catch (JsonProcessingException e) {
                        logger.error("Format eureka applications failed, exception: {}", e.getMessage());
                    }
                }
                currentAppHashCode = hashcode;
                currentApps = apps;
            }
            logger.info("{}, services: {}",event.toString(),Arrays.toString(discoveryClient.getServices().toArray()));
        }
        if(event instanceof StatusChangeEvent){
            //StatusChangeEvent scEvent = (StatusChangeEvent)event;
            //scEvent.getStatus().DOWN
            logger.info(event.toString());
        }
	}
}