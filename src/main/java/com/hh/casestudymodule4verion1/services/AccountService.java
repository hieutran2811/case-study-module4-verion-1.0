package com.hh.casestudymodule4verion1.services;

import com.hh.casestudymodule4verion1.models.Account;

import java.util.Optional;

public interface AccountService {

    Account getAccountByEmail(String email);
    Optional<Account> getAccountById(Long id);

}
