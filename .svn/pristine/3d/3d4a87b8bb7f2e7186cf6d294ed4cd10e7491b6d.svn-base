package com.api.google.directions.converter;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.api.common.BaseResponseConverter;
import com.api.google.directions.DirectionsConstants;
import com.api.google.directions.model.RouteVO;
import com.api.google.directions.model.steps.StepTransitVO;


public class RoutesConverter implements BaseResponseConverter<ArrayList<RouteVO>> {

	@Override
	public ArrayList<RouteVO> onReceive(JSONObject json) {
		// TODO Auto-generated method stub
		ArrayList<RouteVO> routeList = new ArrayList<RouteVO>();
		try {
			JSONArray arrRoute = json.getJSONArray(DirectionsConstants.ROUTES);
			
			for(int i = 0 ; i < arrRoute.length() ; i ++){
				JSONObject route = arrRoute.getJSONObject(i);
				routeList.add(getRoute(route));
			}
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return routeList;
	}
	
	public RouteVO getRoute(JSONObject route) throws JSONException{
		
		RouteVO vo = new RouteVO();
		String northEastLat = route.getJSONObject(DirectionsConstants.BOUNDS).getJSONObject(DirectionsConstants.NORTHEAST).getString(DirectionsConstants.LATITUDE);
		String northEastLnt = route.getJSONObject(DirectionsConstants.BOUNDS).getJSONObject(DirectionsConstants.NORTHEAST).getString(DirectionsConstants.LONGITUDE);
		String southWestLat = route.getJSONObject(DirectionsConstants.BOUNDS).getJSONObject(DirectionsConstants.SOUTHWEST).getString(DirectionsConstants.LATITUDE);
		String southWestLnt = route.getJSONObject(DirectionsConstants.BOUNDS).getJSONObject(DirectionsConstants.SOUTHWEST).getString(DirectionsConstants.LONGITUDE);
		
		vo.setNorthEastLatitude(northEastLat);
		vo.setNorthEastLongitude(northEastLnt);
		vo.setSouthWestLatitude(southWestLat);
		vo.setSouthWestLongitude(southWestLnt);
		
		String copyRight = route.getString(DirectionsConstants.COPY_RIGHTS);
		String overviewPolyline = route.getJSONObject(DirectionsConstants.OVERVIEW_POLYLINE).getString(DirectionsConstants.POINTS);
		String summary = route.getString(DirectionsConstants.SUMMARY);
		String warring = route.getJSONArray(DirectionsConstants.WARRINGS).getString(0);
		vo.setCopyRights(copyRight);
		vo.setOverviewPolylinePoints(overviewPolyline);
		vo.setSummary(summary);
		vo.setWarring(warring);
		JSONObject leg = route.getJSONArray(DirectionsConstants.LEGS).getJSONObject(0);
		
		if(!leg.isNull(DirectionsConstants.ARRIVAL_TIME)){
			String arrivalTimeText = leg.getJSONObject(DirectionsConstants.ARRIVAL_TIME).getString(DirectionsConstants.TEXT);
			String arrivalTimeZone = leg.getJSONObject(DirectionsConstants.ARRIVAL_TIME).getString(DirectionsConstants.TIME_ZONE);
			String arrivalTimeValue = leg.getJSONObject(DirectionsConstants.ARRIVAL_TIME).getString(DirectionsConstants.VALUE);
			vo.setArrivalTimeText(arrivalTimeText);
			vo.setArrivalTimeZone(arrivalTimeZone);
			vo.setArrivalTimeValue(arrivalTimeValue);
		}
		
		if(!leg.isNull(DirectionsConstants.DEPARTURE_TIME)){
			String departureTimeText = leg.getJSONObject(DirectionsConstants.DEPARTURE_TIME).getString(DirectionsConstants.TEXT);
			String departureTimeZone = leg.getJSONObject(DirectionsConstants.DEPARTURE_TIME).getString(DirectionsConstants.TIME_ZONE);
			String departureTimeValue = leg.getJSONObject(DirectionsConstants.DEPARTURE_TIME).getString(DirectionsConstants.VALUE);
			vo.setDepartureTimeText(departureTimeText);
			vo.setDepartureTimeZone(departureTimeZone);
			vo.setDepartureTimeValue(departureTimeValue);
		}
		
		String distanceText = leg.getJSONObject(DirectionsConstants.DISTANCE).getString(DirectionsConstants.TEXT);
		String distanceValue = leg.getJSONObject(DirectionsConstants.DISTANCE).getString(DirectionsConstants.VALUE);
		vo.setDistanceText(distanceText);
		vo.setDistanceValue(distanceValue);
		
		String endAddress = leg.getString(DirectionsConstants.END_ADDRESS);
		String endLat = leg.getJSONObject(DirectionsConstants.END_LOCATION).getString(DirectionsConstants.LATITUDE);
		String endLnt = leg.getJSONObject(DirectionsConstants.END_LOCATION).getString(DirectionsConstants.LONGITUDE);
		vo.setArrivalAddress(endAddress);
		vo.setArrivalLatidute(endLat);
		vo.setArrivalLongitude(endLnt);
		
		String startAddress = leg.getString(DirectionsConstants.START_ADDRESS);
		String startLat = leg.getJSONObject(DirectionsConstants.START_LOCATION).getString(DirectionsConstants.LATITUDE);
		String startLnt = leg.getJSONObject(DirectionsConstants.START_LOCATION).getString(DirectionsConstants.LONGITUDE);
		vo.setDepartureAddress(startAddress);
		vo.setDepartureLatidute(startLat);
		vo.setDepartureLongitude(startLnt);
		ArrayList<StepTransitVO> stepInfo = new StepsConverter().onReceive(leg);
		vo.setStepInfo(stepInfo);
		return vo;
	}
}
