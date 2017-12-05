package com.nerdcutlet.skylarktest.ui.base;

/**
 * Created by Aldrich on 15-Nov-17.
 */

//TODO: Check invariance
interface BasePresenter<V : BaseView> {

    fun attachView(view : V)

    fun detachView()

    fun isViewAttached(): Boolean


}
