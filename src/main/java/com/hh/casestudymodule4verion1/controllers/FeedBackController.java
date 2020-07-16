package com.hh.casestudymodule4verion1.controllers;


import com.hh.casestudymodule4verion1.services.EmailService;
import com.hh.casestudymodule4verion1.validation.FeedBack;
import com.hh.casestudymodule4verion1.validation.MailConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.xml.bind.ValidationException;

@RestController
@RequestMapping("/feedback")
public class FeedBackController {

    @Autowired
    private EmailService emailService;

    @PostMapping
    public void sendFeedback(@RequestBody FeedBack feedBack, BindingResult bindingResult) throws ValidationException {
        if (bindingResult.hasErrors()) {
            throw new ValidationException("Feedback is not valid");
        }
        emailService.sendEmail("r@mail.com", "this is mail from " + feedBack.getName(), feedBack.getFeedback());
    }
}
