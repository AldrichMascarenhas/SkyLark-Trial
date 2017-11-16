package com.nerdcutlet.skylarktest.di.setdetail;

import com.nerdcutlet.skylarktest.ui.setdetail.SetDetailActivity;

import dagger.Module;

/**
 * Created by Aldrich on 16-Nov-17.
 */
@Module
public class SetDetailModule {

    private final SetDetailActivity setDetailActivity;

    public SetDetailModule(SetDetailActivity setDetailActivity) {
        this.setDetailActivity = setDetailActivity;
    }
}
