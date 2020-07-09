package com.hh.casestudymodule4verion1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class CaseStudyModule4Verion1Application {

    public static void main(String[] args) {
        SpringApplication.run(CaseStudyModule4Verion1Application.class, args);
    }

}
