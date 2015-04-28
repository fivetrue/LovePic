package com.fivetrue.lovepic.preference;

import android.content.Context;
import android.content.SharedPreferences;

import com.fivetrue.preference.SharedPrefrenceManager;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by kwonojin on 15. 3. 12..
 */
public class ImagePreference extends SharedPrefrenceManager {
    private static String PREF_NAME = "image_preference";
    private static String URL_KEY_PREF_FIX = "url_";

    private static ImagePreference sPref = null;

    private ArrayList<String> mUrlList = null;

    public static void init(Context context){
        sPref = new ImagePreference(context);
    }

    public static ImagePreference getInstance(Context context){
        if(sPref == null){
            sPref = new ImagePreference(context);
        }
        return sPref;
    }

    private ImagePreference(Context context) {
        super(context, PREF_NAME);
        mUrlList = new ArrayList<>();
        loadUrls();
    }

    private void loadUrls(){
        int count = 0 ;
        while(true){
            String url = loadStringPref(URL_KEY_PREF_FIX + count, null);
            if(url != null){
                mUrlList.add(url);
            }else{
                break;
            }
        }
    }

    public void addImageUrl(String url){
        savePref(URL_KEY_PREF_FIX + mUrlList.size(), url);
        mUrlList.add(url);
    }

    public ArrayList<String> getImageUrls(){
        return mUrlList;
    }
}
