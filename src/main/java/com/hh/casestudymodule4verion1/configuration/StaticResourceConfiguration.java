//package com.hh.casestudymodule4verion1.configuration;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.env.Environment;
//import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//
//@Configuration
//
//public class StaticResourceConfiguration implements WebMvcConfigurer {
//
//    @Autowired
//    Environment env;
//
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry){
//        String fileUpload = env.getProperty("file_upload").toString();
//        registry.addResourceHandler("/fileimg/**") //
//                .addResourceLocations("file:" + fileUpload);
//    }
//
//}
