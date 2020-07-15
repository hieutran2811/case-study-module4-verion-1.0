package com.hh.casestudymodule4verion1.controllers;


import com.hh.casestudymodule4verion1.models.*;
import com.hh.casestudymodule4verion1.services.AccountService;
import com.hh.casestudymodule4verion1.services.BookService;
import com.hh.casestudymodule4verion1.services.CategoryService;
import com.hh.casestudymodule4verion1.services.ChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/")
public class GuestController {

    @Autowired
    private BookService bookService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ChapterService chapterService;

    @Autowired
    private AccountService accountService;


    @GetMapping("")
    public String guestHome(@PageableDefault(size = 9) Pageable pageable, Model model, Principal principal) {
        String email = "";
        if (principal != null) {
            email = principal.getName();
            Account account = accountService.getAccountByEmail(email);
            for (int i = 0; i < account.getRoles().size(); i++) {
                if (account.getRoles().get(i).getName().equals("ROLE_ADMIN")) {
                    return "redirect:/admin";
                } else if (account.getRoles().get(i).getName().equals("ROLE_AUTHOR")) {
                    return "redirect:/author";
                } else if (account.getRoles().get(i).getName().equals("ROLE_USER")) {
                    return "redirect:/user";
                }
            }
        } else {
            Page<Book> bookPages = bookService.getAllBook(pageable);
            List<Category> categoryList = categoryService.getAllCategory();

            model.addAttribute("bookList", bookPages);
            model.addAttribute("categoryList", categoryList);
            return "guest/home";
        }
        return null;
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
//        Account account=new Account();
//        List<Role> list=new ArrayList<>();
//        list.add(new Role("ROLE_USER"));
//        account.setRoles(list);
        return new ModelAndView("/error-404");
    }

    @GetMapping("/book/{id}")
    public ModelAndView bookDetail(@PathVariable Long id) {
        ModelAndView modelAndView = null;
        Optional<Book> book = bookService.getBookById(id);
        if (!book.isPresent()) {
            modelAndView = new ModelAndView("/error-404");
            return modelAndView;
        }
        modelAndView = new ModelAndView("guest/book-detail", "book", book.get());
        modelAndView.addObject("categories", categoryService.getCategoriesByBook(book.get()));
        modelAndView.addObject("chapters", chapterService.getChaptersByBook(book.get()));
        return modelAndView;
    }

    @GetMapping("/search")
    public ModelAndView search(@RequestParam(value = "searchValue") String string,Principal principal) {
        String email = "";
        Account account = null;
        if (principal != null) {
            email = principal.getName();
            account = accountService.getAccountByEmail(email);
        }
        ModelAndView modelAndView = new ModelAndView("search-result", "bookList", bookService.getBooksByNameContainning(string));
        modelAndView.addObject("account",account);
        return modelAndView;
    }

    @GetMapping("/readBook")
    public ModelAndView readBook(@RequestParam Long id, @RequestParam Long chapters, @PageableDefault(size = 1) Pageable pageable, Principal principal) {
        String email = "";
        Account account = null;
        if (principal != null) {
            email = principal.getName();
            account = accountService.getAccountByEmail(email);
        }
        Optional<Book> book = bookService.getBookById(id);
        Optional<Chapter> chapter = chapterService.getChapterByChapterAndBook(chapters, book.get());
        ModelAndView modelAndView = null;
        if (book.isPresent() && chapter.isPresent()) {
            pageable = PageRequest.of(Integer.parseInt((chapters - 1) + ""), 1);
            Page<Chapter> chapters1 = chapterService.getChaptersByBook(pageable, book.get());
            modelAndView = new ModelAndView("book-content", "chapters", chapters1);
            modelAndView.addObject("chapter", chapter.get());
            modelAndView.addObject("book", book.get());
            modelAndView.addObject("account", account);
        }
        return modelAndView;
    }
}
