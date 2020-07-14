package com.hh.casestudymodule4verion1.repositories;


import com.hh.casestudymodule4verion1.models.Account;
import com.hh.casestudymodule4verion1.models.Book;
import com.hh.casestudymodule4verion1.models.LikeStatus;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LikeRepository extends CrudRepository<LikeStatus,Long> {

    Optional<LikeStatus> findLikeStatusByAccountAndBook(Account account, Book book);
}
