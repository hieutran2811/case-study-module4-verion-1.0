package com.hh.casestudymodule4verion1.controllers;


import com.hh.casestudymodule4verion1.models.Book;
import com.hh.casestudymodule4verion1.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("")
public class GuestController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public ModelAndView guestHome(@PageableDefault(size = 9) Pageable pageable) {


//        ModelAndView modelAndView = new ModelAndView("guest/home", "bookList",bookService.getAllBook(pageable));
//        return modelAndView;
        Page<Book> list=bookService.getAllBook(pageable);
        ModelAndView modelAndView=new ModelAndView("guest/home","bookList",list);
        return modelAndView;

    }


}
