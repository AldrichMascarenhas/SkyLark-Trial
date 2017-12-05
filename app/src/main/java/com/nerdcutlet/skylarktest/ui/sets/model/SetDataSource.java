package com.nerdcutlet.skylarktest.ui.sets.model;

import com.nerdcutlet.skylarktest.ui.setdetail.model.remote.ImageResponse;
import com.nerdcutlet.skylarktest.ui.sets.model.local.SetObject;
import com.nerdcutlet.skylarktest.ui.sets.model.local.SetResponse;

import io.realm.RealmResults;
import retrofit2.Call;

/**
 * Created by Aldrich on 14-Nov-17.
 */

public interface SetDataSource {


    //Get from Local
    RealmResults<SetObject> getSetFromDatabase();

    //Get Remote
    Call<SetResponse> getSetFromRemote();

    void addsetObject(SetObject setObject);

    void updateSetObjectFavouriteStatus(String uid, boolean value);

    Call<ImageResponse> imageResponseCall(String s);

}
