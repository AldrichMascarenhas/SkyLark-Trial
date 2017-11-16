package com.nerdcutlet.skylarktest.ui.sets;

import com.nerdcutlet.skylarktest.ui.base.BasePresenter;
import com.nerdcutlet.skylarktest.ui.base.BaseView;
import com.nerdcutlet.skylarktest.ui.sets.model.local.SetObject;

import java.util.List;

/**
 * Created by Aldrich on 15-Nov-17.
 */

public interface SetContract {

    interface View extends BaseView{

        void showData(List<SetObject> setObjects);

        void showError();

        void showNetworkError();

        void showProgress();

        void hideProgress();

    }

    interface Presenter extends BasePresenter<SetContract.View>{

        void getLocalData();

        void updateData(boolean refresh);

        void updateSetObjectFavouriteStatus(String uid, boolean value);

    }
}
