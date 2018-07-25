package com.abc.sc.consumerdemo.controller;
import java.util.ArrayList;

import com.abc.sc.consumerdemo.model.DemoItem;
import com.abc.sc.consumerdemo.model.DemoRequest;
import com.abc.sc.consumerdemo.model.DemoResponse;
import com.abc.sc.consumerdemo.service.IRestService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloRestController{
    @Bean
    public ObjectMapper getObjectMapper(){
        ObjectMapper mapper = new ObjectMapper();
        return mapper;
    }
    @Autowired
    private ObjectMapper mapper;

    @Autowired
    private IRestService service;

    @RequestMapping({"/rest/{name}","/test/{name}"})
    public DemoResponse sayHelloWithRest(@PathVariable(value="name") String name) throws Exception{
        DemoRequest request = new DemoRequest();
        request.setId(1);
        request.setName(name);
        request.setData("DEMO-FOR-A-LONG-STRING-DEMO-FOR-A-LONG-STRING-DEMO-FOR-A-LONG-STRING-DEMO-FOR-A-LONG-STRING-DEMO-FOR-A-LONG-STRING-DEMO-FOR-A-LONG-STRING-DEMO-FOR-A-LONG-STRING-DEMO-FOR-A-LONG-STRING-DEMO-FOR-A-LONG-STRING-DEMO-FOR-A-LONG-STRING-DEMO-FOR-A-LONG-STRING-DEMO-FOR-A-LONG-STRING-DEMO-FOR-A-LONG-STRING-DEMO-FOR-A-LONG-STRING-DEMO-FOR-A-LONG-STRING-DEMO-FOR-A-LONG-STRING-DEMO-FOR-A-LONG-STRING-DEMO-FOR-A-LONG-STRING-DEMO-FOR-A-LONG-STRING-DEMO-FOR-A-LONG-STRING-DEMO-FOR-A-LONG-STRING-DEMO-FOR-A-LONG-STRING-DEMO-FOR-A-LONG-STRING-DEMO-FOR-A-LONG-STRING-DEMO-FOR-A-LONG-STRING-DEMO-FOR-A-LONG-STRING-DEMO-FOR-A-LONG-STRING-DEMO-FOR-A-LONG-STRING-DEMO-FOR-A-LONG-STRING-DEMO-FOR-A-LONG-STRING-DEMO-FOR-A-LONG-STRING-DEMO-FOR-A-LONG-STRING-DEMO-FOR-A-LONG-STRING-DEMO-FOR-A-LONG-STRING-DEMO-FOR-A-LONG-STRING-DEMO-FOR-A-LONG-STRING-DEMO-FOR-A-LONG-STRING-DEMO-FOR-A-LONG-STRING-DEMO-FOR-A-LONG-STRING-DEMO-FOR-A-LONG-STRING-DEMO-FOR-A-LONG-STRING-DEMO-FOR-A-LONG-STRING-DEMO-FOR-A-LONG-STRING-DEMO-FOR-A-LONG-STRING-DEMO-FOR-A-LONG-STRING-DEMO-FOR-A-LONG-STRING-DEMO-FOR-A-LONG-STRING-DEMO-FOR-A-LONG-STRING-DEMO-FOR-A-LONG-STRING-DEMO-FOR-A-LONG-STRING-DEMO-FOR-A-LONG-STRING-DEMO-FOR-A-LONG-STRING-DEMO-FOR-A-LONG-STRING-DEMO-FOR-A-LONG-STRING-DEMO-FOR-A-LONG-STRING-DEMO-FOR-A-LONG-STRING-DEMO-FOR-A-LONG-STRING-DEMO-FOR-A-LONG-STRING-DEMO-FOR-A-LONG-STRING-DEMO-FOR-A-LONG-STRING-DEMO-FOR-A-LONG-STRING-DEMO-FOR-A-LONG-STRING-DEMO-FOR-A-LONG-STRING-DEMO-FOR-A-LONG-STRING-DEMO-FOR-A-LONG-STRING-DEMO-FOR-A-LONG-STRING-DEMO-FOR-A-LONG-STRING-DEMO-FOR-A-LONG-STRING-DEMO-FOR-A-LONG-STRING-DEMO-FOR-A-LONG-STRING-DEMO-FOR-A-LONG-STRING");
        DemoItem item1 = new DemoItem("123456789", "Address1");
        DemoItem item2 = new DemoItem("123456789", "Address2");
        DemoItem item3 = new DemoItem("123456789", "Address3");
        ArrayList<DemoItem> items = new ArrayList<DemoItem>();
        items.add(item1);
        items.add(item2);
        items.add(item3);
        request.setItems(items);
        String json = mapper.writeValueAsString(request);
        String responseString =  service.execute("spring-cloud-provider-demo","/hello",json); 
        DemoResponse response = mapper.readValue(responseString, DemoResponse.class); 
        return response;
    }
}