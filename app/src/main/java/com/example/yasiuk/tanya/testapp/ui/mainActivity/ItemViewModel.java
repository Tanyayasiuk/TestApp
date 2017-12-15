package com.example.yasiuk.tanya.testapp.ui.mainActivity;

/**
 * Created by tanya on 13.12.17.
 * The view model for every single item in the recyclerView
 */

public class ItemViewModel {

    public String title;
    public String url;
    public String body;

    public ItemViewModel(String title, String url, String body) {
        this.title = title;
        this.url = url;
        this.body = body;
    }
}
