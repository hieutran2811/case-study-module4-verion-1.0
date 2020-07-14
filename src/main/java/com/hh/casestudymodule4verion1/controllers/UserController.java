package com.hh.casestudymodule4verion1.controllers;


import com.hh.casestudymodule4verion1.models.Account;
import com.hh.casestudymodule4verion1.models.Book;
import com.hh.casestudymodule4verion1.models.Chapter;
import com.hh.casestudymodule4verion1.models.Comment;
import com.hh.casestudymodule4verion1.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;
import java.security.Principal;
import java.sql.Timestamp;
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

    @GetMapping("/book/{id}")
    public ModelAndView bookDetail(@PathVariable Long id, Principal principal) {

        ModelAndView modelAndView = null;
        String email = principal.getName();

        Account account = accountService.getAccountByEmail(email);
        Optional<Book> book = bookService.getBookById(id);
        if (!book.isPresent()) {
            modelAndView = new ModelAndView("/error-404");
            return modelAndView;
        }
        List<Comment> comments=commentService.getAllCommentByBook(book.get());
        modelAndView = new ModelAndView("user/book-detail", "book", book.get());
        modelAndView.addObject("categories", categoryService.getCategoriesByBook(book.get()));
        modelAndView.addObject("chapters", chapterService.getChaptersByBook(book.get()));

      modelAndView.addObject("comments",comments);
        modelAndView.addObject("account", account);
        return modelAndView;
    }
    @GetMapping("/book/chapters/{id}")
    public ModelAndView chapters(@PageableDefault(size = 30) Pageable pageable,@PathVariable Long id){
        ModelAndView modelAndView;
        Optional<Book> book = bookService.getBookById(id);
        if (!book.isPresent()) {
            modelAndView = new ModelAndView("/error-404");
            return modelAndView;
        }
        Page<Chapter> chapters = chapterService.getChapterByBook(pageable,book.get());
        modelAndView = new ModelAndView("user/chapter", "chapter",chapters);
        return modelAndView;
    }
}
