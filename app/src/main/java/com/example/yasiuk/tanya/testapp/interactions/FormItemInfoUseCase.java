package com.example.yasiuk.tanya.testapp.interactions;

import android.util.Log;

import com.example.yasiuk.tanya.testapp.data.entity.Photo;
import com.example.yasiuk.tanya.testapp.data.entity.Response;
import com.example.yasiuk.tanya.testapp.data.entity.TextInfo;
import com.example.yasiuk.tanya.testapp.data.net.RestService;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Function;

/**
 * Created by tanya on 13.12.17.
 *
 * This useCase performs two requests to the RestService to get texts and images
 * Then it combines the results of these requests and returns the list of Items to be displayed.
 */

public class FormItemInfoUseCase extends BaseUseCase<Void, List<Item>> {

    @Override
    protected Observable<List<Item>> buildUseCase(Void aVoid) {
        Observable<List<TextInfo>> texts = getTextInfo();
        Observable<List<Photo>> photos = getPhotosInfo();

        return Observable.zip(texts, photos, new BiFunction<List<TextInfo>, List<Photo>, List<Item>>() {
            @Override
            public List<Item> apply(List<TextInfo> textInfos, List<Photo> photos) throws Exception {
                List<Item> list = new ArrayList<>();
                for (int i = 0; i < textInfos.size(); i++){
                    Item item = new Item();
                    item.setTitle(textInfos.get(i).getTitle());
                    item.setBody(textInfos.get(i).getBody());
                    item.setUrl(formUrl(photos.get(i).getFarm(),
                                        photos.get(i).getServer(),
                                        photos.get(i).getId(),
                                        photos.get(i).getSecret()));
                    list.add(item);
                }

                return list;
            }
        });
    }




    private Observable<List<TextInfo>> getTextInfo() {
        return RestService.getInstance().getTexts();
    }

    private Observable<List<Photo>> getPhotosInfo () {
        return RestService.getInstance().getPhotos().map(new Function<Response, List<Photo>>() {
            @Override
            public List<Photo> apply(Response response) throws Exception {
                return response.getPhotos().getPhoto();
            }
        });
    }

    private String formUrl (String farm, String server, String id, String secret){
        StringBuilder builder = new StringBuilder();
        builder.append("https://farm");
        builder.append(farm);
        builder.append(".staticflickr.com/");
        builder.append(server);
        builder.append("/");
        builder.append(id);
        builder.append("_");
        builder.append(secret);
        builder.append("_z.jpg");
        return builder.toString();
    }

}
