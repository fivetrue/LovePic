package com.api.google.directions;

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
import com.api.google.directions.converter.DirectionsConverter;
import com.api.google.directions.entry.DirectionsEntry;

/**
 * @author Fivetrue
 * Google Direction API Helper
 */
public class DirectionsAPIHelper extends ApiHelper <DirectionsEntry>{

	public DirectionsAPIHelper(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}
	
	public DirectionsAPIHelper(Context context, IRequestResult requestResult) {
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
		return mCacheTime;
	}
	
	@Override
	public void requestApi(String url,
			BaseResponseConverter<DirectionsEntry> converter,
			BaseResponseListener<DirectionsEntry> ll) {
		// TODO Auto-generated method stub
		requestGet(url, converter, ll);	
	}


	@Override
	public String makeUrl(List<NameValuePair> parameters) {
		// TODO Auto-generated method stub
		if(parameters != null && parameters.size() > 0){
			return makeDirectionsURL(parameters);				
		} 
		return null;
	}
	
	private String makeDirectionsURL(List<NameValuePair> parameters){
		String url = Constants.GoogleDirectionsAPI.DIRECTION_API_HOST;
		for(NameValuePair param : parameters){
			url += param.getName() + "=" + param.getValue() + "&";
		}
		return url;
	}
	
	/**
	 * @param latitude 위도
	 * @param logitude 경도
	 * @param desLatitude 도착지 위도
	 * @param desLongitude 도착지 경도
	 * @param departureTime 출발 시간
	 * @param ll 
	 */
	public void requestTransitModeDirections(double latitude, double logitude, double desLatitude, double desLongitude, long departureTime,
			BaseResponseListener<DirectionsEntry> ll){
		requestTransitModeDirections(String.valueOf(latitude), String.valueOf(logitude), String.valueOf(desLatitude),
				String.valueOf(desLongitude), String.valueOf(departureTime), ll);
	}
	
	/**
	 * @param latitude 위도
	 * @param logitude 경도
	 * @param desLatitude 도착지 위도
	 * @param desLongitude 도착지 경도
	 * @param departureTime 출발 시간
	 * @param ll 
	 */
	public void requestTransitModeDirections(String latitude, String logitude, String desLatitude, String desLongitude, String departureTime,
			BaseResponseListener<DirectionsEntry> ll){
		requestTransitModeDirections(latitude + "," + logitude,
				desLatitude + "," + desLongitude,
				departureTime, ll);
	}
	
	/**
	 * @param departure 출발지 주소 혹은 위도,경도
	 * @param destination 도착지 주소 혹은 위도,경도
	 * @param departureTime 출발 시간
	 * @param ll
	 */
	public void requestTransitModeDirections(String departure, String destination, String departureTime, BaseResponseListener<DirectionsEntry> ll){
		List<NameValuePair> list = new ArrayList<NameValuePair>();
		list.add(new BasicNameValuePair(Constants.GoogleDirectionsAPI.PARAM_DEPARTURE,  departure));
		list.add(new BasicNameValuePair(Constants.GoogleDirectionsAPI.PARAM_DESTINATION,  destination));
		list.add(new BasicNameValuePair(Constants.GoogleDirectionsAPI.PARAM_SENSOR,  "true"));
		list.add(new BasicNameValuePair(Constants.GoogleDirectionsAPI.PARAM_DEPARTURE_TIME,  departureTime));
		list.add(new BasicNameValuePair(Constants.GoogleDirectionsAPI.PARAM_ALTERNATIVES,  "true"));
		list.add(new BasicNameValuePair(Constants.GoogleDirectionsAPI.PARAM_MODE,  Constants.GoogleDirectionsAPI.MODE_TRANSIT));
		requestApi(makeUrl(list), new DirectionsConverter(), ll);
	}
}
