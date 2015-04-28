package com.fivetrue.lovepic.vo;

import com.fivetrue.lovepic.util.JsonConvertUtil;

import org.json.JSONObject;

import io.realm.RealmObject;
import io.realm.annotations.Ignore;
import io.realm.annotations.PrimaryKey;

/**
 * Created by Fivetrue on 2015-04-26.
 */
public class AlbumVO extends RealmObject{
    @PrimaryKey
    private String id = null;

    @Ignore
    private String coverPhoto = null;
    private int count = 0;
    private String link = null;
    private String name = null;
    private String privacy = null;
    private boolean canUpload = false;
    private UserVO uploader = null;
    private String createdTime = null;
    private String type = null;
    private String updatedTime = null;

    public AlbumVO(){

    }

    public AlbumVO(JSONObject jsonObject){
        if(jsonObject != null){
            id = JsonConvertUtil.convertJsonToString(jsonObject, JsonConvertUtil.ID);
            coverPhoto = JsonConvertUtil.convertJsonToString(jsonObject, JsonConvertUtil.COVER_PHOTO);
            count = JsonConvertUtil.convertJsonToInt(jsonObject, JsonConvertUtil.COUNT);
            link = JsonConvertUtil.convertJsonToString(jsonObject, JsonConvertUtil.LINK);
            name = JsonConvertUtil.convertJsonToString(jsonObject, JsonConvertUtil.NAME);
            privacy = JsonConvertUtil.convertJsonToString(jsonObject,JsonConvertUtil. PRIVACY);
            canUpload = JsonConvertUtil.convertJsonToBoolean(jsonObject, JsonConvertUtil.CAN_UPLOAD);
            uploader = new UserVO(JsonConvertUtil.convertJsonToJsonObject(jsonObject, JsonConvertUtil.FROM));
            name = JsonConvertUtil.convertJsonToString(jsonObject,JsonConvertUtil. NAME);
            createdTime = JsonConvertUtil.convertJsonToString(jsonObject, JsonConvertUtil.CREATED_TIME);
            type = JsonConvertUtil.convertJsonToString(jsonObject, JsonConvertUtil.TYPE);
            updatedTime = JsonConvertUtil.convertJsonToString(jsonObject, JsonConvertUtil.UPDATED_TIME);
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCoverPhoto() {
        return coverPhoto;
    }

    public void setCoverPhoto(String coverPhoto) {
        this.coverPhoto = coverPhoto;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrivacy() {
        return privacy;
    }

    public void setPrivacy(String privacy) {
        this.privacy = privacy;
    }

    public boolean isCanUpload() {
        return canUpload;
    }

    public void setCanUpload(boolean canUpload) {
        this.canUpload = canUpload;
    }

    public UserVO getUploader() {
        return uploader;
    }

    public void setUploader(UserVO uploader) {
        this.uploader = uploader;
    }

    public String getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(String updatedTime) {
        this.updatedTime = updatedTime;
    }
}
