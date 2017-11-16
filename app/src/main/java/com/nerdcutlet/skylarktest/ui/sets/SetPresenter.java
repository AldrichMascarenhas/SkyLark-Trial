package com.nerdcutlet.skylarktest.ui.sets;

import android.util.Log;

import com.google.gson.TypeAdapterFactory;
import com.nerdcutlet.skylarktest.ui.sets.model.SetRepository;
import com.nerdcutlet.skylarktest.ui.sets.model.local.SetObject;
import com.nerdcutlet.skylarktest.ui.sets.model.local.SetResponse;

import java.io.IOException;
import java.net.SocketTimeoutException;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Scheduler;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.HttpException;
import retrofit2.Response;

/**
 * Created by Aldrich on 15-Nov-17.
 */

public class SetPresenter implements SetContract.Presenter {

    private static final String TAG = "SetPresenter";
    private SetContract.View view;
    private SetRepository setRepository;


    @Inject
    public SetPresenter(SetRepository setRepository) {
        this.setRepository = setRepository;
    }

    @Override
    public void attachView(SetContract.View view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        view = null;
    }

    @Override
    public boolean isViewAttached() {
        return view != null;
        //TODO
    }

    @Override
    public void getLocalData() {

        Log.d(TAG, "Try getLocalData");

        if (!setRepository.getSetFromDatabase().isEmpty()) {
            //Display

            Log.d(TAG, "getLocalData successful");
            Log.d(TAG, "Local size : " + setRepository.getSetFromDatabase().size());

            view.showData(setRepository.getSetFromDatabase());


        } else {
            //Show Error
            Log.d(TAG, "getLocalData failed");
            view.showError();

        }


    }

    @Override
    public void updateData(boolean refresh) {

        view.showProgress();

        setRepository.getSetFromRemote().enqueue(new Callback<SetResponse>() {
            @Override
            public void onResponse(Call<SetResponse> call, Response<SetResponse> response) {

                view.hideProgress();

                if (response.isSuccessful()) {

                    Log.d(TAG, "Remote successful");

                    List<SetObject> setObjects = response.body().getObjects();
                    Log.d(TAG, "Size : " + setObjects.size());
                    for (SetObject setObject : setObjects) {
                        setRepository.addsetObject(setObject);
                    }



                } else {
                    view.showNetworkError();

                }
                getLocalData();

            }

            @Override
            public void onFailure(Call<SetResponse> call, Throwable t) {

                view.hideProgress();

                if (t instanceof HttpException) {
                    Log.d(TAG, "HttpException: " + ((HttpException) t).response().errorBody());
                } else if (t instanceof SocketTimeoutException) {
                    Log.d(TAG, "SocketTimeoutException: " + t.getMessage());
                } else if (t instanceof IOException) {
                    Log.d(TAG, "IOException: " + t.getMessage());
                } else {
                    Log.d(TAG, "Exception: " + t.getMessage());
                }

                view.showNetworkError();

                //Failure. Try loading from database
                Log.d(TAG, "Remote failed");
                getLocalData();

            }
        });


    }

    @Override
    public void updateSetObjectFavouriteStatus(String uid, boolean value) {
        setRepository.updateSetObjectFavouriteStatus(uid, value);
    }


}


