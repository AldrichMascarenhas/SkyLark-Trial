package com.nerdcutlet.skylarktest.di.data;

import com.nerdcutlet.skylarktest.di.annotation.Local
import com.nerdcutlet.skylarktest.di.annotation.Remote
import com.nerdcutlet.skylarktest.ui.sets.model.SetDataSource
import com.nerdcutlet.skylarktest.ui.sets.model.SetRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by Aldrich on 14-Nov-17.
 */

@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun provideSetRepository(@Local setLocalDataSource: SetDataSource, @Remote setRemoteDataSource: SetDataSource): SetRepository {
        return SetRepository(setLocalDataSource, setRemoteDataSource);
    }

}
