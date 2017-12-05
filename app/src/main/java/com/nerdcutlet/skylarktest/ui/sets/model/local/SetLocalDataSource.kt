package com.nerdcutlet.skylarktest.ui.sets.model.local;

import com.nerdcutlet.skylarktest.ui.setdetail.model.remote.ImageResponse
import com.nerdcutlet.skylarktest.ui.sets.model.SetDataSource
import io.realm.Realm
import io.realm.RealmResults
import retrofit2.Call
import javax.inject.Inject

/**
 * Created by Aldrich on 14-Nov-17.
 */

class SetLocalDataSource @Inject constructor(private val realm: Realm) : SetDataSource {


    override fun getSetFromDatabase(): RealmResults<SetObject> {

        val realmResults = realm.where(SetObject::class.java).findAll()
        return realmResults

    }

    override fun getSetFromRemote(): Call<SetResponse> {
        throw  UnsupportedOperationException()
    }


    override fun addsetObject(setObject: SetObject) {

        //Add Set to Database
        realm.executeTransaction {
            realm.copyToRealm(setObject)
        }

    }

    override fun updateSetObjectFavouriteStatus(uid: String, value: Boolean) {

        realm.executeTransaction {
            val favSetObject = FavSetObject(uid)
            realm.copyToRealm(favSetObject)
        }

    }


    override fun imageResponseCall(s: String): Call<ImageResponse> {
        throw  UnsupportedOperationException();
    }
}
