package com.abc.sc.consumerdemo.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.core.annotation.AliasFor;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@FeignClient
public @interface AlphaClient {
	
	@AliasFor(annotation=FeignClient.class)
	String value() default "";

	@AliasFor(annotation=FeignClient.class)
    String name() default "";
    
    @AliasFor(annotation=FeignClient.class)
    String qualifier() default "";
    
    @AliasFor(annotation=FeignClient.class)
    String url() default "";
    
    @AliasFor(annotation=FeignClient.class)
	Class<?>[] configuration() default {};

	@AliasFor(annotation=FeignClient.class)
	Class<?> fallback() default void.class;

    @AliasFor(annotation=FeignClient.class)
	Class<?> fallbackFactory() default void.class;

	@AliasFor(annotation=FeignClient.class)
	String path() default "";

	@AliasFor(annotation=FeignClient.class)
	boolean primary() default true;

}
