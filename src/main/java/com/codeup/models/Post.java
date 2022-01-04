package com.codeup.models;

public class Post {
    private String title;
    private String body;

//    constructor
    public Post(){}

    public Post(String title, String body) {
        this.title = title;
        this.body = body;
    }
// Getters
    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

//    setters

    public void setTitle(String title) {
        this.title = title;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
