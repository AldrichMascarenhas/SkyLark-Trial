package com.nerdcutlet.skylarktest.di.sets;

import com.nerdcutlet.skylarktest.ui.sets.SetActivity
import dagger.Module
import dagger.Provides

/**
 * Created by Aldrich on 15-Nov-17.
 */

@Module
class SetModule(private val setActivity: SetActivity) {

    @Provides
    fun providesSetActivity(): SetActivity = setActivity

}
