package com.hh.casestudymodule4verion1.models;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

import java.util.List;
@Entity
public class Role implements GrantedAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String  name;

    @ManyToMany(mappedBy = "roles")
    private List<Account> accountList;

//    public Role(String name) {
//        this.name=name;
//    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Account> getAccountList() {
        return accountList;
    }

    public void setAccountList(List<Account> accountList) {
        this.accountList = accountList;
    }

    @Override
    public String getAuthority() {
        return this.name;
    }
}
