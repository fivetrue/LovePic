package com.api.seoul.subway.converter;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.api.common.BaseResponseConverter;
import com.api.seoul.SeoulAPIConstants;
import com.api.seoul.subway.entry.SubwayArrivalInfoEntry;
import com.api.seoul.subway.model.SubwayVO;

public class SubwayArrivalInfoConverter implements BaseResponseConverter<SubwayArrivalInfoEntry>{

	@Override
	public SubwayArrivalInfoEntry onReceive(JSONObject json) {
		// TODO Auto-generated method stub
		SubwayArrivalInfoEntry entry = new SubwayArrivalInfoEntry();
		if(json.isNull(SeoulAPIConstants.Subway.ARRIVAL_INFO_SERVICE)){
			return entry;
		}
		
		try {
			JSONObject arrivalInfo = json.getJSONObject(SeoulAPIConstants.Subway.ARRIVAL_INFO_SERVICE);
			String resultCode = arrivalInfo.getJSONObject(SeoulAPIConstants.Subway.RESULT).getString(SeoulAPIConstants.Subway.RESULT_CODE);
			entry.setStatus(resultCode);
			String resultMessage = arrivalInfo.getJSONObject(SeoulAPIConstants.Subway.RESULT).getString(SeoulAPIConstants.Subway.RESULT_MESSAGE);
			entry.setStatusMessgae(resultMessage);
			if(entry.getStatus().equals(SeoulAPIConstants.ResultInfo.OK)){
				ArrayList<SubwayVO> arrivalList = new ArrayList<SubwayVO>();
				JSONArray arr = arrivalInfo.getJSONArray(SeoulAPIConstants.Subway.ROW);
				for(int i = 0 ; i < arr.length() ; i ++){
					arrivalList.add(getStation(arr.getJSONObject(i)));
				}
				entry.setArrivalList(arrivalList);
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return entry;
	}
	
	private SubwayVO getStation(JSONObject json) throws JSONException{
		
		SubwayVO vo = new SubwayVO();
		vo.setStationCode(json.getString(SeoulAPIConstants.Subway.STATION_CODE));
		vo.setSubwayName(json.getString(SeoulAPIConstants.Subway.SUBWAY_NAME));
		vo.setSubwayCode(json.getString(SeoulAPIConstants.Subway.SUBWAY_CODE));
		vo.setForiegnCode(json.getString(SeoulAPIConstants.Subway.FORIEGN_CODE));
		vo.setArrivalTime(json.getString(SeoulAPIConstants.Subway.ARRIVAL_TIME));
		vo.setLeftTime(json.getString(SeoulAPIConstants.Subway.LEFT_TIME));
		vo.setTrainCode(json.getString(SeoulAPIConstants.Subway.TRAIN_CODE));
		vo.setDestinationName(json.getString(SeoulAPIConstants.Subway.DESTSTATION_NAME));
		vo.setDestinationCode(json.getString(SeoulAPIConstants.Subway.DESTSTATION_CODE));
		return vo;
	}

}
