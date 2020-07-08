package com.hh.casestudymodule4verion1.security;

import com.hh.casestudymodule4verion1.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


@EnableWebSecurity
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private final String user="USER";
    private final String author="AUTHOR";
    private final String admin="ADMIN";

//    @Autowired
//    private AccountService accountService;

    @Override
    protected  void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/").permitAll()
                .and()
                .authorizeRequests().antMatchers("/user/**").hasAnyRole(user,author,admin)
                .and()
                .authorizeRequests().antMatchers("/author/**").hasAnyRole(author,admin)
                .and()
                .authorizeRequests().antMatchers("/admin/**").hasRole(admin)
                .and()
                .formLogin()
                .and()
                .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"));
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("user").password("1").roles(user)
                .and()
                .withUser("author").password("1").roles(author)
                .and()
                .withUser("admin").password("1").roles(admin);
    }

}
