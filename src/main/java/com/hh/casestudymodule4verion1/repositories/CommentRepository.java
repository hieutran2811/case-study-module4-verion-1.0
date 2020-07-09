package com.hh.casestudymodule4verion1.repositories;

import com.hh.casestudymodule4verion1.models.Comment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends CrudRepository<Comment,Long> {
}
