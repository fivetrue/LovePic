package com.api.google.geocoding;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import android.content.Context;
import com.api.common.ApiHelper;
import com.api.common.BaseResponseConverter;
import com.api.common.BaseResponseListener;
import com.api.common.Constants;
import com.api.common.IRequestResult;
import com.api.google.geocoding.converter.GeocodingConverter;
import com.api.google.geocoding.entry.GeocodingEntry;

/**
 * @author Fivetrue
 * Google Geocoding API Helper
 */
public class GeocodingAPIHelper extends ApiHelper <GeocodingEntry>{
	private int mGeoCodeCacheTIme = 99999999; 
	public GeocodingAPIHelper(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}
	
	public GeocodingAPIHelper(Context context, IRequestResult requestResult) {
		super(context, requestResult);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean isCache() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public int getCacheTime() {
		// TODO Auto-generated method stub
		return mGeoCodeCacheTIme;
	}
	
	@Override
	public void requestApi(String url,
			BaseResponseConverter<GeocodingEntry> converter,
			BaseResponseListener<GeocodingEntry> ll) {
		// TODO Auto-generated method stub
		requestGet(url, converter, ll);	
	}


	@Override
	public String makeUrl(List<NameValuePair> parameters) {
		// TODO Auto-generated method stub
		if(parameters != null && parameters.size() > 0){
			return makeGeocodingUrl(parameters);				
		} 
		return null;
	}
	
	private String makeGeocodingUrl(List<NameValuePair> parameters){
		String url = Constants.GoogleGeocodingAPI.GEOCODING_API_HOST;
		for(NameValuePair param : parameters){
			url += param.getName() + "=" + param.getValue() + "&";
		}
		return url;
	}
	
	
	/**
	 * @return the mGeoCodeCacheTIme
	 */
	public int getGeoCodeCacheTIme() {
		return mGeoCodeCacheTIme;
	}

	/**
	 * @param mGeoCodeCacheTIme the mGeoCodeCacheTIme to set
	 */
	public void setGeoCodeCacheTIme(int GeoCodeCacheTIme) {
		this.mGeoCodeCacheTIme = GeoCodeCacheTIme;
	}

	/**
	 * @param latitude 위도
	 * @param logitude 경도
	 * @param desLatitude 도착지 위도
	 * @param desLongitude 도착지 경도
	 * @param departureTime 출발 시간
	 * @param ll 
	 */
	public void reqeustRevertGeocoding(double latitude, double logitude, BaseResponseListener<GeocodingEntry> ll){
		reqeustRevertGeocoding(String.valueOf(latitude), String.valueOf(logitude), ll);
	}
	
	public void reqeustRevertGeocoding(String latitude, String longitude, BaseResponseListener<GeocodingEntry> ll){
		reqeustRevertGeocoding(latitude + "," + longitude, ll);
	}
	
	public void reqeustRevertGeocoding(String latLng, BaseResponseListener<GeocodingEntry> ll){
		List<NameValuePair> list = new ArrayList<NameValuePair>();
		list.add(new BasicNameValuePair(Constants.GoogleGeocodingAPI.PARAM_LATLNG,  latLng));
		list.add(new BasicNameValuePair(Constants.GoogleDirectionsAPI.PARAM_SENSOR,  "false"));
		requestApi(makeUrl(list), new GeocodingConverter(), ll);
	}
	
	/**
	 * @param address 주소
	 * @param ll
	 */
	public void requestGeocoding(String address, BaseResponseListener<GeocodingEntry> ll){
		try {
			String urlConvert = URLEncoder.encode(address, "UTF-8");
			List<NameValuePair> list = new ArrayList<NameValuePair>();
			list.add(new BasicNameValuePair(Constants.GoogleGeocodingAPI.PARAM_ADDRESS,  urlConvert));
			list.add(new BasicNameValuePair(Constants.GoogleDirectionsAPI.PARAM_SENSOR,  "false"));
			requestApi(makeUrl(list), new GeocodingConverter(), ll);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
