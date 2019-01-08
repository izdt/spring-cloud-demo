package com.abc.sc.eurekaserver.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity

public class WebSecurityConfig{
  @Configuration
  @Order(1)
  public class EurekaApiSecurityConfig extends WebSecurityConfigurerAdapter {
      @Override
      protected void configure(HttpSecurity http) throws Exception {
        http//.antMatcher("/eureka/**")
				.authorizeRequests()
          .anyRequest().hasRole("APP")
          //.anyRequest().authenticated()
					.and()
        .httpBasic().and().csrf().disable();
        /*
        http
          .authorizeRequests()
          .anyRequest().authenticated()
          .and().httpBasic().and().csrf().disable();
        */
      }
  }
  //@Configuration
  public class WebAdminSecurityConfig extends WebSecurityConfigurerAdapter {
      @Override
      protected void configure(HttpSecurity http) throws Exception {
        http
          .formLogin().loginPage("/login")
          .failureUrl("/login?failed")
          .loginProcessingUrl("/auth/login")
          .and()
          .authorizeRequests()
          .antMatchers("/login","/auth/login").permitAll()
          .anyRequest().authenticated();
      }
  }
}




/*
@Configuration
@EnableWebSecurity
public class BasicConfiguration extends WebSecurityConfigurerAdapter {
 
    @Override
    protected void configure(AuthenticationManagerBuilder auth)
      throws Exception {
        auth
          .inMemoryAuthentication()
          .withUser("user")
            .password("password")
            .roles("USER")
            .and()
          .withUser("admin")
            .password("admin")
            .roles("USER", "ADMIN");
    }
 
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
          .authorizeRequests()
          .anyRequest()
          .authenticated()
          .and()
          .httpBasic();
    }
}

*/