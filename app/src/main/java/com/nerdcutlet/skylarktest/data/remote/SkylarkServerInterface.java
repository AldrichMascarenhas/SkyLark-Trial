package com.nerdcutlet.skylarktest.data.remote;

import com.nerdcutlet.skylarktest.ui.setdetail.model.remote.ImageResponse;
import com.nerdcutlet.skylarktest.ui.sets.model.local.SetResponse;

import io.reactivex.Observable;
import io.reactivex.Single;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Aldrich on 14-Nov-17.
 */

public interface SkylarkServerInterface {

    @GET("sets/")
    Call<SetResponse> getSkylarkSet();

    @GET("images/{image_id}/")
    Call<ImageResponse> getImage(@Path("image_id") String image_id);

}
