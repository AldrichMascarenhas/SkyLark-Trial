package com.nerdcutlet.skylarktest.ui.sets.model.local;

import com.nerdcutlet.skylarktest.ui.setdetail.model.remote.ImageResponse;
import com.nerdcutlet.skylarktest.ui.sets.model.SetDataSource;

import java.util.List;
import java.util.Set;

import javax.inject.Inject;

import io.reactivex.Maybe;
import io.reactivex.Single;
import io.realm.Realm;
import io.realm.RealmResults;
import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by Aldrich on 14-Nov-17.
 */

public class SetLocalDataSource implements SetDataSource {

    private final Realm realm;

    @Inject
    public SetLocalDataSource(Realm realm) {
        this.realm = realm;
    }


    @Override
    public RealmResults<SetObject> getSetFromDatabase() {

        RealmResults<SetObject> realmResults = realm.where(SetObject.class)
                .findAll();

        return realmResults;


    }

    @Override
    public Call<SetResponse> getSetFromRemote() {
        throw new UnsupportedOperationException();
    }


    @Override
    public void addsetObject(final SetObject setObject) {
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {


                SetObject localSetObject = realm.where(SetObject.class).equalTo("uid", setObject.getUid()).findFirst();

                if (localSetObject != null) {
                    boolean isFavourite = localSetObject.isFavourite();

                    SetObject updatesSetObject = realm.copyToRealmOrUpdate(setObject);
                    updatesSetObject.setFavourite(isFavourite);

                } else {
                    realm.copyToRealmOrUpdate(setObject);
                }

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

    @Override
    public void updateSetTempImage(String uid, String image_url) {
        SetObject setObject = realm.where(SetObject.class)
                .equalTo("uid", uid)
                .findFirst();
        realm.beginTransaction();

        if (setObject == null) {
            //TODO: Throw error
        } else {
            setObject.setImage_temporary(image_url);
        }
        realm.commitTransaction();
    }

    @Override
    public Call<ImageResponse> imageResponseCall(String s) {
        throw new UnsupportedOperationException();
    }
}
