package com.example.yasiuk.tanya.testapp.ui.singleItem;

import android.app.Activity;
import android.databinding.BindingAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.yasiuk.tanya.testapp.R;
import com.example.yasiuk.tanya.testapp.ui.base.BaseViewModel;

/**
 * Created by tanya on 13.12.17.
 */

public class SingleItemViewModel implements BaseViewModel{

    public Activity activity;
    public String title;
    public String url;
    public String body;

    public SingleItemViewModel(Activity activity, String url, String title, String body) {
        this.activity = activity;
        this.title = title;
        this.url = url;
        this.body = body;
    }

    @Override
    public void init() {}

    @Override
    public void release() {}

    @Override
    public void resume() {
        final TextView titleText = (android.widget.TextView) activity.findViewById(R.id.title);
        final TextView bodyText = (TextView) activity.findViewById(R.id.body);
        bodyText.setText(body);
        titleText.setText(title);
    }

    @Override
    public void pause() {}


    @BindingAdapter({"android:src"})
    public static void loadImage(ImageView view, String url) {
        Glide.with(view.getContext())
                .load(url)
                .into(view);
    }
}
