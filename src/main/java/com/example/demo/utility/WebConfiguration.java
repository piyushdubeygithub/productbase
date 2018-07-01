package com.example.demo.utility;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class WebConfiguration extends WebSecurityConfigurerAdapter {
	
    @Override
	 protected void configure(HttpSecurity http) throws Exception {
         System.out.println("configure");
                 http.csrf().disable();
                 http.authorizeRequests().antMatchers("/").permitAll();
     }

}