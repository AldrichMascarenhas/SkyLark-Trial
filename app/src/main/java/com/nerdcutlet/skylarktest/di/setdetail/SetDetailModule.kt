package com.nerdcutlet.skylarktest.di.setdetail;

import com.nerdcutlet.skylarktest.ui.setdetail.SetDetailActivity;

import dagger.Module;
import dagger.Provides

/**
 * Created by Aldrich on 16-Nov-17.
 */
@Module
class SetDetailModule(private val setDetailActivity: SetDetailActivity) {

    @Provides
    fun provideSetDetailActivity(): SetDetailActivity = setDetailActivity

}
