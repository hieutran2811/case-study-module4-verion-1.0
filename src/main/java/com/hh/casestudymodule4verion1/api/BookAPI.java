package com.hh.casestudymodule4verion1.api;

import com.hh.casestudymodule4verion1.modelFake.CommentFake;
import com.hh.casestudymodule4verion1.models.*;
import com.hh.casestudymodule4verion1.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;

import java.util.Optional;
import java.util.List;

@RestController
@RequestMapping("/user/api/book")
public class BookAPI {

    @Autowired
    private CommentService commentService;
    @Autowired
    private AccountService accountService;
    @Autowired
    private BookService bookService;
    @Autowired
    private VoteService voteService;
    @Autowired
    private LikeService likeService;

    @Autowired
    private CategoryService categoryService;


    @PostMapping("/saveComment/")
    public void saveComment(@RequestBody Comment comment) {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        Optional<Account> account = accountService.getAccountById(comment.getAccount().getId());
        Optional<Book> book = bookService.getBookById(comment.getBook().getId());
        comment.setPostTime(timestamp);
        if (account.isPresent()) {
            comment.setAccount(account.get());
        }
        if (book.isPresent()) {
            comment.setBook(book.get());
        }
        commentService.save(comment);
    }

    @GetMapping("/getAllComment/{id}")
    public List<CommentFake> getAllComment(@PathVariable Long id) {
        List<Comment> list = null;
        List<CommentFake> list1 = null;
        CommentFake commentFake = new CommentFake();
        Optional<Book> book = bookService.getBookById(id);
        if (book.isPresent()) {
            list = commentService.getAllCommentByBook(book.get());
            list1 = commentFake.getContentComment(list);
            return list1;
        }
        return list1;
    }


    @PostMapping("/saveVote/")
    public void saveVote(@RequestBody Vote vote) {
        Optional<Account> account = accountService.getAccountById(vote.getAccount().getId());

        Optional<Book> book = bookService.getBookById(vote.getBook().getId());

        if (account.isPresent()) {
            vote.setAccount(account.get());
        }
        if (book.isPresent()) {
            vote.setBook(book.get());
        }
        Optional<Vote> vote1 = voteService.getVotesByBookAndAccount(book.get(), account.get());
        if (!vote1.isPresent()) {
            voteService.save(vote);
            double ratingVote = voteService.getVotesByBook(book.get());//set rating vote trong db
            book.get().setVoteBook(ratingVote);
            bookService.save(book.get());

        }

    }

    @GetMapping("/getRatingVote/{id}")
    public double getRatingVote(@PathVariable Long id) {
        Optional<Book> book = bookService.getBookById(id);
        if (book.isPresent()) {
            return voteService.getVotesByBook(book.get());
        }
        return 0;
    }

    @PostMapping("/saveLike/")
    public void saveLike(@RequestBody LikeStatus likeStatus) {
        Optional<Account> account = accountService.getAccountById(likeStatus.getAccount().getId());
        Optional<Book> book = bookService.getBookById(likeStatus.getBook().getId());
        Optional<LikeStatus> likeStatus1 = likeService.getLikeByAccountAndBook(account.get(), book.get());
        if (!likeStatus1.isPresent()) {
            LikeStatus likeStatus2 = new LikeStatus();
            likeStatus2.setAccount(account.get());
            likeStatus2.setBook(book.get());
            likeStatus2.setLikeStatus(true);
            likeService.save(likeStatus2);
            bookService.increaseLike(book.get());
        } else {
            if (likeStatus1.get().isLikeStatus()) {
                bookService.decreaseLike(book.get());
                likeStatus1.get().setLikeStatus(false);
                likeService.save(likeStatus1.get());
            } else {
                bookService.increaseLike(book.get());
                likeStatus1.get().setLikeStatus(true);
                likeService.save(likeStatus1.get());
            }
        }

    }

    @GetMapping("/getLike/{id}")
    public int getLikes(@PathVariable Long id) {
        Optional<Book> book = bookService.getBookById(id);
        if (book.isPresent()) {
            return book.get().getLikeBook();
        }
        return 0;
    }

    @PostMapping("/search")
    public List<Book> getResultSearch(@RequestBody Book book){
        Category category=null;
        for (int i = 0; i <book.getCategoryList().size() ; i++) {
            category=categoryService.getCategoryByName(book.getCategoryList().get(i).getName());
        }
        List<Book> list=bookService.findByCategoryListAndStatusBookAndAuthorBook(category,book.getStatusBook(),book.getAuthorBook());
        return list;
    }
}
