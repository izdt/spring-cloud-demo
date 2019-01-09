package com.abc.sc.consumerdemo.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class EurekaClientConfigAspect {
    Logger logger = LoggerFactory.getLogger(getClass());
    //@Pointcut("bean(eurekaClientConfigBean)")
    public void pointcut() {
    }
    //@After("pointCut()")
    public void after() {
        System.out.println("after ......");
    }
    //@Around("execution(* org.springframework.cloud.netflix.eureka.EurekaClientConfigBean.*(..))")
    public Object apiMappingAccess (ProceedingJoinPoint joinPoint) throws Throwable {
        Object[] parames = joinPoint.getArgs();
        logger.info("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        System.out.println("before ......");
        Object invocationResult = joinPoint.proceed();
        System.out.println("after ......");
        return invocationResult;
    }
}
