package com.hh.casestudymodule4verion1.controllers;


import com.hh.casestudymodule4verion1.models.Book;
import com.hh.casestudymodule4verion1.models.Category;
import com.hh.casestudymodule4verion1.services.BookService;
import com.hh.casestudymodule4verion1.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("")
public class GuestController {

    @Autowired
    private BookService bookService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/")
    public ModelAndView guestHome(@PageableDefault(size = 9) Pageable pageable) {
        Page<Book> bookPages = bookService.getAllBook(pageable);
        List<Category> categoryList = categoryService.getAllCategory();
        ModelAndView modelAndView = new ModelAndView("guest/home");
        modelAndView.addObject("bookList", bookPages);
        modelAndView.addObject("categoryList", categoryList);
        return modelAndView;
    }

    @RequestMapping("/category/{id}")
    public ModelAndView bookListByCategory(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("guest/lis-book-by-category");
        modelAndView.addObject("category", bookService.findBooksByCategory());
        return modelAndView;
    }

    @GetMapping("/book/{id}")
    public ModelAndView bookDeatil(@PathVariable Long id) {
        return new ModelAndView("guest/book-detail", "book", bookService.findById(id));
    }


}
