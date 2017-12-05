package com.nerdcutlet.skylarktest.ui.sets.model.remote;

import com.nerdcutlet.skylarktest.data.remote.SkylarkServerInterface
import com.nerdcutlet.skylarktest.ui.setdetail.model.remote.ImageResponse
import com.nerdcutlet.skylarktest.ui.sets.model.SetDataSource
import com.nerdcutlet.skylarktest.ui.sets.model.local.SetObject
import com.nerdcutlet.skylarktest.ui.sets.model.local.SetResponse
import io.realm.RealmResults
import retrofit2.Call
import javax.inject.Inject

/**
 * Created by Aldrich on 14-Nov-17.
 */

class SetRemoteDataSource @Inject constructor(private val skylarkServerInterface: SkylarkServerInterface) : SetDataSource {


    override fun getSetFromDatabase(): RealmResults<SetObject> {
        throw  UnsupportedOperationException()
    }

    override fun getSetFromRemote(): Call<SetResponse> {
        return skylarkServerInterface.getSkylarkSet()
    }

    override fun addsetObject(setObject: SetObject) {
        throw  UnsupportedOperationException()
    }

    override fun updateSetObjectFavouriteStatus(uid: String, value: Boolean) {
        throw  UnsupportedOperationException()

    }

    override fun imageResponseCall(s: String): Call<ImageResponse> {
        return skylarkServerInterface.getImage(s)
    }


}
