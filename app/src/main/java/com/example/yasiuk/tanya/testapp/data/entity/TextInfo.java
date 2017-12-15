package com.example.yasiuk.tanya.testapp.data.entity;

/**
 * Created by tanya on 13.12.17.
 * POJO for json response from https://jsonplaceholder.typicode.com/posts
 */

public class TextInfo {
    private int id;
    private String title;
    private String body;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
