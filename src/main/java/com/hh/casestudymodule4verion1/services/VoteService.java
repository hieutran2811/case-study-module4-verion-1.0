package com.hh.casestudymodule4verion1.services;

import com.hh.casestudymodule4verion1.models.Account;
import com.hh.casestudymodule4verion1.models.Book;
import com.hh.casestudymodule4verion1.models.Vote;
import java.util.List;
import java.util.Optional;

public interface VoteService {
    void save(Vote vote);
    double getVotesByBook(Book book);

    Optional<Vote> getVotesByBookAndAccount(Book book, Account account);
}
