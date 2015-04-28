package com.api.google.directions.converter;

import java.util.ArrayList;

import org.json.JSONException;
import org.json.JSONObject;

import android.text.TextUtils;

import com.api.common.BaseResponseConverter;
import com.api.google.directions.DirectionsConstants;
import com.api.google.directions.entry.DirectionsEntry;
import com.api.google.directions.model.RouteVO;

public class DirectionsConverter implements BaseResponseConverter<DirectionsEntry>{
	
	@Override
	public DirectionsEntry onReceive(JSONObject json) {
		// TODO Auto-generated method stub
		DirectionsEntry entry = new DirectionsEntry();
		try {
			String status = json.getString(DirectionsConstants.STATUS);
			entry.setStatus(status);
			if(TextUtils.isEmpty(entry.getStatus()) || !entry.getStatus().equals(DirectionsConstants.Status.OK.toString())){
				return entry;
			}else{
				ArrayList<RouteVO> routeList = new RoutesConverter().onReceive(json);
				entry.setRouteArray(routeList);
			}
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return entry;
	}

}
