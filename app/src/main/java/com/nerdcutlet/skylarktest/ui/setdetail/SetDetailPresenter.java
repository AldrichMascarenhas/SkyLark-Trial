package com.nerdcutlet.skylarktest.ui.setdetail;

import android.util.Log;

import com.nerdcutlet.skylarktest.data.remote.SkylarkServerInterface;
import com.nerdcutlet.skylarktest.ui.setdetail.model.remote.ImageResponse;
import com.nerdcutlet.skylarktest.ui.sets.model.local.SetObject;

import javax.inject.Inject;

import io.realm.Realm;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Aldrich on 16-Nov-17.
 */

public class SetDetailPresenter implements SetDetailContract.Presenter {
    private static final String TAG = "SetDetailPresenter";

    private Realm realm;
    private SetDetailContract.View view;
    private SkylarkServerInterface skylarkServerInterface;

    @Inject
    public SetDetailPresenter(Realm realm, SkylarkServerInterface skylarkServerInterface) {
        this.realm = realm;
        this.skylarkServerInterface = skylarkServerInterface;
    }

    @Override
    public void attachView(SetDetailContract.View view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        this.view = null;
    }

    @Override
    public boolean isViewAttached() {
        return view != null;
        //TODO
    }

    @Override
    public void getSetObjectFromDatabase(String uid) {
        SetObject setObject = realm.where(SetObject.class)
                .equalTo("uid", uid)
                .findFirst();

        if (setObject == null) {
            //TODO: Throw error
        } else {
            view.showData(setObject);
        }
    }

    @Override
    public void getImageResponse(String image_data) {

        String image_url = image_data.substring(12, image_data.length() - 1);

        skylarkServerInterface.getImage(image_url).enqueue(new Callback<ImageResponse>() {
            @Override
            public void onResponse(Call<ImageResponse> call, Response<ImageResponse> response) {
                if (response.isSuccessful()) {
                    if (response.body().getUrl() != null) {
                        view.loadImage(response.body().getUrl());
                    }

                } else {
                    //TODO
                }
            }

            @Override
            public void onFailure(Call<ImageResponse> call, Throwable t) {

            }
        });
    }

    @Override
    public void updateSetObjectFavouriteStatus(String uid, boolean value) {
        SetObject setObject = realm.where(SetObject.class)
                .equalTo("uid", uid)
                .findFirst();
        realm.beginTransaction();

        if (setObject == null) {
            //TODO: Throw error
        } else {
            setObject.setFavourite(value);
        }
        realm.commitTransaction();

    }

}
