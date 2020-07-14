package com.hh.casestudymodule4verion1.services.impl;

import com.hh.casestudymodule4verion1.models.Comment;
import com.hh.casestudymodule4verion1.repositories.CommentRepository;
import com.hh.casestudymodule4verion1.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentRepository commentRepository;

    @Override
    public void save(Comment comment) {
        commentRepository.save(comment);
    }
}
