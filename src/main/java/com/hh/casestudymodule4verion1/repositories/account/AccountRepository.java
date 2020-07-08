package com.hh.casestudymodule4verion1.repositories.account;

import com.hh.casestudymodule4verion1.models.Account;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<Account,Long> {
        Account findAccountByEmail(String email);

}
