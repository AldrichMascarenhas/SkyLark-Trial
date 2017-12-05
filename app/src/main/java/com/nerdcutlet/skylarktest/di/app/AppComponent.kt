package com.nerdcutlet.skylarktest.di.app;

import com.nerdcutlet.skylarktest.SkylarkApplication
import com.nerdcutlet.skylarktest.data.remote.SkylarkServerInterface
import com.nerdcutlet.skylarktest.di.data.LocalDataSourceModule
import com.nerdcutlet.skylarktest.di.data.RemoteDataSourceModule
import com.nerdcutlet.skylarktest.di.data.RepositoryModule
import com.nerdcutlet.skylarktest.ui.sets.model.SetRepository
import dagger.Component
import io.realm.Realm
import javax.inject.Singleton

/**
 * Created by Aldrich on 14-Nov-17.
 */
@Singleton
@Component(
        modules = arrayOf(AppModule::class,
                LocalDataSourceModule::class,
                RemoteDataSourceModule::class,
                RepositoryModule::class)
)
interface AppComponent {

    fun inject(skylarkApplication: SkylarkApplication)

    fun setRepository(): SetRepository

    fun getRealm(): Realm

    fun getSkylarkServerInterface(): SkylarkServerInterface

}
