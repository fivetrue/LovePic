package com.fivetrue.lovepic.vo;

import com.fivetrue.lovepic.util.JsonConvertUtil;

import org.json.JSONObject;

import io.realm.RealmObject;

/**
 * Created by Fivetrue on 2015-04-26.
 */
public class ImageVO extends RealmObject {
    private String source = null;
    private String width = null;
    private String height = null;

    public ImageVO(){

    }
    public ImageVO(JSONObject json) {
        source = JsonConvertUtil.convertJsonToString(json, JsonConvertUtil.SOURCE);
        width = JsonConvertUtil.convertJsonToString(json, JsonConvertUtil.WIDTH);
        width = JsonConvertUtil.convertJsonToString(json, JsonConvertUtil.HEIGHT);
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }
}
