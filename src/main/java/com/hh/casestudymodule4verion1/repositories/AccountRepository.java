package com.hh.casestudymodule4verion1.repositories;

import com.hh.casestudymodule4verion1.models.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@EnableJpaRepositories
@Repository
public interface AccountRepository extends CrudRepository<Account,Long> {
        Account findByEmail(String email);
        Account findAccountByEmail(String email);
}
