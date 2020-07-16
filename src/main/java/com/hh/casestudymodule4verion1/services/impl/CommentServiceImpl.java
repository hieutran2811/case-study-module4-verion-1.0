package com.hh.casestudymodule4verion1.services.impl;

import com.hh.casestudymodule4verion1.models.Book;
import com.hh.casestudymodule4verion1.models.Comment;
import com.hh.casestudymodule4verion1.repositories.CommentRepository;
import com.hh.casestudymodule4verion1.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentRepository commentRepository;

    @Override
    public void save(Comment comment) {
        commentRepository.save(comment);
    }

    @Override
    public List<Comment> getAllCommentByBook(Book book) {
        return commentRepository.findAllByBook(book);
    }

    @Override
    public List<Comment> getCommentsByBook(Book book) {
        return commentRepository.findCommentsByBook(book);
    }
//    @Override
//    public List<Comment> getContentComment(List<Comment> list){
//        List<Comment> list1=new ArrayList<>();
//        for (int i = 0; i <list.size() ; i++) {
//            String content=list.get(i).getContent();
//            Timestamp timestamp=list.get(i).getPostTime();
//            String author=list.get(i).getAccount().getName();
//
//            list1.add(new Comment(content,timestamp,author));
//
//        }
//        return list1;
//
//    }
}
