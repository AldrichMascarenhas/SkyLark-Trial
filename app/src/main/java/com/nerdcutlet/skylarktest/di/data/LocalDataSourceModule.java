package com.nerdcutlet.skylarktest.di.data;

import android.content.Context;

import com.nerdcutlet.skylarktest.di.annotation.Local;
import com.nerdcutlet.skylarktest.ui.sets.model.SetDataSource;
import com.nerdcutlet.skylarktest.ui.sets.model.local.SetLocalDataSource;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by Aldrich on 14-Nov-17.
 */
@Module
public class LocalDataSourceModule {
    private static final int DATABASE_VERSION = 1;

    @Singleton
    @Provides
    @Local
    SetDataSource provideSetLocalDataSource(Realm realm){
        return new SetLocalDataSource(realm);
    }

    @Provides
    @Singleton
    Realm provideRealm(RealmConfiguration realmConfiguration){

        //Set default Realm Configuration
        Realm.setDefaultConfiguration(realmConfiguration);

        //Return the Default Configuration
        return  Realm.getDefaultInstance();
    }

    @Provides
    @Singleton
    RealmConfiguration provideRealmConfig(Context context){

        //Initialize Realm
        Realm.init(context);

        return new RealmConfiguration.Builder()
                .schemaVersion(DATABASE_VERSION)
                .build();
    }
}
