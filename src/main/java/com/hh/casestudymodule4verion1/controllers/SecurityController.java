package com.hh.casestudymodule4verion1.controllers;

import com.hh.casestudymodule4verion1.models.Account;
import com.hh.casestudymodule4verion1.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SecurityController {

    @Autowired
    AccountService accountService;

    @Autowired
    PasswordEncoder passwordEncoder;

    private String getPrincipal(){
        String userName = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            userName = ((UserDetails)principal).getUsername();
        } else {
            userName = principal.toString();
        }
        return userName;
    }


    @GetMapping("/register")
    public ModelAndView registerPage(){
        ModelAndView mv = new ModelAndView("register");
        mv.addObject("account", new Account());
        return mv;
    }

    @PostMapping("/register")
    public ModelAndView PostRegisterPage(@ModelAttribute(value = "account") Account account){
        String password = passwordEncoder.encode(account.getPassword());
        account.setPassword(password);
        accountService.save(account);
        ModelAndView modelAndView = new ModelAndView("login");
        return modelAndView ;
    }


    @GetMapping("/home")
    public String home(){
        return "welcome";
    }

    @PostMapping(value = {"/home"})
    public String Homepage(Model model){
        model.addAttribute("user", getPrincipal());
        return "welcome";
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String adminPage(ModelMap model) {
        model.addAttribute("user", getPrincipal());
        return "admin";
    }

    @RequestMapping(value = "/Access_Denied", method = RequestMethod.GET)
    public String accessDeniedPage(ModelMap model) {
        model.addAttribute("user", getPrincipal());
        return "accessDenied";
    }

    @RequestMapping(value = "/dba", method = RequestMethod.GET)
    public String dbaPage(ModelMap model) {
        model.addAttribute("user", getPrincipal());
        return "dba";
    }
}
