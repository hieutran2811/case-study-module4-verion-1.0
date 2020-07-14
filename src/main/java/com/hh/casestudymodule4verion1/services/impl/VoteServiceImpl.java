package com.hh.casestudymodule4verion1.services.impl;

import com.hh.casestudymodule4verion1.models.Vote;
import com.hh.casestudymodule4verion1.repositories.VoteRepository;
import com.hh.casestudymodule4verion1.services.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VoteServiceImpl  implements VoteService {

    @Autowired
    private VoteRepository voteRepository;

    @Override
    public void save(Vote vote) {
        voteRepository.save(vote);
    }
}
