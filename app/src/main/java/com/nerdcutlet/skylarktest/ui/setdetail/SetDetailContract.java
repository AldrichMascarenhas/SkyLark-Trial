package com.nerdcutlet.skylarktest.ui.setdetail;

import com.nerdcutlet.skylarktest.ui.base.BasePresenter;
import com.nerdcutlet.skylarktest.ui.base.BaseView;
import com.nerdcutlet.skylarktest.ui.sets.model.local.SetObject;

/**
 * Created by Aldrich on 16-Nov-17.
 */

public interface SetDetailContract {

    interface View extends BaseView{
        void showData(SetObject setObject);

        void loadImage(String url);
    }
    interface Presenter extends BasePresenter<SetDetailContract.View>{
        void getSetObjectFromDatabase(String uid);

        void getImageResponse(String image_data);

        void updateSetObjectFavouriteStatus(String uid, boolean value);

    }
}
