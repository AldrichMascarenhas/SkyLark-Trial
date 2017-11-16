package com.nerdcutlet.skylarktest.di.app;

import com.nerdcutlet.skylarktest.SkylarkApplication;
import com.nerdcutlet.skylarktest.data.remote.SkylarkServerInterface;
import com.nerdcutlet.skylarktest.di.data.LocalDataSourceModule;
import com.nerdcutlet.skylarktest.di.data.RemoteDataSourceModule;
import com.nerdcutlet.skylarktest.di.data.RepositoryModule;
import com.nerdcutlet.skylarktest.ui.sets.model.SetRepository;

import javax.inject.Singleton;

import dagger.Component;
import io.realm.Realm;

/**
 * Created by Aldrich on 14-Nov-17.
 */
@Singleton
@Component(
        modules = { AppModule.class,
                LocalDataSourceModule.class,
                RemoteDataSourceModule.class,
                RepositoryModule.class}
)
public interface AppComponent {

    void inject (SkylarkApplication skylarkApplication);

    SetRepository setRepository();

    Realm getRealm();

    SkylarkServerInterface getSkylarkServerInterface();

}
