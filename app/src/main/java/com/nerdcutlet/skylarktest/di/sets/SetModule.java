package com.nerdcutlet.skylarktest.di.sets;

import com.nerdcutlet.skylarktest.ui.sets.SetActivity;
import com.nerdcutlet.skylarktest.ui.sets.SetPresenter;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Aldrich on 15-Nov-17.
 */

@Module
public class SetModule {

    private final SetActivity setActivity;

    public SetModule(SetActivity setActivity) {
        this.setActivity = setActivity;
    }




}
