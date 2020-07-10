package com.hh.casestudymodule4verion1.models;


import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String authorBook;

    private int readsBook;

    private double voteBook;

    private int likeBook;

    private String statusBook;

    private String nameBook;

    private String image;


    @Column(columnDefinition = "TEXT")
    private String introduceBook;

    public String getNameBook() {
        return nameBook;
    }

    public void setNameBook(String nameBook) {
        this.nameBook = nameBook;
    }

    @ManyToOne
    private Account account;


    @ManyToMany(mappedBy = "books")
    private List<Category> categoryList;

    @OneToMany
    private List<Chapter> chapters;

    @OneToMany
    private List<Comment> comments;

    @OneToOne
    private Vote votes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthorBook() {
        return authorBook;
    }

    public void setAuthorBook(String authorBook) {
        this.authorBook = authorBook;
    }

    public int getReadsBook() {
        return readsBook;
    }

    public void setReadsBook(int readsBook) {
        this.readsBook = readsBook;
    }

    public double getVoteBook() {
        return voteBook;
    }

    public void setVoteBook(double voteBook) {
        this.voteBook = voteBook;
    }

    public int getLikeBook() {
        return likeBook;
    }

    public void setLikeBook(int likeBook) {
        this.likeBook = likeBook;
    }

    public String getStatusBook() {
        return statusBook;
    }

    public void setStatusBook(String statusBook) {
        this.statusBook = statusBook;
    }

    public String getIntroduceBook() {
        return introduceBook;
    }

    public void setIntroduceBook(String introduceBook) {
        this.introduceBook = introduceBook;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public List<Category> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<Category> categoryList) {
        this.categoryList = categoryList;
    }

    public List<Chapter> getChapters() {
        return chapters;
    }

    public void setChapters(List<Chapter> chapters) {
        this.chapters = chapters;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public Vote getVotes() {
        return votes;
    }

    public void setVotes(Vote votes) {
        this.votes = votes;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
