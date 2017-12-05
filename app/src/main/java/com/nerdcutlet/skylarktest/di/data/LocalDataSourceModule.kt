package com.nerdcutlet.skylarktest.di.data;

import android.content.Context
import com.nerdcutlet.skylarktest.di.annotation.Local
import com.nerdcutlet.skylarktest.ui.sets.model.SetDataSource
import com.nerdcutlet.skylarktest.ui.sets.model.local.SetLocalDataSource
import dagger.Module
import dagger.Provides
import io.realm.Realm
import io.realm.RealmConfiguration
import javax.inject.Singleton

/**
 * Created by Aldrich on 14-Nov-17.
 */
@Module
class LocalDataSourceModule {

    private val DATABASE_VERSION: Long = 1

    @Singleton
    @Provides
    @Local
    fun provideSetLocalDataSource(realm : Realm ) : SetDataSource
    {
        return SetLocalDataSource (realm)
    }

    @Provides
    @Singleton
    fun provideRealm(realmConfiguration : RealmConfiguration) : Realm
    {

        Realm.setDefaultConfiguration(realmConfiguration)
        return Realm.getDefaultInstance()

    }

    @Provides
    @Singleton
    fun provideRealmConfig(context : Context) : RealmConfiguration
    {

        Realm.init(context);

        return  RealmConfiguration . Builder ()
                .schemaVersion(DATABASE_VERSION)
                .build()
    }
}
