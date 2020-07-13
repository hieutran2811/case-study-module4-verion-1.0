package com.hh.casestudymodule4verion1.controllers;


import com.hh.casestudymodule4verion1.services.BookService;
import com.hh.casestudymodule4verion1.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private BookService bookService;
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/")
    public ModelAndView userHome(@PageableDefault(9)Pageable pageable){
        ModelAndView modelAndView=null;
        modelAndView= new ModelAndView("user/home");
        modelAndView.addObject("bookList",bookService.getAllBook(pageable));
        modelAndView.addObject("categoryList", categoryService.getAllCategory());
        return modelAndView;

    }

}
