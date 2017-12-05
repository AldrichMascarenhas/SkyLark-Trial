package com.nerdcutlet.skylarktest.ui.sets.model.local

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import io.realm.RealmList
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

/**
 * Created by aldrichmascarenhas on 05/12/2017.
 */

open class SetResponse( 
        @SerializedName("objects") @Expose var objects : List<SetObject>)

open class SetObject(
        // You can put properties in the constructor as long as all of them are initialized with
        // default values. This ensures that an empty constructor is generated.
        // All properties are by default persisted.
        //Example -> https://github.com/realm/realm-java/blob/master/examples/kotlinExample/src/main/kotlin/io/realm/examples/kotlin/model/Person.kt

        @SerializedName("uid") @PrimaryKey @Expose var uid: String = "",
        @SerializedName("title") @Expose var title: String = "",
        @SerializedName("body") @Expose var body: String = "",
        @SerializedName("quote") @Expose var quote: String = "",
        @SerializedName("image_urls") @Expose var imageUrls: RealmList<String>? = null,
        @SerializedName("summary") @Expose var summary: String? = "",
        @SerializedName("film_count") @Expose var filmCount: Int = 0
) : RealmObject() {
    var isFavourite: Boolean = false
}