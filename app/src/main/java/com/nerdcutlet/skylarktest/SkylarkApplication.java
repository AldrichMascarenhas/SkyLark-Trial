package com.nerdcutlet.skylarktest;

import android.app.Application;
import android.content.Context;

import com.nerdcutlet.skylarktest.di.app.AppComponent;
import com.nerdcutlet.skylarktest.di.app.AppModule;
import com.nerdcutlet.skylarktest.di.app.DaggerAppComponent;
import com.nerdcutlet.skylarktest.di.data.LocalDataSourceModule;
import com.nerdcutlet.skylarktest.di.data.RemoteDataSourceModule;
import com.nerdcutlet.skylarktest.di.data.RepositoryModule;

/**
 * Created by Aldrich on 14-Nov-17.
 */

public class SkylarkApplication extends Application {

    private AppComponent appComponent;


    @Override
    public void onCreate() {
        super.onCreate();

        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .localDataSourceModule(new LocalDataSourceModule())
                .remoteDataSourceModule(new RemoteDataSourceModule())
                .repositoryModule(new RepositoryModule())
                .build();

        appComponent.inject(this);

    }

    public AppComponent getComponent() {
        return appComponent;
    }
}
