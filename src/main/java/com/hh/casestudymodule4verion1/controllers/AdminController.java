package com.hh.casestudymodule4verion1.controllers;

import com.hh.casestudymodule4verion1.models.Account;
import com.hh.casestudymodule4verion1.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;


@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private BookService bookService;
    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ChapterService chapterService;
    @Autowired
    private AccountService accountService;
    @Autowired
    private CommentService commentService;

    @GetMapping("")
    public ModelAndView authorHome(@PageableDefault(9) Pageable pageable, Principal principal) {
        String email = "";
        Account account = null;
        if (principal != null) {
            email = principal.getName();
            account = accountService.getAccountByEmail(email);
        }
        ModelAndView modelAndView = null;
        modelAndView = new ModelAndView("user/user-home");
        modelAndView.addObject("bookList", bookService.getAllBook(pageable));
        modelAndView.addObject("categoryList", categoryService.getAllCategory());
        modelAndView.addObject("account", account);
        return modelAndView;
    }
}
