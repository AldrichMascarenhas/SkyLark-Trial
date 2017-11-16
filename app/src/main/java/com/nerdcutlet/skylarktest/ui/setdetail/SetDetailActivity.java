package com.nerdcutlet.skylarktest.ui.setdetail;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.like.LikeButton;
import com.like.OnLikeListener;
import com.nerdcutlet.skylarktest.R;
import com.nerdcutlet.skylarktest.SkylarkApplication;
import com.nerdcutlet.skylarktest.di.setdetail.DaggerSetDetailComponent;
import com.nerdcutlet.skylarktest.di.setdetail.SetDetailModule;
import com.nerdcutlet.skylarktest.di.sets.DaggerSetComponent;
import com.nerdcutlet.skylarktest.di.sets.SetModule;
import com.nerdcutlet.skylarktest.ui.sets.model.local.SetObject;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SetDetailActivity extends AppCompatActivity implements SetDetailContract.View {
    private static final String TAG = "SetDetailActivity";

    private String uid;

    @Inject
    SetDetailPresenter setDetailPresenter;

    @BindView(R.id.image_view_activity_set_detail)
    ImageView imageView;

    @BindView(R.id.like_button_activity_set_detail)
    LikeButton likeButton;

    @BindView(R.id.text_view_activity_set_detail_content_title)
    TextView title;

    @BindView(R.id.text_view_activity_set_detail_content_film_count)
    TextView film_count;

    @BindView(R.id.text_view_activity_set_detail_content_quote)
    TextView quote;

    @BindView(R.id.text_view_activity_set_detail_content_summary)
    TextView summary;

    @BindView(R.id.text_view_activity_set_detail_content_body)
    TextView body;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_detail);

        Bundle bundle = getIntent().getExtras();

        try {
            uid = bundle.containsKey("uid") ? bundle.getString("uid") : "default";


        } catch (NullPointerException n) {
            Log.d(TAG, "Bundle error.");
        }


        DaggerSetDetailComponent.builder()
                .appComponent(((SkylarkApplication) getApplication()).getComponent())
                .setDetailModule(new SetDetailModule(this))
                .build()
                .inject(this);

        ButterKnife.bind(this);

        setDetailPresenter.attachView(this);
        setDetailPresenter.getSetObjectFromDatabase(uid);

    }

    @Override
    public void showData(final SetObject setObject) {

        if (setObject.getTitle() != null) {
            title.setText(setObject.getTitle());
        }

        if (setObject.getFilmCount() != null) {
            String film_count_string = "Film Count : " + setObject.getFilmCount();
            film_count.setText(film_count_string);
        }

        if (setObject.getQuote() != null) {
            quote.setText(setObject.getQuote());
        }

        if (setObject.getSummary() != null) {
            summary.setText(setObject.getSummary());
        }

        if (setObject.getBody() != null) {
            body.setText(setObject.getBody());
        }

        likeButton.setLiked(setObject.isFavourite());

        likeButton.setOnLikeListener(new OnLikeListener() {
            @Override
            public void liked(LikeButton likeButton) {
              setDetailPresenter.updateSetObjectFavouriteStatus(setObject.getUid(), true);
            }

            @Override
            public void unLiked(LikeButton likeButton) {
                setDetailPresenter.updateSetObjectFavouriteStatus(setObject.getUid(), false);

            }
        });

        if(!setObject.getImageUrls().isEmpty()){
            setDetailPresenter.getImageResponse(setObject.getImageUrls().get(0));
        }


    }

    @Override
    public void loadImage(String url) {


        Picasso.with(imageView.getContext()).load(url).into(imageView);


    }
}
