package com.nerdcutlet.skylarktest.ui.sets.model


import com.nerdcutlet.skylarktest.di.annotation.Local
import com.nerdcutlet.skylarktest.di.annotation.Remote
import com.nerdcutlet.skylarktest.ui.setdetail.model.remote.ImageResponse
import com.nerdcutlet.skylarktest.ui.sets.model.local.SetObject
import com.nerdcutlet.skylarktest.ui.sets.model.local.SetResponse

import javax.inject.Inject

import io.realm.RealmResults
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by Aldrich on 14-Nov-17.
 */

class SetRepository @Inject
constructor(@Local private val setLocalDataSource: SetDataSource, @Remote private val setRemoteDataSource: SetDataSource) : SetDataSource {


    override fun getSetFromDatabase(): RealmResults<SetObject> {
        return setLocalDataSource.getSetFromDatabase()
    }

    override fun getSetFromRemote(): Call<SetResponse> {
        return setRemoteDataSource.getSetFromRemote()
    }

    override fun addsetObject(setObject: SetObject) {
        setLocalDataSource.addsetObject(setObject)
    }


    override fun updateSetObjectFavouriteStatus(uid: String, value: Boolean) {
        setLocalDataSource.updateSetObjectFavouriteStatus(uid, value)
    }

    override fun imageResponseCall(s: String): Call<ImageResponse> {
        return setRemoteDataSource.imageResponseCall(s)
    }
}
