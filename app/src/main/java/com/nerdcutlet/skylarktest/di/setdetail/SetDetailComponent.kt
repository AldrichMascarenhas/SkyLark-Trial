package com.nerdcutlet.skylarktest.di.setdetail;

import com.nerdcutlet.skylarktest.di.annotation.ActivityScope
import com.nerdcutlet.skylarktest.di.app.AppComponent
import com.nerdcutlet.skylarktest.ui.setdetail.SetDetailActivity
import dagger.Component

/**
 * Created by Aldrich on 16-Nov-17.
 */
@ActivityScope
@Component(
        dependencies = arrayOf(AppComponent::class),
        modules = arrayOf(SetDetailModule::class)
)
interface SetDetailComponent {

    fun inject(setDetailActivity: SetDetailActivity)
}
