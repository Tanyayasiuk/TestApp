package com.example.yasiuk.tanya.testapp.data.net;

import com.example.yasiuk.tanya.testapp.data.entity.Response;
import com.example.yasiuk.tanya.testapp.data.entity.TextInfo;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Url;

/**
 * Created by tanya on 13.12.17.
 * The interface service which makes the call
 */

public interface RestAPI {

    @GET("posts?_limit=10")
    Observable<List<TextInfo>> getTextInfo();

    @GET()
    Observable<Response> getPhotos(@Url String url);

}
