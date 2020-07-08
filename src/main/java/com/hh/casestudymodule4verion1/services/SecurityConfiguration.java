package com.hh.casestudymodule4verion1.services;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;



@EnableWebSecurity
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private final String user="USER";
    private final String author="AUTHOR";
    private final String admin="ADMIN";

    @Override
    protected  void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/user/**").hasAnyRole(user,author,admin)
                .antMatchers("/author/**").hasAnyRole(author,admin)
                .antMatchers("/admin/**").hasRole(admin);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth){
        auth.userDetailsService()
    }

}
