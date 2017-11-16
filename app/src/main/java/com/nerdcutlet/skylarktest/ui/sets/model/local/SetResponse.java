
package com.nerdcutlet.skylarktest.ui.sets.model.local;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SetResponse {

    @SerializedName("objects")
    @Expose
    private List<SetObject> objects = null;

    public List<SetObject> getObjects() {
        return objects;
    }

    public void setObjects(List<SetObject> objects) {
        this.objects = objects;
    }

}
