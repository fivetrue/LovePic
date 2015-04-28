package com.fivetrue.utils;

import android.util.Log;

public class Logger {
	static private final int DEBUG_MODE = 0;
	static private final int RELEASE_MODE = 1;
	static private int MODE = DEBUG_MODE;
	static private String PRE_TAG = "fivetrue_";
	
	static public void e(String tag, String msg){
		if(checkMode()){
			return ;
		}
		Log.e(PRE_TAG + tag, msg);
	}
	
	static public void d(String tag, String msg){
		if(checkMode()){
			return ;
		}
		Log.d(PRE_TAG + tag, msg);
	}
	
	static public void w(String tag, String msg){
		if(checkMode()){
			return ;
		}
		Log.w(PRE_TAG + tag, msg);
	}
	
	static public void i(String tag, String msg){
		if(checkMode()){
			return ;
		}
		Log.i(PRE_TAG + tag, msg);
	}
	
	static public void v(String tag, String msg){
		if(checkMode()){
			return ;
		}
		Log.v(PRE_TAG + tag, msg);
	}
	
	static private boolean checkMode(){
		if(MODE == RELEASE_MODE)
			return true;
		else
			return false;
	}
}
