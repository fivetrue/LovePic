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
import com.api.google.place.converter.PlacesDetailConverter;
import com.api.google.place.entry.PlacesDetailEntry;

public class PlaceDetailAPIHelper extends ApiHelper <PlacesDetailEntry>{

	static public enum API_TYPE{
		NEAR_BY_SEARCH,
		TEXT_SEARCH,
	}
	
	public PlaceDetailAPIHelper(Context context, IRequestResult requestResult) {
		super(context, requestResult);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String makeUrl(List<NameValuePair> parameters) {
		// TODO Auto-generated method stub
		if(parameters != null && parameters.size() > 0){
			String url = Constants.GooglePlaceAPI.PLACE_API_HOST + Constants.GooglePlaceAPI.PLACE_DETAIL;
			for(NameValuePair param : parameters){
				url += param.getName() + "=" + param.getValue() + "&";
			}
			return url + Constants.GooglePlaceAPI.PARAM_API_KEY + "=" + mContext.getString(R.string.api_google_key);
		} 
		return null;
	}

	@Override
	public void requestApi(String url, BaseResponseConverter<PlacesDetailEntry> converter,
			BaseResponseListener<PlacesDetailEntry> ll) {
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
	
	/**
	 * @param location ���� ��ġ �ּ� �Ǵ� ����,�浵
	 * @param radius �ݰ�
	 * @param converter 
	 * @param ll
	 */
	public void requestPlaceDetail(String refrenceId, BaseResponseListener<PlacesDetailEntry> ll){
		List<NameValuePair> list = new ArrayList<NameValuePair>();
		list.add(new BasicNameValuePair(Constants.GooglePlaceAPI.PARAM_REFERENCE,  refrenceId));
		list.add(new BasicNameValuePair(Constants.GooglePlaceAPI.PARAM_SENSOR,  "true"));
		requestApi(makeUrl(list), new PlacesDetailConverter(), ll);
	}
}
