package com.nerdcutlet.skylarktest.ui.setdetail.model.remote;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Aldrich on 16-Nov-17.
 */

data class ImageResponse(
        @SerializedName("url") @Expose var  url : String
)