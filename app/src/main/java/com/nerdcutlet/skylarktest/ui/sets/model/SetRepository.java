package com.nerdcutlet.skylarktest.ui.sets.model;


import com.nerdcutlet.skylarktest.di.annotation.Local;
import com.nerdcutlet.skylarktest.ui.setdetail.model.remote.ImageResponse;
import com.nerdcutlet.skylarktest.ui.sets.model.local.SetObject;
import com.nerdcutlet.skylarktest.ui.sets.model.local.SetResponse;

import javax.inject.Inject;

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
