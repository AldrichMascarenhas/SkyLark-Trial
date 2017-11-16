package com.nerdcutlet.skylarktest.ui.base;

/**
 * Created by Aldrich on 15-Nov-17.
 */

public interface BasePresenter<V extends BaseView> {

    void attachView(V view);

    void detachView();

    boolean isViewAttached();


}
