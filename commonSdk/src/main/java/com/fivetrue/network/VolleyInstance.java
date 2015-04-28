package com.fivetrue.network;


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.support.v4.util.LruCache;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;

public class VolleyInstance {
	
	private static RequestQueue requestQueue = null;
	private static ImageLoader imageLoader = null;
	
	public static int DISK_IMAGECACHE_SIZE = 1024 * 1024 * 20;
	public static int MEMORY_IMAGECACHE_SIZE = (int) (Runtime.getRuntime().maxMemory() / 6);
	public static CompressFormat DISK_IMAGECACHE_COMPRESS_FORMAT = CompressFormat.JPEG;
	public static int DISK_IMAGECACHE_QUALITY = 100;
	
	private VolleyInstance(){}
	
	public static RequestQueue getRequestQueue(){
		if(requestQueue == null){
			throw new RuntimeException("requestQueue null");
		}
		return requestQueue;
	}
	
	public static ImageLoader getImageLoader(){
		if(imageLoader == null){
			throw new RuntimeException("imageLoader null");
		}
		return imageLoader;
	}
	
	public static class LruMemoryCache extends LruCache<String, Bitmap>{

		public LruMemoryCache(int maxSize) {
			super(maxSize);
		}
		
		@Override
		protected int sizeOf(String key, Bitmap value) {
			int size = value.getRowBytes() * value.getHeight();
			return size;
		}
		
		public int availableSize(){
			return maxSize() - size();
		}
	}
	
	private static LruMemoryCache lruMemoryCache = null;
	public static void init(Context context){
		requestQueue = Volley.newRequestQueue(context);
		
	    if(MEMORY_IMAGECACHE_SIZE > ((60 * 1024) * 1024)){
	    	MEMORY_IMAGECACHE_SIZE = 60 * 1024 * 1024;
	    }
	    
		
	    lruMemoryCache = new LruMemoryCache(MEMORY_IMAGECACHE_SIZE);
		
		ImageLoader.ImageCache imageCache = new ImageLoader.ImageCache() {
			
			@Override
			public void putBitmap(String key, Bitmap value) {
				lruMemoryCache.put(key, value);
			}
			
			@Override
			public Bitmap getBitmap(String key) {
				return lruMemoryCache.get(key);
			}
		};
		
		imageLoader = new ImageLoader(requestQueue, imageCache);
	}

	public static LruMemoryCache getLruCache() {
		return lruMemoryCache;
	}
	
}
