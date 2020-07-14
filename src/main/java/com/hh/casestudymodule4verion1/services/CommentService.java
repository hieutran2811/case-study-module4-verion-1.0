package com.hh.casestudymodule4verion1.services;

import com.hh.casestudymodule4verion1.models.Book;
import com.hh.casestudymodule4verion1.models.Comment;
import java.util.List;
public interface CommentService {

    void save(Comment comment);

    List<Comment> getAllCommentByBook(Book book);
//    List<Comment> getContentComment(List<Comment> list);
}
