package com.hh.casestudymodule4verion1.modelFake;

import com.hh.casestudymodule4verion1.models.Comment;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class CommentFake {

    private String content;
    private String authorName;
    private Timestamp postTime;

    public CommentFake(String content, String authorName, Timestamp postTime) {
        this.content = content;
        this.authorName = authorName;
        this.postTime = postTime;
    }

    public CommentFake() {
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public Timestamp getPostTime() {
        return postTime;
    }

    public void setPostTime(Timestamp postTime) {
        this.postTime = postTime;
    }


    public List<CommentFake> getContentComment(List<Comment> list){
        List<CommentFake> list1=new ArrayList<>();
        for (int i = 0; i <list.size() ; i++) {
            String content=list.get(i).getContent();
            Timestamp timestamp=list.get(i).getPostTime();
            String author=list.get(i).getAccount().getName();

            list1.add(new CommentFake(content,author,timestamp));

        }
        return list1;
    }
}
