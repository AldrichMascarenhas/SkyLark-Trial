package com.nerdcutlet.skylarktest.ui.sets.model.remote;

import com.nerdcutlet.skylarktest.data.remote.SkylarkServerInterface;
import com.nerdcutlet.skylarktest.ui.setdetail.model.remote.ImageResponse;
import com.nerdcutlet.skylarktest.ui.sets.model.SetDataSource;
import com.nerdcutlet.skylarktest.ui.sets.model.local.SetObject;
import com.nerdcutlet.skylarktest.ui.sets.model.local.SetResponse;

import javax.inject.Inject;

import io.realm.RealmResults;
import retrofit2.Call;

/**
 * Created by Aldrich on 14-Nov-17.
 */

public class SetRemoteDataSource implements SetDataSource {

    private final SkylarkServerInterface skylarkServerInterface;

    @Inject
    public SetRemoteDataSource(SkylarkServerInterface skylarkServerInterface) {
        this.skylarkServerInterface = skylarkServerInterface;
    }

    @Override
    public RealmResults<SetObject> getSetFromDatabase() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Call<SetResponse> getSetFromRemote() {
        return skylarkServerInterface.getSkylarkSet();
    }

    @Override
    public void addsetObject(SetObject setObject) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void updateSetObjectFavouriteStatus(String uid, boolean value) {
        throw new UnsupportedOperationException();

    }

    @Override
    public Call<ImageResponse> imageResponseCall(String s){
       return skylarkServerInterface.getImage(s);
    }


}
