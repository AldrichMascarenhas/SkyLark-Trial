package com.nerdcutlet.skylarktest

import android.app.Application
import com.nerdcutlet.skylarktest.di.app.AppComponent
import com.nerdcutlet.skylarktest.di.app.AppModule
import com.nerdcutlet.skylarktest.di.app.DaggerAppComponent
import com.nerdcutlet.skylarktest.di.data.LocalDataSourceModule
import com.nerdcutlet.skylarktest.di.data.RemoteDataSourceModule
import com.nerdcutlet.skylarktest.di.data.RepositoryModule

/**
 * Created by Aldrich on 14-Nov-17.
 */

class SkylarkApplication : Application() {

    private var appComponent: AppComponent? = null


    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent.builder()
                .appModule(AppModule(this))
                .localDataSourceModule(LocalDataSourceModule())
                .remoteDataSourceModule(RemoteDataSourceModule())
                .repositoryModule(RepositoryModule())
                .build()

        appComponent?.inject(this)

    }

    fun getComponent(): AppComponent? {
        return appComponent
    }
}
