package com.hh.casestudymodule4verion1.api;

import com.hh.casestudymodule4verion1.models.Account;
import com.hh.casestudymodule4verion1.models.Book;
import com.hh.casestudymodule4verion1.models.Comment;
import com.hh.casestudymodule4verion1.services.AccountService;
import com.hh.casestudymodule4verion1.services.BookService;
import com.hh.casestudymodule4verion1.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Optional;
import java.util.List;
@RestController
@RequestMapping("/user/api/book")
public class CommentAPI {

    @Autowired
    private CommentService commentService;
    @Autowired
    private AccountService accountService;
    @Autowired
    private BookService bookService;


    @PostMapping("/saveComment/")
    public void saveComment(@RequestBody Comment comment){
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        Optional<Account> account=accountService.getAccountById(comment.getAccount().getId());
        Optional<Book> book=bookService.getBookById(comment.getBook().getId());
        comment.setPostTime(timestamp);
        if (account.isPresent()){
            comment.setAccount(account.get());
        }
        if (book.isPresent()){
            comment.setBook(book.get());
        }
        commentService.save(comment);
    }
    @GetMapping("/getAllComment/{id}")
    public List<Comment>  getAllComment(@PathVariable Long id){
        List<Comment> list=null;
        List<Comment> list1=null;
        Optional<Book> book=bookService.getBookById(id);
        if (book.isPresent()){
            list=commentService.getAllCommentByBook(book.get());
            list1=commentService.getContentComment(list);

           return list1;
        }
        list=new ArrayList<>();
        return list;
    }

}
