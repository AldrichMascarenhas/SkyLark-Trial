package com.nerdcutlet.skylarktest.ui.setdetail.model.remote;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Aldrich on 16-Nov-17.
 */

public class ImageResponse {

    @SerializedName("uid")
    @Expose
    private String uid;
    @SerializedName("show")
    @Expose
    private Boolean show;
    @SerializedName("content_url")
    @Expose
    private String contentUrl;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("image_type_url")
    @Expose
    private String imageTypeUrl;
    @SerializedName("upload_image_url")
    @Expose
    private String uploadImageUrl;
    @SerializedName("language_version_url")
    @Expose
    private String languageVersionUrl;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("created")
    @Expose
    private String created;
    @SerializedName("image_type")
    @Expose
    private String imageType;
    @SerializedName("self")
    @Expose
    private String self;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("language_publish_on")
    @Expose
    private String languagePublishOn;
    @SerializedName("language_version_number")
    @Expose
    private Integer languageVersionNumber;
    @SerializedName("language_modified")
    @Expose
    private String languageModified;
    @SerializedName("position")
    @Expose
    private Integer position;
    @SerializedName("align")
    @Expose
    private String align;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public Boolean getShow() {
        return show;
    }

    public void setShow(Boolean show) {
        this.show = show;
    }

    public String getContentUrl() {
        return contentUrl;
    }

    public void setContentUrl(String contentUrl) {
        this.contentUrl = contentUrl;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImageTypeUrl() {
        return imageTypeUrl;
    }

    public void setImageTypeUrl(String imageTypeUrl) {
        this.imageTypeUrl = imageTypeUrl;
    }

    public String getUploadImageUrl() {
        return uploadImageUrl;
    }

    public void setUploadImageUrl(String uploadImageUrl) {
        this.uploadImageUrl = uploadImageUrl;
    }

    public String getLanguageVersionUrl() {
        return languageVersionUrl;
    }

    public void setLanguageVersionUrl(String languageVersionUrl) {
        this.languageVersionUrl = languageVersionUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getImageType() {
        return imageType;
    }

    public void setImageType(String imageType) {
        this.imageType = imageType;
    }

    public String getSelf() {
        return self;
    }

    public void setSelf(String self) {
        this.self = self;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLanguagePublishOn() {
        return languagePublishOn;
    }

    public void setLanguagePublishOn(String languagePublishOn) {
        this.languagePublishOn = languagePublishOn;
    }

    public Integer getLanguageVersionNumber() {
        return languageVersionNumber;
    }

    public void setLanguageVersionNumber(Integer languageVersionNumber) {
        this.languageVersionNumber = languageVersionNumber;
    }

    public String getLanguageModified() {
        return languageModified;
    }

    public void setLanguageModified(String languageModified) {
        this.languageModified = languageModified;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public String getAlign() {
        return align;
    }

    public void setAlign(String align) {
        this.align = align;
    }
}
