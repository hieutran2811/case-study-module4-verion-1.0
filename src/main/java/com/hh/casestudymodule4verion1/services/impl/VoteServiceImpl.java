package com.hh.casestudymodule4verion1.services.impl;

import com.hh.casestudymodule4verion1.models.Account;
import com.hh.casestudymodule4verion1.models.Book;
import com.hh.casestudymodule4verion1.models.Vote;
import com.hh.casestudymodule4verion1.repositories.VoteRepository;
import com.hh.casestudymodule4verion1.services.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VoteServiceImpl  implements VoteService {

    @Autowired
    private VoteRepository voteRepository;

    @Override
    public void save(Vote vote) {
        voteRepository.save(vote);
    }

    @Override
    public double getVotesByBook(Book book) {
        List<Vote> votes= voteRepository.findVotesByBook(book);
        int sumStar=0;
        for (   Vote v:votes) {
           sumStar+= v.getStars();
        }
        return (double) sumStar/votes.size();
    }

    @Override
    public Optional<Vote> getVotesByBookAndAccount(Book book, Account account) {
        return voteRepository.findVotesByBookAndAccount(book,account);
    }


}
