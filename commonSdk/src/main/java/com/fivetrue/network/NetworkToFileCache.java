package com.fivetrue.network;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;

import com.fivetrue.preference.SharedPrefrenceManager;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Environment;


public class NetworkToFileCache {
	
	static public final String KEY = NetworkToFileCache.class.getCanonicalName();
	
	private static final int IO_BUFFER_SIZE = 8 * 1024;
	
	private Context context = null;
	public NetworkToFileCache(Context context){
		this.context = context;
	}
	
	@SuppressLint("NewApi")
	private String getJsonFileCachePath(){
		String cachePath = Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState()) ? (context.getExternalCacheDir() != null 
					? context.getExternalCacheDir().getPath() : context.getCacheDir().getPath()) : context.getCacheDir().getPath();
					
					
		File file = new File(cachePath);
		if(!file.exists()){
			file.mkdirs();
		}
		return file.getAbsolutePath();
	}
	
	
	public String getJsonFileCacheName(String fileName){
		return getJsonFileCachePath() + File.separator + fileName;
	}
	
	public void deleteCacheFile(String fileName){
		File file = new File(getJsonFileCacheName(fileName));
        if(file.exists()){
        	file.delete();
        }
	}
	
	public void writeJsonFileCache(String message, String fileName){
        File file = new File(getJsonFileCacheName(fileName));
        if(file.exists()){
        	file.delete();
        }
        Writer writer = null;
		try {
			writer = new BufferedWriter(new FileWriter(file), IO_BUFFER_SIZE);
			writer.write(message);
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
			try {
				if(writer != null){
					writer.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		SharedPrefrenceManager sharedPrefrenceManager = new SharedPrefrenceManager(context, KEY);
		sharedPrefrenceManager.savePref(fileName, System.currentTimeMillis());
	}
	
	public String readJsonFileCache(String fileName){
		File file = new File(getJsonFileCacheName(fileName));
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(file);
			return readFully(new InputStreamReader(fis, "utf-8"));
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
			try {
				if(fis != null){
					fis.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	
	public static String readFully(Reader reader) throws IOException {
        try {
            StringWriter writer = new StringWriter();
            char[] buffer = new char[1024];
            int count;
            while ((count = reader.read(buffer)) != -1) {
                writer.write(buffer, 0, count);
            }
            return writer.toString();
        } finally {
            reader.close();
        }
    }
	
	public static boolean isCache(Context context, long minute, String name){
		minute *= 60000;
		SharedPrefrenceManager sharedPrefrenceManager = new SharedPrefrenceManager(context, KEY);
		long cacheTime = sharedPrefrenceManager.loadLongPref(name);
		NetworkToFileCache mainJSonFileCache = new NetworkToFileCache(context);
		
		File file = new File(mainJSonFileCache.getJsonFileCacheName(name));
		
		return (cacheTime + minute) > System.currentTimeMillis() && file.exists() ? true : false;
	}
	
	public static boolean isCacheTimeCheck(Context context, long minute, String name){
		minute *= 60000;
		SharedPrefrenceManager sharedPrefrenceManager = new SharedPrefrenceManager(context, KEY);
		long cacheTime = sharedPrefrenceManager.loadLongPref(name);
		
		return (cacheTime + minute) > System.currentTimeMillis() ? true : false;
	}
	
	public static void saveChacheTime(Context context, String name){
		SharedPrefrenceManager sharedPrefrenceManager = new SharedPrefrenceManager(context, KEY);
		sharedPrefrenceManager.savePref(name, System.currentTimeMillis());
	}
	
}
