package com.nerdcutlet.skylarktest.ui.sets;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.like.LikeButton;
import com.like.OnLikeListener;
import com.nerdcutlet.skylarktest.R;
import com.nerdcutlet.skylarktest.SkylarkApplication;
import com.nerdcutlet.skylarktest.data.remote.SkylarkServerInterface;
import com.nerdcutlet.skylarktest.ui.setdetail.model.remote.ImageResponse;
import com.nerdcutlet.skylarktest.ui.sets.model.local.SetObject;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Aldrich on 15-Nov-17.
 */

public class SetAdapter extends RecyclerView.Adapter<SetAdapter.SetAdapterViewHolder> {
    private static final String TAG = "SetAdapter";

    private List<SetObject> setObjectList;
    private InteractionListener interactionListener;
    private SkylarkServerInterface skylarkServerInterface;

    @Inject
    public SetAdapter(SkylarkServerInterface skylarkServerInterface) {
        setObjectList = new ArrayList<>();
        this.interactionListener = null;
        this.skylarkServerInterface = skylarkServerInterface;
    }

    @Override
    public SetAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.set_item, parent, false);
        return new SetAdapterViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final SetAdapterViewHolder holder, final int position) {

        holder.setIsRecyclable(false);
        //check ^

        holder.item_title.setText(setObjectList.get(position).getTitle());
        holder.film_count.setText("" + setObjectList.get(position).getFilmCount());

        holder.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (interactionListener != null) {
                    interactionListener.onListClick(setObjectList.get(position).getUid());
                }
            }
        });
        Log.d(TAG, "status : " + setObjectList.get(position).isFavourite());

        holder.likeButton.setLiked(setObjectList.get(position).isFavourite());

        holder.likeButton.setOnLikeListener(new OnLikeListener() {
            @Override
            public void liked(LikeButton likeButton) {
                if (interactionListener != null) {
                    interactionListener.liked(setObjectList.get(position).getUid());
                }
            }

            @Override
            public void unLiked(LikeButton likeButton) {
                if (interactionListener != null) {
                    interactionListener.unLiked(setObjectList.get(position).getUid());
                }
            }
        });


        if (setObjectList.get(position).getImage_temporary() != null) {

            Log.d(TAG, "Pos : " + position + "Temp : " + setObjectList.get(position).getImage_temporary());
            Picasso.with(holder.image.getContext()).load(setObjectList.get(holder.getAdapterPosition()).getImage_temporary()).into(holder.image);


        }


    }

    @Override
    public int getItemCount() {
        return setObjectList.size();
    }

    public boolean isEmpty() {
        return setObjectList.isEmpty();
    }

    public void setSetObjectList(List<SetObject> setObjectList) {
        this.setObjectList = setObjectList;
        notifyDataSetChanged();
    }

    class SetAdapterViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.text_view_set_item_title)
        TextView item_title;

        @BindView(R.id.text_view_set_item_film_count)
        TextView film_count;

        @BindView(R.id.image_view_set_item)
        ImageView image;

        @BindView(R.id.like_button_set_item_favourite)
        LikeButton likeButton;

        public SetAdapterViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }


    /**
     * Interface for handling list interactions
     */
    public interface InteractionListener {
        void onListClick(String uid);

        void liked(String uid);

        void unLiked(String uid);
    }

    public void setListInteractionListener(InteractionListener interactionListener) {
        this.interactionListener = interactionListener;
    }

}
