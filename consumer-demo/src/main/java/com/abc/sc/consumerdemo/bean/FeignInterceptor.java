package com.abc.sc.consumerdemo.bean;

import java.io.Console;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import feign.RequestInterceptor;
import feign.RequestTemplate;

@Component
public class FeignInterceptor implements RequestInterceptor{
    @Bean
    public ObjectMapper getObjectMapper(){
        ObjectMapper mapper = new ObjectMapper();
        return mapper;
    }
    @Autowired
    private ObjectMapper mapper;

    @Override
    public void apply(RequestTemplate template) {
        template.header("hotelId", "111111");
        try{
            JsonNode bodyNode = mapper.readTree(template.body());
            //String body1 =  new String(template.body(),"UTF-8");
            //String body = mapper.writeValueAsString(bodyNode);

            JsonNode node = mapper.readTree("{\"id\":1,\"name\":\"name\",\"data\":null}");
            ObjectNode nodeNew = (ObjectNode) node;
            String body = mapper.writeValueAsString(nodeNew);
            node = nodeNew.set("data", bodyNode);
            String newBody = mapper.writeValueAsString(node);
            template.body(newBody);
            System.out.println(template);
            //JsonNode node = mapper.readTree(template.body());
            

        }catch(Exception e){
            System.out.println(e.getMessage());
        }
	}
}