package com.fivetrue.lovepic.util;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Fivetrue on 2015-04-26.
 */
public class JsonConvertUtil {
    public static final String DATA = "data";
    public static final String ID = "id";
    public static final String FIRST_NAME = "first_name";
    public static final String TIMEZONE = "timezone";
    public static final String EMAIL = "email";
    public static final String VERIFIED = "verified";
    public static final String LOCALE = "locale";
    public static final String LAST_NAME = "last_name";
    public static final String GENDER = "gender";
    public static final String COVER_PHOTO = "cover_photo";
    public static final String COUNT = "count";
    public static final String LINK = "link";
    public static final String NAME = "name";
    public static final String SOURCE = "source";
    public static final String WIDTH = "width";
    public static final String HEIGHT = "height";
    public static final String PRIVACY = "privacy";
    public static final String CAN_UPLOAD = "can_upload";
    public static final String FROM = "from";
    public static final String CREATED_TIME = "created_time";
    public static final String TYPE = "type";
    public static final String UPDATED_TIME = "updated_time";
    public static final String PICTURE = "picture";
    public static final String ICON = "icon";
    public static final String IMAGES = "images";



    public static String convertJsonToString(JSONObject json, String tag){
        String value = "";
        if(json != null && tag != null && !json.isNull(tag)){
            try {
                value = json.getString(tag);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return value;
    }

    public static int convertJsonToInt(JSONObject json, String tag){
        int value = 0;
        if(json != null && tag != null &&  !json.isNull(tag)){
            try {
                value = json.getInt(tag);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return value;
    }

    public static boolean convertJsonToBoolean(JSONObject json, String tag){
        boolean value = false;
        if(json != null &&  tag != null && !json.isNull(tag)){
            try {
                value = json.getBoolean(tag);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return value;
    }

    public static JSONObject convertJsonToJsonObject(JSONObject json, String tag){
        JSONObject value = new JSONObject();
        if(json != null &&  tag != null && !json.isNull(tag)){
            try {
                value = json.getJSONObject(tag);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return value;
    }

    public static JSONObject getFacebookDataFromJsonObject(JSONObject json){
        JSONObject value = new JSONObject();
        if(json != null &&  !json.isNull(DATA)){
            try {
                value = json.getJSONObject(DATA);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return value;
    }

    public static JSONArray getJsonArrayFromJsonObject(JSONObject json, String tag){
        JSONArray value = new JSONArray();
        if(json != null && tag != null && !json.isNull(tag)){
            try {
                value = json.getJSONArray(tag);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return value;
    }

    public static JSONArray getFacebookDataFromJsonArray(JSONObject json){
        JSONArray value = new JSONArray();
        if(json != null &&  !json.isNull(DATA)){
            try {
                value = json.getJSONArray(DATA);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return value;
    }
}
