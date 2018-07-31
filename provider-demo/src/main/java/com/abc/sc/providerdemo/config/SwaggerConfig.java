package com.abc.sc.providerdemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
class SwaggerConfig{
    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
        .select()
        .apis(RequestHandlerSelectors.basePackage("com.abc.sc.providerdemo"))
        .paths(PathSelectors.any())
        .build();
    }
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
        .title("Spring Boot示例")
        .description("rest api 文档")
        .termsOfServiceUrl("http:/localhost/")
        .version("1.0")
        .build();
    }
}