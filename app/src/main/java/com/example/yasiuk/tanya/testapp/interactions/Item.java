package com.example.yasiuk.tanya.testapp.interactions;

/**
 * Created by tanya on 14.12.17.
 * The object displayed in the RecyclerView
 */

public class Item {
    private String url;
    private String title;
    private String body;

    public String getUrl() {
        return url;
    }


    public void setUrl(String url) {
        this.url = url;
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
