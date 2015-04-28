package com.fivetrue.lovepic.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.fivetrue.lovepic.LovePicApp;
import com.fivetrue.lovepic.billing.IAPHelper;
import com.fivetrue.lovepic.helper.FacebookApiHelper;

import java.util.Arrays;
import java.util.List;

public class LoadingActivity extends FragmentActivity{
    private List<String> PERMISSIONS = Arrays.asList("public_profile",
            "user_friends",
            "email",
            "user_photos");


    private CallbackManager mCallbackManager = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initData();
        startLoading();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        IAPHelper.unbindBillingService(this);
    }

    private void initData(){
        LovePicApp.init(getApplication());
        IAPHelper.bindBillingService(LoadingActivity.this);
        mCallbackManager = CallbackManager.Factory.create();
    }

    private void startLoading(){

        LoginManager.getInstance().registerCallback(mCallbackManager ,new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                Log.e("ojkwon", "onSuccess : " + loginResult.toString());
                FacebookApiHelper.init(LoadingActivity.this, loginResult.getAccessToken());
                startActivity(new Intent(LoadingActivity.this, MainActivity.class));
                LoadingActivity.this.finish();
            }

            @Override
            public void onCancel() {
                Log.e("ojkwon", "onCancel");
            }

            @Override
            public void onError(FacebookException error) {
                Log.e("ojkwon", "error : " + error.toString());
                LoginManager.getInstance().logOut();
                LoginManager.getInstance().logInWithReadPermissions(LoadingActivity.this, PERMISSIONS);
            }
        });
        LoginManager.getInstance().logInWithReadPermissions(this, PERMISSIONS);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(mCallbackManager != null){
            mCallbackManager.onActivityResult(requestCode, resultCode, data);
        }
    }
}
