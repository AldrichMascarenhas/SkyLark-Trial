package com.nerdcutlet.skylarktest.ui.sets.model;

import com.nerdcutlet.skylarktest.ui.setdetail.model.remote.ImageResponse;
import com.nerdcutlet.skylarktest.ui.sets.model.local.SetObject;
import com.nerdcutlet.skylarktest.ui.sets.model.local.SetResponse;

import io.realm.RealmResults;
import retrofit2.Call;

/**
 * Created by Aldrich on 14-Nov-17.
 */

interface SetDataSource {


    //Get from Local
    fun getSetFromDatabase(): RealmResults<SetObject>

    //Get Remote
    fun getSetFromRemote(): Call<SetResponse>

    fun addsetObject(setObject: SetObject)

    fun updateSetObjectFavouriteStatus(uid: String, value: Boolean)

    fun imageResponseCall(s: String): Call<ImageResponse>

}
