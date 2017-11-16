package com.nerdcutlet.skylarktest.ui.sets.model;


import com.nerdcutlet.skylarktest.di.annotation.Local;
import com.nerdcutlet.skylarktest.di.annotation.Remote;
import com.nerdcutlet.skylarktest.ui.setdetail.model.remote.ImageResponse;
import com.nerdcutlet.skylarktest.ui.sets.model.local.SetObject;
import com.nerdcutlet.skylarktest.ui.sets.model.local.SetResponse;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Maybe;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.realm.RealmResults;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Aldrich on 14-Nov-17.
 */

public class SetRepository implements SetDataSource {

    private final SetDataSource setLocalDataSource;
    private final SetDataSource setRemoteDataSource;

    @Inject
    public SetRepository(@Local SetDataSource setLocalDataSource, @Local SetDataSource setRemoteDataSource) {
        this.setLocalDataSource = setLocalDataSource;
        this.setRemoteDataSource = setRemoteDataSource;
    }


    @Override
    public RealmResults<SetObject> getSetFromDatabase() {
        return setLocalDataSource.getSetFromDatabase();
    }

    @Override
    public Call<SetResponse> getSetFromRemote() {
        return setRemoteDataSource.getSetFromRemote();
    }

    @Override
    public void addsetObject(final SetObject setObject) {
        setLocalDataSource.addsetObject(setObject);

        //realm hax
        if (!setObject.getImageUrls().isEmpty()) {
            String unformatted_image_url = setObject.getImageUrls().get(0);

            String image_url = unformatted_image_url.substring(12, unformatted_image_url.length() - 1);

            imageResponseCall(image_url).enqueue(new Callback<ImageResponse>() {
                @Override
                public void onResponse(Call<ImageResponse> call, Response<ImageResponse> response) {

                    if (response.body().getUrl() != null) {

                        updateSetTempImage(setObject.getUid(), response.body().getUrl());

                    } else {
                        //TODO
                    }


                }

                @Override
                public void onFailure(Call<ImageResponse> call, Throwable t) {

                }
            });

        }

    }

    @Override
    public void updateSetTempImage(String uid, String image_url) {
        setLocalDataSource.updateSetTempImage(uid, image_url);
    }

    @Override
    public void updateSetObjectFavouriteStatus(String uid, boolean value) {
        setLocalDataSource.updateSetObjectFavouriteStatus(uid, value);
    }

    @Override
    public Call<ImageResponse> imageResponseCall(String s) {
        return setRemoteDataSource.imageResponseCall(s);
    }
}
