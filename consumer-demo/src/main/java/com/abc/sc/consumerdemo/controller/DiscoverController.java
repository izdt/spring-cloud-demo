package com.abc.sc.consumerdemo.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.netflix.appinfo.ApplicationInfoManager;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.EurekaClientConfig;
import com.netflix.discovery.EurekaEvent;
import com.netflix.discovery.EurekaEventListener;
import com.netflix.discovery.shared.Application;
import com.netflix.discovery.shared.Applications;

import com.netflix.discovery.shared.resolver.DefaultEndpoint;
import com.netflix.discovery.shared.transport.EurekaHttpClient;
import com.netflix.discovery.shared.transport.EurekaHttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.netflix.eureka.http.RestTemplateTransportClientFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class DiscoverController{

    @Autowired
    private DiscoveryClient discoveryClient;
    @Autowired 
    private EurekaClient eurekaClient;
    @Autowired
    EurekaClientConfig eurekaConfig;

    @Autowired
    private ApplicationInfoManager appInfoManager;
    @Value("${abc.config.serviceUrl}")
    private String envStr;

    @RequestMapping("/getEnv")
    public String getEnv(){
        
        return envStr;
    }

    @RequestMapping("/testUpdateEureka")
    public InstanceInfo updateEurekaTest(){

        /*
        eurekaClient.registerEventListener(new EurekaEventListener() {
            @Override
            public void onEvent(EurekaEvent event) {


            }
        });
        */
        EurekaHttpClient eurekaHttpClient = new RestTemplateTransportClientFactory()
                .newClient(new DefaultEndpoint("http://abc:abcabc@localhost:10101/eureka"));
        //eurekaHttpClient.register(appInfoManager.getInfo());
        InstanceInfo providerInstanceInfo =  eurekaHttpClient.getInstance("SPRING-CLOUD-PROVIDER-DEMO","VAIO:spring-cloud-provider-demo:10201").getEntity();
        eurekaHttpClient.statusUpdate("SPRING-CLOUD-PROVIDER-DEMO","VAIO:spring-cloud-provider-demo:10201", InstanceInfo.InstanceStatus.OUT_OF_SERVICE,providerInstanceInfo);
        eurekaHttpClient.cancel("SPRING-CLOUD-PROVIDER-DEMO","VAIO:spring-cloud-provider-demo:10201");
        EurekaHttpResponse<InstanceInfo> respInfo =  eurekaHttpClient.getInstance("SPRING-CLOUD-CONSUMER-DEMO","VAIO:spring-cloud-consumer-demo:10301");
        return respInfo.getEntity();
        /*
        if(eurekaClient instanceof  CloudEurekaClient){
            CloudEurekaClient cloudEurekaClient = (CloudEurekaClient)eurekaClient;
            return cloudEurekaClient.getInstanceInfo("SPRING-CLOUD-CONSUMER-DEMO","VAIO:spring-cloud-consumer-demo:10301");
        }
        return null;
        */
        /*
        AbstractJerseyEurekaHttpClient eurekaHttpClient = (AbstractJerseyEurekaHttpClient)eurekaClient;
        eurekaHttpClient.register(appInfoManager.getInfo());
        */
    }

    @RequestMapping("/testEureka")
    public Applications getTestApps(){
        Map<String,String> meta = new HashMap<String,String>();
        meta.put("appid-test", "value");
        appInfoManager.registerAppMetadata(meta);
        appInfoManager.refreshLeaseInfoIfRequired();
        
        //dynamic add metadata and send it by heartbeat
        appInfoManager.getInfo().getMetadata().put("appid-new-2","ABC-D");

        //eurekaConfig.getMetadataMap().put("appid-new","ABC");



        Applications apps = eurekaClient.getApplications();
        List<Application> regedApps = apps.getRegisteredApplications();
        for (Application app : regedApps) {
            app.getInstances();
        }
        return apps;
    }


    @RequestMapping("/apps")
    public Applications getApps(){
        
        Applications apps = eurekaClient.getApplications();
        List<Application> regedApps = apps.getRegisteredApplications();
        for (Application app : regedApps) {
            app.getInstances();
        }
        return apps;
    }


    @RequestMapping("/apps/{name}")
    public List<InstanceInfo> getInstances(@PathVariable(value="name") String name){
        Application app = eurekaClient.getApplication(name);
        return app.getInstances();
    }

    @RequestMapping("/servers")
    public List<String> getServices(){
       List<String> servers = discoveryClient.getServices();
       for(String server : servers){
          List<ServiceInstance> instances =  discoveryClient.getInstances(server);

       }
       return discoveryClient.getServices();
    }

    
    @RequestMapping("/servers/{name}")
    public List<ServiceInstance> getServerInstances(@PathVariable(value="name") String name){
        List<ServiceInstance> instances =  discoveryClient.getInstances(name);
        return instances;
    }
}