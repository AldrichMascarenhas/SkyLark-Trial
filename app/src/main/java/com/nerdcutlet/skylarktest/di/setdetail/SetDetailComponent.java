package com.nerdcutlet.skylarktest.di.setdetail;

import com.nerdcutlet.skylarktest.di.annotation.ActivityScope;
import com.nerdcutlet.skylarktest.di.app.AppComponent;
import com.nerdcutlet.skylarktest.di.sets.SetModule;
import com.nerdcutlet.skylarktest.ui.setdetail.SetDetailActivity;

import dagger.Component;

/**
 * Created by Aldrich on 16-Nov-17.
 */
@ActivityScope
@Component(
        dependencies = {AppComponent.class},
        modules = {SetDetailModule.class}
)
public interface SetDetailComponent {

    void inject(SetDetailActivity setDetailActivity);
}
