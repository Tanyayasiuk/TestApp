package com.example.yasiuk.tanya.testapp.data.net;

import android.util.Log;

import com.example.yasiuk.tanya.testapp.data.entity.Constants;
import com.example.yasiuk.tanya.testapp.data.entity.Photos;
import com.example.yasiuk.tanya.testapp.data.entity.Response;
import com.example.yasiuk.tanya.testapp.data.entity.TextInfo;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by tanya on 13.12.17.
 *
 * The class deals with HTTP connection and parsing of json objects from the response
 */

public class RestService {
    private static final RestService instance = new RestService();

    private RestAPI restAPI;
    private RestService() {
        init();}

    public static RestService getInstance(){
        return instance;
    }

    private void init(){

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .readTimeout(10, TimeUnit.SECONDS)
                .connectTimeout(10, TimeUnit.SECONDS)
                .addInterceptor(logging)
                .build();

        Gson gson = new GsonBuilder().create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.TEXTS_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(okHttpClient)
                .build();
        restAPI = retrofit.create(RestAPI.class);

    }

    public Observable<List<TextInfo>> getTexts(){
        return restAPI.getTextInfo();
    }

    public Observable<Response> getPhotos(){
        return restAPI.getPhotos(Constants.IMAGES_URL);
    }
}
