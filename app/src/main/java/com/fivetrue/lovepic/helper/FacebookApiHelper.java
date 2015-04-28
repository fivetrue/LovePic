package com.fivetrue.lovepic.helper;

import android.content.Context;

import com.facebook.AccessToken;
import com.facebook.GraphRequest;
import com.facebook.HttpMethod;


/**
 * Created by Fivetrue on 2015-04-26.
 */
public class FacebookApiHelper {

    private static FacebookApiHelper sInstance = null;

    private Context mContext = null;
    private AccessToken mAccessToken = null;
    private FacebookApiHelper(Context context, AccessToken accessToken){
        mContext = context;
        mAccessToken = accessToken;
    }

    public static void init(Context context, AccessToken accessToken){
        sInstance = new FacebookApiHelper(context, accessToken);
    }

    public static FacebookApiHelper getInstance(){
        if(sInstance == null){
            new IllegalAccessException("FacebookApiHelper must be init");
        }
        return sInstance;
    }

    public void getMe(GraphRequest.Callback callback){
        new GraphRequest(mAccessToken, "/me", null, HttpMethod.GET, callback).executeAsync();
    }

    public void getAlbums(GraphRequest.Callback callback){
        getAlbums("me", callback);
    }

    public void getAlbums(String userId, GraphRequest.Callback callback){
        new GraphRequest(mAccessToken, userId + "/albums", null, HttpMethod.GET, callback).executeAsync();
    }

    public void getPhotosOfAlbum(String albumId, GraphRequest.Callback callback){
        new GraphRequest(mAccessToken, albumId + "/photos", null, HttpMethod.GET, callback).executeAsync();
    }
}
