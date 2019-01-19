package com.abc.sc.consumerdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
//@EnableEurekaClient
@EnableFeignClients
@EnableHystrix
@EnableCircuitBreaker
@EnableHystrixDashboard
public class ConsumerDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsumerDemoApplication.class, args);
	}
}
