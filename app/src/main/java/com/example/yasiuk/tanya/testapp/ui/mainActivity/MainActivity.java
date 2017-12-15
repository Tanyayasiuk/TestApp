package com.example.yasiuk.tanya.testapp.ui.mainActivity;

import android.support.annotation.Nullable;
import android.os.Bundle;

import android.databinding.DataBindingUtil;
import com.example.yasiuk.tanya.testapp.R;
import com.example.yasiuk.tanya.testapp.databinding.ActivityMainBinding;
import com.example.yasiuk.tanya.testapp.ui.base.BaseActivity;

public class MainActivity extends BaseActivity {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {

        MainActivityViewModel viewModel = new MainActivityViewModel(this);
        this.viewModel = viewModel;

        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setViewModel(viewModel);

        super.onCreate(savedInstanceState);

    }

}
