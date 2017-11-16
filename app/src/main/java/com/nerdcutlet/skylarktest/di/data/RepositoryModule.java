package com.nerdcutlet.skylarktest.di.data;

import com.nerdcutlet.skylarktest.di.annotation.Local;
import com.nerdcutlet.skylarktest.di.annotation.Remote;
import com.nerdcutlet.skylarktest.ui.sets.model.SetDataSource;
import com.nerdcutlet.skylarktest.ui.sets.model.SetRepository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Aldrich on 14-Nov-17.
 */

@Module
public class RepositoryModule {

    @Singleton
    @Provides
    SetRepository provideSetRepository(@Local SetDataSource setLocalDataSource, @Remote SetDataSource setRemoteDataSource){
        return new SetRepository(setLocalDataSource, setRemoteDataSource);
    }

}
