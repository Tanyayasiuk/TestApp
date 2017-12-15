package com.example.yasiuk.tanya.testapp.ui.mainActivity;

import android.app.Activity;
import android.databinding.ObservableField;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.example.yasiuk.tanya.testapp.R;
import com.example.yasiuk.tanya.testapp.interactions.FormItemInfoUseCase;
import com.example.yasiuk.tanya.testapp.interactions.Item;
import com.example.yasiuk.tanya.testapp.ui.base.BaseViewModel;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.observers.DisposableObserver;

/**
 * Created by tanya on 13.12.17.
 */

public class MainActivityViewModel implements BaseViewModel{

    public Activity activity;
    public MainActivityViewModel(Activity activity) {
        this.activity = activity;
    }

    public enum STATE {PROGRESS, DATA}
    public ObservableField<STATE> state = new ObservableField<>(STATE.PROGRESS);

    private List<ItemViewModel> itemsList;
    private FormItemInfoUseCase useCase = new FormItemInfoUseCase();


    @Override
    public void init() {

    }

    @Override
    public void release() {

    }

    @Override
    public void resume() {
        final RecyclerView recyclerView = (RecyclerView) activity.findViewById(R.id.rv_main);
        LinearLayoutManager manager = new LinearLayoutManager(activity);
        recyclerView.setLayoutManager(manager);

        //getting data from RestService and display the result in the recyclerView
        useCase.execute(null, new DisposableObserver<List<Item>>() {
            @Override
            public void onNext(List<Item> items) {

                itemsList = new ArrayList<>();
                for(Item i: items){
                    itemsList.add(new ItemViewModel(i.getTitle(), i.getUrl(), i.getBody()));
                }

                RVAdapter adapter = new RVAdapter(activity, itemsList);
                recyclerView.setAdapter(adapter);
                state.set(STATE.DATA);
            }

            @Override
            public void onError(Throwable e) {
                showError(e.getLocalizedMessage());
            }

            @Override
            public void onComplete() {

            }
        });
    }

    @Override
    public void pause() {
        useCase.dispose();
    }

    public void showError(String errorMessage){
        Toast.makeText(activity, errorMessage, Toast.LENGTH_SHORT).show();
    }
}
