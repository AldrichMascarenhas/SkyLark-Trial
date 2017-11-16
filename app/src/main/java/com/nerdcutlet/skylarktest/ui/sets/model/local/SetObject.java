
package com.nerdcutlet.skylarktest.ui.sets.model.local;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;



import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;


public class SetObject extends RealmObject{

    @SerializedName("uid")
    @PrimaryKey
    @Expose
    private String uid;
    @SerializedName("schedule_urls")
    @Expose
    private RealmList<String> scheduleUrls = new RealmList<>();
    @SerializedName("publish_on")
    @Expose
    private String publishOn;
    @SerializedName("quoter")
    @Expose
    private String quoter;
    @SerializedName("featured")
    @Expose
    private Boolean featured;
    @SerializedName("cached_film_count")
    @Expose
    private Integer cachedFilmCount;
    @SerializedName("temp_id")
    @Expose
    private Integer tempId;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("self")
    @Expose
    private String self;
    @SerializedName("created_by")
    @Expose
    private String createdBy;
    @SerializedName("language_publish_on")
    @Expose
    private String languagePublishOn;
    @SerializedName("language_modified")
    @Expose
    private String languageModified;
    @SerializedName("has_price")
    @Expose
    private Boolean hasPrice;
    @SerializedName("set_type_url")
    @Expose
    private String setTypeUrl;
    @SerializedName("temp_image")
    @Expose
    private String tempImage;
    @SerializedName("film_count")
    @Expose
    private Integer filmCount;
    @SerializedName("body")
    @Expose
    private String body;
    @SerializedName("language_version_url")
    @Expose
    private String languageVersionUrl;
    @SerializedName("quote")
    @Expose
    private String quote;
    @SerializedName("formatted_body")
    @Expose
    private String formattedBody;
    @SerializedName("image_urls")
    @Expose
    private RealmList<String> imageUrls = new RealmList<>();
    @SerializedName("schedule_url")
    @Expose
    private String scheduleUrl;
    @SerializedName("active")
    @Expose
    private Boolean active;
    @SerializedName("slug")
    @Expose
    private String slug;
    @SerializedName("version_number")
    @Expose
    private Integer versionNumber;
    @SerializedName("language_ends_on")
    @Expose
    private String languageEndsOn;
    @SerializedName("created")
    @Expose
    private String created;
    @SerializedName("items")
    @Expose
    private RealmList<Item> items =  new RealmList<>();
    @SerializedName("language_version_number")
    @Expose
    private Integer languageVersionNumber;
    @SerializedName("modified")
    @Expose
    private String modified;
    @SerializedName("summary")
    @Expose
    private String summary;
    @SerializedName("ends_on")
    @Expose
    private String endsOn;
    @SerializedName("version_url")
    @Expose
    private String versionUrl;
    @SerializedName("set_type_slug")
    @Expose
    private String setTypeSlug;

    private boolean isFavourite;

    private String image_temporary;

    public String getImage_temporary() {
        return image_temporary;
    }

    public void setImage_temporary(String image_temporary) {
        this.image_temporary = image_temporary;
    }

    public boolean isFavourite() {
        return isFavourite;
    }

    public void setFavourite(boolean favourite) {
        isFavourite = favourite;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public RealmList<String> getScheduleUrls() {
        return scheduleUrls;
    }

    public void setScheduleUrls(RealmList<String> scheduleUrls) {
        this.scheduleUrls = scheduleUrls;
    }

    public String getPublishOn() {
        return publishOn;
    }

    public void setPublishOn(String publishOn) {
        this.publishOn = publishOn;
    }

    public String getQuoter() {
        return quoter;
    }

    public void setQuoter(String quoter) {
        this.quoter = quoter;
    }

    public Boolean getFeatured() {
        return featured;
    }

    public void setFeatured(Boolean featured) {
        this.featured = featured;
    }

    public Integer getCachedFilmCount() {
        return cachedFilmCount;
    }

    public void setCachedFilmCount(Integer cachedFilmCount) {
        this.cachedFilmCount = cachedFilmCount;
    }

    public Integer getTempId() {
        return tempId;
    }

    public void setTempId(Integer tempId) {
        this.tempId = tempId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSelf() {
        return self;
    }

    public void setSelf(String self) {
        this.self = self;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getLanguagePublishOn() {
        return languagePublishOn;
    }

    public void setLanguagePublishOn(String languagePublishOn) {
        this.languagePublishOn = languagePublishOn;
    }

    public String getLanguageModified() {
        return languageModified;
    }

    public void setLanguageModified(String languageModified) {
        this.languageModified = languageModified;
    }

    public Boolean getHasPrice() {
        return hasPrice;
    }

    public void setHasPrice(Boolean hasPrice) {
        this.hasPrice = hasPrice;
    }

    public String getSetTypeUrl() {
        return setTypeUrl;
    }

    public void setSetTypeUrl(String setTypeUrl) {
        this.setTypeUrl = setTypeUrl;
    }

    public String getTempImage() {
        return tempImage;
    }

    public void setTempImage(String tempImage) {
        this.tempImage = tempImage;
    }

    public Integer getFilmCount() {
        return filmCount;
    }

    public void setFilmCount(Integer filmCount) {
        this.filmCount = filmCount;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getLanguageVersionUrl() {
        return languageVersionUrl;
    }

    public void setLanguageVersionUrl(String languageVersionUrl) {
        this.languageVersionUrl = languageVersionUrl;
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    public String getFormattedBody() {
        return formattedBody;
    }

    public void setFormattedBody(String formattedBody) {
        this.formattedBody = formattedBody;
    }

    public RealmList<String> getImageUrls() {
        return imageUrls;
    }

    public void setImageUrls(RealmList<String> imageUrls) {
        this.imageUrls = imageUrls;
    }

    public String getScheduleUrl() {
        return scheduleUrl;
    }

    public void setScheduleUrl(String scheduleUrl) {
        this.scheduleUrl = scheduleUrl;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public Integer getVersionNumber() {
        return versionNumber;
    }

    public void setVersionNumber(Integer versionNumber) {
        this.versionNumber = versionNumber;
    }

    public String getLanguageEndsOn() {
        return languageEndsOn;
    }

    public void setLanguageEndsOn(String languageEndsOn) {
        this.languageEndsOn = languageEndsOn;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public RealmList<Item> getItems() {
        return items;
    }

    public void setItems(RealmList<Item> items) {
        this.items = items;
    }

    public Integer getLanguageVersionNumber() {
        return languageVersionNumber;
    }

    public void setLanguageVersionNumber(Integer languageVersionNumber) {
        this.languageVersionNumber = languageVersionNumber;
    }

    public String getModified() {
        return modified;
    }

    public void setModified(String modified) {
        this.modified = modified;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getEndsOn() {
        return endsOn;
    }

    public void setEndsOn(String endsOn) {
        this.endsOn = endsOn;
    }

    public String getVersionUrl() {
        return versionUrl;
    }

    public void setVersionUrl(String versionUrl) {
        this.versionUrl = versionUrl;
    }

    public String getSetTypeSlug() {
        return setTypeSlug;
    }

    public void setSetTypeSlug(String setTypeSlug) {
        this.setTypeSlug = setTypeSlug;
    }

}
