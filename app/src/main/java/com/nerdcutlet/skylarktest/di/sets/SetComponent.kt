package com.nerdcutlet.skylarktest.di.sets;

import com.nerdcutlet.skylarktest.di.annotation.ActivityScope;
import com.nerdcutlet.skylarktest.di.app.AppComponent;
import com.nerdcutlet.skylarktest.ui.sets.SetActivity;

import dagger.Component;

/**
 * Created by Aldrich on 15-Nov-17.
 */

@ActivityScope
@Component(
        dependencies = arrayOf(AppComponent::class),
        modules = arrayOf(SetModule::class)
)
interface SetComponent {

    fun inject(setActivity: SetActivity)
}
