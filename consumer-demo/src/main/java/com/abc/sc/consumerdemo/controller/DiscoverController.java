package com.abc.sc.consumerdemo.controller;



import java.util.List;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;
import com.netflix.discovery.shared.Applications;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DiscoverController{

    @Autowired
    private DiscoveryClient discoveryClient;
    @Autowired 
    private EurekaClient eurekaClient;

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