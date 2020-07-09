package com.hh.casestudymodule4verion1.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

    @GetMapping("/")
    public String getHome(){
        return "/home";
    }
    @GetMapping("/user")
    public String getUserHome(){
        return "user";
    }
    @GetMapping("/author")
    public String getAuthorHome(){
        return "author";
    }
    @GetMapping("/admin")
    public String getAdminHome(){
        return "admin";
    }


}
