package com.api.common;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Locale;

import org.apache.http.NameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.VolleyError;
import com.android.volley.Cache.Entry;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.fivetrue.dialog.ProgressDialog;
import com.fivetrue.network.NetworkToFileCache;
import com.fivetrue.network.VolleyInstance;
import com.parse.codec.binary.Hex;

import android.content.Context;

/**
 * Volley Connection ��� �κ�
 * @author Fivetrue
 *
 */
abstract public class ApiHelper <T>{

	protected Context mContext = null;
	protected int mCacheTime = 60000;
	protected ProgressDialog mDialog = null;

	protected IRequestResult mRequestResult = null;

	public ApiHelper(Context context){
		mContext = context;
		initDialog();
	}

	public ApiHelper(Context context, IRequestResult requestResult){
		mContext = context;
		mRequestResult = requestResult;
		initDialog();
	}
	
	protected void initDialog(){
		mDialog = new ProgressDialog(mContext);
		mDialog.setCanceledOnTouchOutside(false);
	}
	
	protected void showDialog(){
		if(mDialog != null){
			if(!mDialog.isShowing()){
				mDialog.show();
			}
		}
	}
	
	protected void dismissDialog(){
		if(mDialog != null){
			if(mDialog.isShowing()){
				mDialog.dismiss();
			}
		}
	}

	/**
	 * @param url Request URL
	 * @param converter JSON Parse Converter
	 * @param ll Respone Listener
	 */
	abstract public void requestApi(String url, BaseResponseConverter<T> converter, BaseResponseListener<T> ll);

	/**
	 * @param parameters
	 * @return
	 */
	abstract public String makeUrl(List<NameValuePair> parameters);

	/**
	 * @return ĳ�� ���� Ȯ��
	 */
	abstract public boolean isCache();

	/**
	 * @return ĳ�� �ð��� Millisecond�� ����
	 */
	abstract public int getCacheTime();


	/**
	 * @param realUrl
	 * @return
	 */
	protected String setCacheName(String realUrl){
		String cacheName = null;
		try {
			String temp = Hex.encodeHexString(realUrl.getBytes("utf-8"));
			cacheName = temp.substring(0, temp.length() > 255 ? 255 : temp.length());
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return cacheName;
	}

	/**
	 * volley  - get
	 * @param baseConverter
	 */

	protected void requestGet(String apiUrl, final BaseResponseConverter<T> baseConverter, final BaseResponseListener<T> responseListener){
		
		showDialog();
		long startTime = System.currentTimeMillis();

		final String url = checkUrlParameter(apiUrl);
		System.out.println("ojkwon : start = " + startTime);
		System.out.println("ojkwon : url = " + url);

		final Entry cacheEntry = VolleyInstance.getRequestQueue().getCache().get(url);

		if(cacheEntry != null && cacheEntry.data != null && isCache() && NetworkToFileCache.isCacheTimeCheck(mContext, getCacheTime(), setCacheName(url))){
			dismissDialog();
			String data = new String(cacheEntry.data);
			try {
				responseListener.onResponse(baseConverter.onReceive(new JSONObject(data)));
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}else{
			//network data
            JSONObject request = null;
			JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, request, new Listener<JSONObject>(){

				@Override
				public void onResponse(JSONObject jsonObject) {
					dismissDialog();
					if(jsonObject != null && jsonObject.toString() != null){
						long end = System.currentTimeMillis();
						System.out.println("ojkwon : endTime = " + end); 
						NetworkToFileCache.saveChacheTime(mContext, setCacheName(url));
						responseListener.onResponse(baseConverter.onReceive(jsonObject));
						if(mRequestResult != null){
							mRequestResult.onSuccessRequest(url,jsonObject);
						}
					}else{
					}
				}

			},  new ErrorListener() {

				@Override
				public void onErrorResponse(VolleyError error) {
					dismissDialog();
					long end = System.currentTimeMillis();
					System.out.println("ojkwon : Error = " + end); 
					if(responseListener != null){
						if(cacheEntry != null && cacheEntry.data != null){
							String data = new String(cacheEntry.data);
							try {
								responseListener.onResponse(baseConverter.onReceive(new JSONObject(data)));
								if(mRequestResult != null){
									mRequestResult.onFailRequest(url);
								}
							} catch (JSONException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}else{
							error.printStackTrace();
						}
					}
				}
			});

			jsonObjectRequest.setRetryPolicy(new DefaultRetryPolicy(
					30000, 
					DefaultRetryPolicy.DEFAULT_MAX_RETRIES, 
					DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

			//			VolleyInstance.getRequestQueue().add(jsonObjectRequest);
			Volley.newRequestQueue(mContext).add(jsonObjectRequest);

		}
	}

	private String checkUrlParameter(String url){
		System.out.println("ojkwon : language = " + Locale.getDefault().getLanguage());
		if(!url.contains(Constants.PARAM_LANG)){
			url += "&" + Constants.PARAM_LANG + "=" + Locale.getDefault().getLanguage();
		}
		return url;
	}

	/**
	 * @param CacheTime 
	 * �⺻ ĳ�� Ÿ�� 1��
	 */
	public void setCacheTime(int CacheTime) {
		this.mCacheTime = CacheTime;
	}



}
