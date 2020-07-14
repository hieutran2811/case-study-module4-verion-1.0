package com.hh.casestudymodule4verion1.services;

import com.hh.casestudymodule4verion1.models.Account;
import com.hh.casestudymodule4verion1.models.Book;
import com.hh.casestudymodule4verion1.models.LikeStatus;

import java.util.Optional;

public interface LikeService {

    boolean checkLikeStatus(LikeStatus likeStatus);

    Optional<LikeStatus> getLikeByAccountAndBook(Account account, Book book);

    void save(LikeStatus likeStatus);



}
