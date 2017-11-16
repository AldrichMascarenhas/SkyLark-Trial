package com.nerdcutlet.skylarktest.ui.sets;

import android.content.Intent;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.nerdcutlet.skylarktest.R;
import com.nerdcutlet.skylarktest.SkylarkApplication;
import com.nerdcutlet.skylarktest.di.sets.DaggerSetComponent;
import com.nerdcutlet.skylarktest.di.sets.SetModule;
import com.nerdcutlet.skylarktest.ui.setdetail.SetDetailActivity;
import com.nerdcutlet.skylarktest.ui.setfavourite.SetFavouriteActivity;
import com.nerdcutlet.skylarktest.ui.sets.model.local.SetObject;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static android.support.design.widget.Snackbar.LENGTH_LONG;

public class SetActivity extends AppCompatActivity implements SetContract.View, SetAdapter.InteractionListener {
    private static final String TAG = "SetActivity";

    //Inject
    @Inject
    SetPresenter setPresenter;

    @Inject
    SetAdapter setAdapter;

    //ButterKnife
    @BindView(R.id.recycler_view_activity_set)
    RecyclerView recyclerView;

    @BindView(R.id.swipe_refresh_layout_activity_set)
    SwipeRefreshLayout swipeRefreshLayout;

    @BindView(R.id.coordinator_layout_activity_set)
    CoordinatorLayout coordinatorLayout;

    @BindView(R.id.progress_bar_layout)
    ProgressBar progressBar;

    @BindView(R.id.fab_activity_set)
    FloatingActionButton floatingActionButton;

    @OnClick(R.id.fab_activity_set)
    void goToFavouriteActivity(){
        Intent intent = new Intent(this, SetFavouriteActivity.class);
        startActivity(intent);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set);

        DaggerSetComponent.builder()
                .appComponent(((SkylarkApplication) getApplication()).getComponent())
                .setModule(new SetModule(this))
                .build()
                .inject(this);

        ButterKnife.bind(this);


        setPresenter.attachView(this);
        setPresenter.updateData(true);

        initViews();

    }

    public void initViews() {

        setAdapter.setListInteractionListener(this);

        recyclerView.setAdapter(setAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);


        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                setPresenter.updateData(true);
            }
        });

    }

    //Interaction

    @Override
    public void onListClick(String uid) {
        Intent intent = new Intent(this, SetDetailActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("uid", uid);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    //Likes
    @Override
    public void liked(String uid) {
        Toast.makeText(getApplicationContext(), "Liked" + uid, Toast.LENGTH_SHORT).show();
        setPresenter.updateSetObjectFavouriteStatus(uid, true);

    }

    @Override
    public void unLiked(String uid) {
        Toast.makeText(getApplicationContext(), "UnLiked" + uid, Toast.LENGTH_SHORT).show();
        setPresenter.updateSetObjectFavouriteStatus(uid, false);
    }

    @Override
    public void showProgress() {
        if (setAdapter.isEmpty() && !swipeRefreshLayout.isRefreshing()) {
            progressBar.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void hideProgress() {
        swipeRefreshLayout.setRefreshing(false);
        progressBar.setVisibility(View.GONE);
    }


    @Override
    public void showData(List<SetObject> setObjects) {
        Log.d(TAG, "setObjects received");

        setAdapter.setSetObjectList(setObjects);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }

    @Override
    public void showError() {
        Snackbar.make(coordinatorLayout, "Can't load data.", LENGTH_LONG).show();

    }

    @Override
    public void showNetworkError() {
        Snackbar.make(coordinatorLayout, "Check Network.", LENGTH_LONG).show();

    }
}
