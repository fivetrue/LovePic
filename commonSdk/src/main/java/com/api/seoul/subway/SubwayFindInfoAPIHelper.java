package com.api.seoul.subway;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

import org.apache.http.NameValuePair;

import android.content.Context;
import com.api.common.ApiHelper;
import com.api.common.BaseResponseConverter;
import com.api.common.BaseResponseListener;
import com.api.common.IRequestResult;
import com.api.seoul.SeoulAPIConstants;
import com.api.seoul.subway.converter.SubwayInfoConverter;
import com.api.seoul.subway.entry.SubwayInfoEntry;

/**
 * @author Fivetrue
 * Subway API helper
 */
public class SubwayFindInfoAPIHelper extends ApiHelper <SubwayInfoEntry>{
	
	private int mCacheTime = 0;
	
	public SubwayFindInfoAPIHelper(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}
	
	public SubwayFindInfoAPIHelper(Context context,  IRequestResult requestResult) {
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
			BaseResponseConverter<SubwayInfoEntry> converter,
			BaseResponseListener<SubwayInfoEntry> ll) {
		// TODO Auto-generated method stub
		requestGet(url, converter, ll);	
	}

	@Override
	public String makeUrl(List<NameValuePair> parameters) {
		// TODO Auto-generated method stub
		if(parameters != null && parameters.size() > 0){
			return null;				
		} 
		return null;
	}


	public void requestFindInfoSubway(String subwayName, BaseResponseListener<SubwayInfoEntry> ll){
		mCacheTime = 99999999;
		try {
			String subway = URLEncoder.encode(subwayName, "UTF-8");
			String url = SeoulAPIConstants.API_HOST
					+ SeoulAPIConstants.AUTH_KEY + "/"
					+ SeoulAPIConstants.TYPE_JSON + "/"
					+ SeoulAPIConstants.Subway.FIND_INFO_SERVICE + "/"
					+ SeoulAPIConstants.Subway.START_INDEX + "/"
					+ SeoulAPIConstants.Subway.END_INDEX + "/"
					+ subway + "/";
			requestApi(url, new SubwayInfoConverter(), ll);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
