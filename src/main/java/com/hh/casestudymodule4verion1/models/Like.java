package com.hh.casestudymodule4verion1.models;


import javax.persistence.*;

@Entity
public class Like {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Boolean likedBook;

//    @ManyToOne(fetch = FetchType.LAZY)
//    private Book book;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    private Account account;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean isLikedBook() {
        return likedBook;
    }

    public void setLikedBook(Boolean liked) {
        this.likedBook = liked;
    }

//    public Book getBook() {
//        return book;
//    }
//
//    public void setBook(Book book) {
//        this.book = book;
//    }
//
//    public Account getAccount() {
//        return account;
//    }
//
//    public void setAccount(Account account) {
//        this.account = account;
//    }
}
