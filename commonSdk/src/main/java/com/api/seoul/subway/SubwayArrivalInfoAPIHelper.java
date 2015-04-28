package com.api.seoul.subway;

import java.util.List;

import org.apache.http.NameValuePair;

import android.content.Context;
import com.api.common.ApiHelper;
import com.api.common.BaseResponseConverter;
import com.api.common.BaseResponseListener;
import com.api.common.IRequestResult;
import com.api.seoul.SeoulAPIConstants;
import com.api.seoul.subway.converter.SubwayArrivalInfoConverter;
import com.api.seoul.subway.entry.SubwayArrivalInfoEntry;
import com.api.seoul.subway.model.StationVO;

/**
 * @author Fivetrue
 * Subway API helper
 */
public class SubwayArrivalInfoAPIHelper extends ApiHelper <SubwayArrivalInfoEntry>{
	static public enum Day{
		WeekDay,
		SaturDay,
		Holiday
	}
	private int mCacheTime = 1000;
	
	public SubwayArrivalInfoAPIHelper(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}
	
	public SubwayArrivalInfoAPIHelper(Context context,  IRequestResult requestResult) {
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
			BaseResponseConverter<SubwayArrivalInfoEntry> converter,
			BaseResponseListener<SubwayArrivalInfoEntry> ll) {
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
	
	/**
	 * @return the mCacheTime
	 */
	public int getmCacheTime() {
		return mCacheTime;
	}

	/**
	 * @param mCacheTime the mCacheTime to set
	 */
	public void setmCacheTime(int mCacheTime) {
		this.mCacheTime = mCacheTime;
	}

	public void requestArrivalTime(StationVO vo, boolean isUpGoing, Day day, BaseResponseListener<SubwayArrivalInfoEntry> ll ){
		
		//http://openAPI.seoul.go.kr:8088/sample/xml/SearchArrivalTimeOfLine2SubwayByIDService/1/5/0201/1/1/
		String dayChecking = null;
		
		if(day == Day.WeekDay){
			dayChecking = SeoulAPIConstants.Subway.WEEKDAY;
		}else if(day == Day.SaturDay){
			dayChecking = SeoulAPIConstants.Subway.SATURDAY;
		}else{
			dayChecking = SeoulAPIConstants.Subway.HOLIDAY;
		}
		
		String direction = isUpGoing ? SeoulAPIConstants.Subway.UP_GOING : SeoulAPIConstants.Subway.DOWN_GOING;
		
		String url = SeoulAPIConstants.API_HOST
				+ SeoulAPIConstants.AUTH_KEY + "/"
				+ SeoulAPIConstants.TYPE_JSON + "/"
				+ SeoulAPIConstants.Subway.ARRIVAL_INFO_SERVICE + "/"
				+ SeoulAPIConstants.Subway.START_INDEX + "/"
				+ SeoulAPIConstants.Subway.END_INDEX + "/"
				+ vo.getStationCode() + "/"
				+  direction + "/"
				+  dayChecking + "/";
		requestApi(url, new SubwayArrivalInfoConverter(), ll);
		
	}

}
