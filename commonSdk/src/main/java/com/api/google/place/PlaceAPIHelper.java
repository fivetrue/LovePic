package com.api.google.place;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import android.content.Context;

import com.android.common.R;
import com.api.common.ApiHelper;
import com.api.common.BaseResponseConverter;
import com.api.common.BaseResponseListener;
import com.api.common.Constants;
import com.api.common.IRequestResult;
import com.api.google.place.converter.PlacesConverter;
import com.api.google.place.entry.PlacesEntry;

public class PlaceAPIHelper extends ApiHelper <PlacesEntry>{

	static public enum API_TYPE{
		NEAR_BY_SEARCH,
		TEXT_SEARCH,
	}
	
	public API_TYPE mType = null;
	
	public PlaceAPIHelper(Context context, API_TYPE type) {
		super(context);
		mType = type;
		// TODO Auto-generated constructor stub
	}
	
	public PlaceAPIHelper(Context context, API_TYPE type,  IRequestResult requestResult) {
		super(context, requestResult);
		// TODO Auto-generated constructor stub
		mType = type;
	}
	
//	public PlaceAPIHelper(Context context){
//		super(context);
//	}

	@Override
	public String makeUrl(List<NameValuePair> parameters) {
		// TODO Auto-generated method stub
		if(parameters != null && parameters.size() > 0){
			if(mType == API_TYPE.NEAR_BY_SEARCH){
				return makeNearBySearchURL(parameters);				
			}else if(mType == API_TYPE.TEXT_SEARCH){
				return makeTextSearchURL(parameters);
			}
		} 
		return null;
	}

	@Override
	public void requestApi(String url, BaseResponseConverter<PlacesEntry> converter,
			BaseResponseListener<PlacesEntry> ll) {
		// TODO Auto-generated method stub
		requestGet(url, converter, ll);
	}

	@Override
	public boolean isCache() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public int getCacheTime() {
		// TODO Auto-generated method stub
		return 6000000;
	}
	
	private String makeNearBySearchURL(List<NameValuePair> parameters){
		String url = Constants.GooglePlaceAPI.PLACE_API_HOST + Constants.GooglePlaceAPI.PLACE_NEAR_BY_SEARCH;
		for(NameValuePair param : parameters){
			url += param.getName() + "=" + param.getValue() + "&";
		}
//		return url + Constants.GooglePlaceAPI.PARAM_API_KEY + "=" + Constants.GooglePlaceAPI.API_KEY;
		return url + Constants.GooglePlaceAPI.PARAM_API_KEY + "=" + mContext.getString(R.string.api_google_key);
	}
	
	private String makeTextSearchURL(List<NameValuePair> parameters){
		return null;
	}
	
	/**
	 * @param latitude ����
	 * @param logitude �浵
	 * @param radius ���� ��ġ �ݰ�
	 * @param converter
	 * @param ll
	 **/
	public void requestNearBySearchSubway(double latitude, double logitude, int radius, BaseResponseListener<PlacesEntry> ll){
		requestNearBySearchSubway(String.valueOf(latitude), String.valueOf(logitude), String.valueOf(radius), ll);
	}
	
	/**
	 * @param latitude ����
	 * @param logitude �浵
	 * @param radius ���� ��ġ �ݰ�
	 * @param converter 
	 * @param ll
	 */
	public void requestNearBySearchSubway(String latitude, String logitude, String radius, BaseResponseListener<PlacesEntry> ll){
		requestNearBySearchSubway(latitude + "," + logitude, radius, ll);
	}
	
	
	/**
	 * @param location ���� ��ġ �ּ� �Ǵ� ����,�浵
	 * @param radius �ݰ�
	 * @param converter 
	 * @param ll
	 */
	public void requestNearBySearchSubway(String location, String radius, BaseResponseListener<PlacesEntry> ll){
		List<NameValuePair> list = new ArrayList<NameValuePair>();
		list.add(new BasicNameValuePair(Constants.GooglePlaceAPI.PARAM_LOCATION,  location));
		list.add(new BasicNameValuePair(Constants.GooglePlaceAPI.PARAM_RADIUS,  radius));
		list.add(new BasicNameValuePair(Constants.GooglePlaceAPI.PARAM_SENSOR,  "true"));
		list.add(new BasicNameValuePair(Constants.GooglePlaceAPI.PARAM_TYPES,  Constants.GooglePlaceAPI.TYPES_SUBWAY_STATION));
		requestApi(makeNearBySearchURL(list), new PlacesConverter(), ll);
	}
}
