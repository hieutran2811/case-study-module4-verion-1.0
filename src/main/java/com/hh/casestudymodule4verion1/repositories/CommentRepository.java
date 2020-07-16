package com.hh.casestudymodule4verion1.repositories;

import com.hh.casestudymodule4verion1.models.Book;
import com.hh.casestudymodule4verion1.models.Comment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface CommentRepository extends CrudRepository<Comment,Long> {
    List<Comment> findAllByBook(Book book);
    List<Comment> findCommentsByBook(Book book);
}
