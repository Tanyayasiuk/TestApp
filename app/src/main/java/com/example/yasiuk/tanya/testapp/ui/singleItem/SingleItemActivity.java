package com.example.yasiuk.tanya.testapp.ui.singleItem;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.example.yasiuk.tanya.testapp.R;
import com.example.yasiuk.tanya.testapp.databinding.ActivitySingleItemBinding;
import com.example.yasiuk.tanya.testapp.ui.base.BaseActivity;

/**
 * Created by tanya on 13.12.17.
 */

public class SingleItemActivity extends BaseActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        Bundle extras = getIntent().getExtras();
        String title = extras.getString("TITLE");
        String url = extras.getString("URL");
        String body = extras.getString("BODY");

        SingleItemViewModel viewModel = new SingleItemViewModel(this, url, title, body);
        this.viewModel = viewModel;

        ActivitySingleItemBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_single_item);
        binding.setViewModel(viewModel);
        super.onCreate(savedInstanceState);

    }

    @Override
    protected void onPause() {
        super.onPause();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
