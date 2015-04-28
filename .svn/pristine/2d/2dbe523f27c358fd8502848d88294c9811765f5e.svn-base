package com.fivetrue.lovepic.vo;

import com.fivetrue.lovepic.util.JsonConvertUtil;

import org.json.JSONObject;

import io.realm.RealmObject;
import io.realm.annotations.Ignore;
import io.realm.annotations.PrimaryKey;

/**
 * Created by Fivetrue on 2015-04-26.
 */
public class MeVO extends RealmObject {

    @PrimaryKey
    private String id = null;

    @Ignore
    private String firstName = null;
    private String timezone = null;
    private String email = null;
    private boolean verified = false;
    private String name = null;
    private String locale = null;
    private String link = null;
    private String last_name = null;
    private String gender = null;
    private String updatedTime = null;

    public MeVO() {
    }

    public MeVO(JSONObject jsonObject){
        id = JsonConvertUtil.convertJsonToString(jsonObject, JsonConvertUtil.ID);
        firstName = JsonConvertUtil.convertJsonToString(jsonObject, JsonConvertUtil.FIRST_NAME);
        timezone = JsonConvertUtil.convertJsonToString(jsonObject, JsonConvertUtil.TIMEZONE);
        email = JsonConvertUtil.convertJsonToString(jsonObject, JsonConvertUtil.EMAIL);
        verified = JsonConvertUtil.convertJsonToBoolean(jsonObject, JsonConvertUtil.VERIFIED);
        name = JsonConvertUtil.convertJsonToString(jsonObject, JsonConvertUtil.NAME);
        locale = JsonConvertUtil.convertJsonToString(jsonObject, JsonConvertUtil.LOCALE);
        link = JsonConvertUtil.convertJsonToString(jsonObject, JsonConvertUtil.LINK);
        last_name = JsonConvertUtil.convertJsonToString(jsonObject, JsonConvertUtil.LAST_NAME);
        gender = JsonConvertUtil.convertJsonToString(jsonObject, JsonConvertUtil.GENDER);
        updatedTime = JsonConvertUtil.convertJsonToString(jsonObject, JsonConvertUtil.UPDATED_TIME);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isVerified() {
        return verified;
    }

    public void setVerified(boolean verified) {
        this.verified = verified;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(String updatedTime) {
        this.updatedTime = updatedTime;
    }
}
