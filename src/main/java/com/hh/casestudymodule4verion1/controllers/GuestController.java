package com.hh.casestudymodule4verion1.controllers;


import com.hh.casestudymodule4verion1.models.Book;
import com.hh.casestudymodule4verion1.models.Category;
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

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("")
public class GuestController {

    @Autowired
    private BookService bookService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ChapterService chapterService;

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
        ModelAndView modelAndView = null;
        Optional<Category> category = categoryService.getCategoryById(id);
        if (category.isPresent()) {
            List<Book> list = bookService.findBooksByCategory(category.get());
            modelAndView = new ModelAndView("guest/list-book-by-category", "books", list);
            return modelAndView;
        }
        return new ModelAndView("/error-404");
    }

    @GetMapping("/book/{id}")
    public ModelAndView bookDetail(@PathVariable Long id) {
        ModelAndView modelAndView=null;
        Optional<Book> book= bookService.findById(id);
        if (!book.isPresent()){
            modelAndView=new ModelAndView("/error-404");
            return modelAndView;
        }
        modelAndView= new ModelAndView("guest/book-detail", "book",book.get());
        modelAndView.addObject("categories",categoryService.getCategoriesByBook(book.get()));
        modelAndView.addObject("chapters",chapterService.getChaptersByBook(book.get()));
        return modelAndView;
    }

}
