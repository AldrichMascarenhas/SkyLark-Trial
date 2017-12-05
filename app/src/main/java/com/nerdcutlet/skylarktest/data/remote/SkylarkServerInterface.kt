package com.nerdcutlet.skylarktest.data.remote;

import com.nerdcutlet.skylarktest.ui.setdetail.model.remote.ImageResponse;
import com.nerdcutlet.skylarktest.ui.sets.model.local.SetResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Aldrich on 14-Nov-17.
 */

 interface SkylarkServerInterface {

    @GET("sets/")
    fun  getSkylarkSet() : Call<SetResponse>

    @GET("images/{image_id}/")
    fun getImage(@Path("image_id") image_id : String ) : Call<ImageResponse>

}
