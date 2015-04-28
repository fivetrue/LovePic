package com.fivetrue.lovepic;

import android.app.Application;
import android.content.Context;

import com.facebook.FacebookSdk;
import com.fivetrue.lovepic.preference.ImagePreference;
import com.fivetrue.network.VolleyInstance;

/**
 * Created by kwonojin on 15. 3. 10..
 */
public class LovePicApp extends Application{

    private static LovePicApp sLovePicApp = null;

    public static void init(Application app){
        sLovePicApp = new LovePicApp(app);
    }

    public LovePicApp(Application app){
        initApplicationSetting(app);
    }

    public void initApplicationSetting(Application app){
        ImagePreference.init(app);
        VolleyInstance.init(app);
        FacebookSdk.sdkInitialize(app);
    }


}
