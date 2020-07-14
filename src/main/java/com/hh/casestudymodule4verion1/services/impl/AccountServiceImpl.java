package com.hh.casestudymodule4verion1.services.impl;


import com.hh.casestudymodule4verion1.models.Account;
import com.hh.casestudymodule4verion1.models.Role;
import com.hh.casestudymodule4verion1.repositories.AccountRepository;
import com.hh.casestudymodule4verion1.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService, UserDetailsService {

    @Autowired
    private AccountRepository accountRepository;


    @Override
    public Account getAccountByEmail(String email) {
        return accountRepository.findByEmail(email);
    }

    @Override
    public Optional<Account> getAccountById(Long id) {
        return accountRepository.findById(id);
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = this.getAccountByEmail(username);

        List<GrantedAuthority> roleList = new ArrayList<>();
        List<Role> roles = account.getRoles();
        for (Role r : roles) {
            roleList.add(new SimpleGrantedAuthority(r.getName()));
        }
        org.springframework.security.core.userdetails.User user = new User(account.getEmail(), account.getPassword(), roleList);

        return user;
    }
}
