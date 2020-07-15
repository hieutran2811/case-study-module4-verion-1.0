package com.hh.casestudymodule4verion1.controllers;


import com.hh.casestudymodule4verion1.models.Book;
import com.hh.casestudymodule4verion1.models.Chapter;
import com.hh.casestudymodule4verion1.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping("/author")
public class AuthorController {
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
    public ModelAndView userHome(@PageableDefault(9) Pageable pageable) {
        ModelAndView modelAndView = null;
        modelAndView = new ModelAndView("user/user-home");
        modelAndView.addObject("bookList", bookService.getAllBook(pageable));
        modelAndView.addObject("categoryList", categoryService.getAllCategory());
        return modelAndView;

    }
    @GetMapping("/create-book")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView = new ModelAndView("/author/createbook");
        modelAndView.addObject("book", new Book());
        return modelAndView;
    }

    @PostMapping("/create-book")
    public ModelAndView saveBook(@ModelAttribute("book") Book book){
        bookService.save(book);
        ModelAndView modelAndView = new ModelAndView("/author/createbook");
        modelAndView.addObject("book", new Book());
        modelAndView.addObject("message", "New book created successfully");
        return modelAndView;
    }
    @GetMapping("/edit-book/{id}")
    public ModelAndView showEditForm(@PathVariable Long id){
        ModelAndView modelAndView;
        Optional<Book> book = bookService.getBookById(id);
        if (book.isPresent()){
            modelAndView = new ModelAndView("/author/editbook");
            modelAndView.addObject("book", book.get());
            return modelAndView;
        }
        return null;
    }
    @PostMapping("/edit-book")
    public ModelAndView updateBook(@ModelAttribute("book") Book book){
        bookService.save(book);
        ModelAndView modelAndView = new ModelAndView("/author/editbook");
        modelAndView.addObject("book", book);
        modelAndView.addObject("message", "book updated successfully");
        return modelAndView;
    }
    @GetMapping("/delete-book/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id){
        Optional<Book> book = bookService.getBookById(id);
        if (book.isPresent()){
            ModelAndView modelAndView = new ModelAndView("/author/deletebook");
            modelAndView.addObject("book", book.get());
            return modelAndView;
        }
        return null;
    }

    @PostMapping("/delete-book")
    public String deleteBook(@ModelAttribute("book") Book book){
        bookService.remove(book);
        return "redirect:/author/";
    }
    @GetMapping("/create-chapter")
    public ModelAndView showCreateChapterForm(){
        ModelAndView modelAndView = new ModelAndView("/author/createchapter");
        modelAndView.addObject("chapter", new Chapter());
        return modelAndView;
    }

    @PostMapping("/create-chapter")
    public ModelAndView saveChapter(@ModelAttribute("chapter") Chapter chapter){
        chapterService.save(chapter);
        ModelAndView modelAndView = new ModelAndView("/author/createchapter");
        modelAndView.addObject("chapter", new Chapter());
        modelAndView.addObject("message", "New chapter created successfully");
        return modelAndView;
    }
    @GetMapping("/edit-chapter/{id}")
    public ModelAndView showEditChapterForm(@PathVariable Long id){
        ModelAndView modelAndView;
        Optional<Chapter> chapter = chapterService.getChapterById(id);
        if (chapter.isPresent()){
            modelAndView = new ModelAndView("/author/editchapter");
            modelAndView.addObject("chapter", chapter.get());
            return modelAndView;
        }
        return null;
    }
    @PostMapping("/edit-chapter")
    public ModelAndView updateChapter(@ModelAttribute("chapter") Chapter chapter){
        chapterService.save(chapter);
        ModelAndView modelAndView = new ModelAndView("/author/editchapter");
        modelAndView.addObject("chapter", chapter);
        modelAndView.addObject("message", "chapter updated successfully");
        return modelAndView;
    }
    @GetMapping("/delete-chapter/{id}")
    public ModelAndView showDeleteChapterForm(@PathVariable Long id){
        ModelAndView modelAndView;
        Optional<Chapter> chapter = chapterService.getChapterById(id);
        if (chapter.isPresent()){
            modelAndView = new ModelAndView("/author/deletechapter");
            modelAndView.addObject("chapter", chapter.get());
            return modelAndView;
        }
        return null;
    }

    @PostMapping("/delete-chapter")
    public String deleteCustomer(@ModelAttribute("chapter") Chapter chapter){
        chapterService.remove(chapter);
        return "redirect:/author/";
    }


}
