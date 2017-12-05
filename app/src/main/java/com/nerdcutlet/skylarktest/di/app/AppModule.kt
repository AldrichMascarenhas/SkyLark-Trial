package com.nerdcutlet.skylarktest.di.app;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Aldrich on 14-Nov-17.
 */
@Module
class AppModule(private val context : Context) {

    @Provides
    fun provideContext() = context

}
