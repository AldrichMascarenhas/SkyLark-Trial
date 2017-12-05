package com.nerdcutlet.skylarktest.ui.sets

import com.nerdcutlet.skylarktest.ui.base.BasePresenter
import com.nerdcutlet.skylarktest.ui.base.BaseView
import com.nerdcutlet.skylarktest.ui.sets.model.local.SetObject

/**
 * Created by Aldrich on 15-Nov-17.
 */

interface SetContract {

    interface View : BaseView {

        fun showData(setObjects: List<SetObject>)

        fun showError()

        fun showNetworkError()

        fun showProgress()

        fun hideProgress()

    }

    interface Presenter : BasePresenter<SetContract.View> {

        fun getLocalData()

        fun updateData(refresh: Boolean)

        fun updateSetObjectFavouriteStatus(uid: String, value: Boolean)

    }
}
