//package com.hh.casestudymodule4verion1.controllers;
//
//import com.hh.casestudymodule4verion1.services.BookService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.servlet.ModelAndView;
//
//@RestController
//public class BookSearching {
//    @Autowired
//    private BookService bookService;
//
//    @GetMapping("/search")
//    public void search(@RequestBody String searchValue){
//        ModelAndView modelAndView=new ModelAndView("search-result");
//        modelAndView.addObject("bookList",bookService.getBookByName(searchValue));
//
//    }
//
//}
