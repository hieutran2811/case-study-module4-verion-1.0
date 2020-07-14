package com.hh.casestudymodule4verion1.repositories;

import com.hh.casestudymodule4verion1.models.Account;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface AccountRepository extends CrudRepository<Account, Long> {
    Account findByEmail(String email);

    Account findAccountByEmail(String email);

    Optional<Account> findById(Long id);

}
