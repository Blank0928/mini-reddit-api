package com.example.mini_reddit_api.model;

import com.example.mini_reddit_api.model.Comment;
import java.util.ArrayList;
import java.util.List;

public class Post {
    private Long id;
    private String title;
    private String content;
    private String author;
    private List<Comment> comments = new ArrayList<>();

    public Post() {}

    public Post(Long id, String title, String content, String author) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.author = author;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }
    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }
    public List<Comment> getComments() { return comments; }
    public void setComments(List<Comment> comments) { this.comments = comments; }
}
