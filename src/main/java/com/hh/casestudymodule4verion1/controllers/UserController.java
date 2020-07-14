package com.hh.casestudymodule4verion1.controllers;


import com.hh.casestudymodule4verion1.models.Book;
import com.hh.casestudymodule4verion1.services.BookService;
import com.hh.casestudymodule4verion1.services.CategoryService;
import com.hh.casestudymodule4verion1.services.ChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private BookService bookService;
    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ChapterService chapterService;

    @GetMapping("")
    public ModelAndView userHome(@PageableDefault(9)Pageable pageable){
        ModelAndView modelAndView=null;
        modelAndView= new ModelAndView("user/user-home");
        modelAndView.addObject("bookList",bookService.getAllBook(pageable));
        modelAndView.addObject("categoryList", categoryService.getAllCategory());
        return modelAndView;

    }
    @GetMapping("/book/{id}")
    public ModelAndView bookDetail(@PathVariable Long id){
        ModelAndView modelAndView=null;
        Optional<Book> book= bookService.findById(id);
        if (!book.isPresent()){
            modelAndView=new ModelAndView("/error-404");
            return modelAndView;
        }
        modelAndView= new ModelAndView("user/book-detail", "book",book.get());
        modelAndView.addObject("categories",categoryService.getCategoriesByBook(book.get()));
        modelAndView.addObject("chapters",chapterService.getChaptersByBook(book.get()));
        return modelAndView;
    }

}
