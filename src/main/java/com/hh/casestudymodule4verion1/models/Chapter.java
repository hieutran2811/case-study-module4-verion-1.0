package com.hh.casestudymodule4verion1.models;


import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class Chapter {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;


    @Column(columnDefinition = "TEXT")
    private String content;

    private Timestamp postTime;

    private Long chapters;

    @ManyToOne(fetch = FetchType.LAZY)
    private Book book;

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Timestamp getPostTime() {
        return postTime;
    }

    public void setPostTime(Timestamp postTime) {
        this.postTime = postTime;
    }

    public Long getChapters() {
        return chapters;
    }

    public void setChapters(Long chapters) {
        this.chapters = chapters;
    }
}
