package com.hh.casestudymodule4verion1.services.impl;


import com.hh.casestudymodule4verion1.models.Account;
import com.hh.casestudymodule4verion1.models.Book;
import com.hh.casestudymodule4verion1.models.LikeStatus;
import com.hh.casestudymodule4verion1.repositories.LikeRepository;
import com.hh.casestudymodule4verion1.services.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LikeServiceImpl implements LikeService {
    @Autowired
    private LikeRepository likeRepository;


    @Override
    public boolean checkLikeStatus(LikeStatus likeStatus) {

        return likeStatus.isLikeStatus();
    }

    @Override
    public Optional<LikeStatus> getLikeByAccountAndBook(Account account, Book book) {
        return likeRepository.findLikeStatusByAccountAndBook(account,book);
    }

    @Override
    public void save(LikeStatus likeStatus) {
        likeRepository.save(likeStatus);
    }
}
