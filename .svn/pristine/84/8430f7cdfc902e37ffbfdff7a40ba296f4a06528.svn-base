package com.fivetrue.lovepic.vo;

import com.fivetrue.lovepic.util.JsonConvertUtil;

import org.json.JSONObject;

import io.realm.RealmObject;
import io.realm.annotations.Ignore;
import io.realm.annotations.PrimaryKey;

/**
 * Created by Fivetrue on 2015-04-26.
 */
public class UserVO extends RealmObject {

    @PrimaryKey
    private String id = null;

    @Ignore
    private String name = null;

    public UserVO(){}

    public UserVO(JSONObject jsonObject){
        id = JsonConvertUtil.convertJsonToString(jsonObject, JsonConvertUtil.ID);
        name = JsonConvertUtil.convertJsonToString(jsonObject, JsonConvertUtil.NAME);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
