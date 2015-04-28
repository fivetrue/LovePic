package com.fivetrue.lovepic.vo;

import com.fivetrue.lovepic.util.JsonConvertUtil;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


/**
 * Created by Fivetrue on 2015-04-26.
 */
public class PictureVO {

    private String id = null;

    private String picture = null;
    private String icon = null;
    private String height = null;
    private String width = null;
    private String source = null;
    private String link = null;
    private ArrayList<ImageVO> images = null;
    private UserVO uploader = null;
    private String createdTime = null;
    private String updatedTime = null;

    public PictureVO(){

    }
    public PictureVO(JSONObject jsonObject) {
        picture = JsonConvertUtil.convertJsonToString(jsonObject, JsonConvertUtil.PICTURE);
        id = JsonConvertUtil.convertJsonToString(jsonObject, JsonConvertUtil.ID);
        icon = JsonConvertUtil.convertJsonToString(jsonObject, JsonConvertUtil.ICON);
        height = JsonConvertUtil.convertJsonToString(jsonObject, JsonConvertUtil.HEIGHT);
        width = JsonConvertUtil.convertJsonToString(jsonObject, JsonConvertUtil.WIDTH);
        source = JsonConvertUtil.convertJsonToString(jsonObject, JsonConvertUtil.SOURCE);
        link = JsonConvertUtil.convertJsonToString(jsonObject, JsonConvertUtil.LINK);
        JSONArray jImages = JsonConvertUtil.getJsonArrayFromJsonObject(jsonObject, JsonConvertUtil.IMAGES);
        ArrayList<ImageVO> arrImages = new ArrayList<>();
        for(int i = 0 ; i < jImages.length() ; i ++){
            try {
                ImageVO image = new ImageVO(jImages.getJSONObject(i));
                arrImages.add(image);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        images =  arrImages;
        uploader = new UserVO(JsonConvertUtil.convertJsonToJsonObject(jsonObject, JsonConvertUtil.FROM));
        createdTime = JsonConvertUtil.convertJsonToString(jsonObject, JsonConvertUtil.CREATED_TIME);
        updatedTime = JsonConvertUtil.convertJsonToString(jsonObject, JsonConvertUtil.UPDATED_TIME);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public ArrayList<ImageVO> getImages() {
        return images;
    }

    public void setImages(ArrayList<ImageVO> images) {
        this.images = images;
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

    public String getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(String updatedTime) {
        this.updatedTime = updatedTime;
    }

    @Override
    public String toString() {
        return "PictureVO{" +
                "id='" + id + '\'' +
                ", picture='" + picture + '\'' +
                ", icon='" + icon + '\'' +
                ", height='" + height + '\'' +
                ", width='" + width + '\'' +
                ", source='" + source + '\'' +
                ", link='" + link + '\'' +
                ", images=" + images +
                ", uploader=" + uploader +
                ", createdTime='" + createdTime + '\'' +
                ", updatedTime='" + updatedTime + '\'' +
                '}';
    }
}
