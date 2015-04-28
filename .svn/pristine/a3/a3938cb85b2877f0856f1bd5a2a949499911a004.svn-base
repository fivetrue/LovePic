package com.api.seoul.subway.converter;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.api.common.BaseResponseConverter;
import com.api.seoul.SeoulAPIConstants;
import com.api.seoul.subway.entry.SubwayInfoEntry;
import com.api.seoul.subway.model.StationVO;

public class SubwayInfoConverter implements BaseResponseConverter<SubwayInfoEntry>{

	@Override
	public SubwayInfoEntry onReceive(JSONObject json) {
		// TODO Auto-generated method stub
		SubwayInfoEntry entry = new SubwayInfoEntry();
		if(json.isNull(SeoulAPIConstants.Subway.FIND_INFO_SERVICE)){
			return entry;
		}
		
		try {
			JSONObject subwayInfo = json.getJSONObject(SeoulAPIConstants.Subway.FIND_INFO_SERVICE);
			String resultCode = subwayInfo.getJSONObject(SeoulAPIConstants.Subway.RESULT).getString(SeoulAPIConstants.Subway.RESULT_CODE);
			entry.setStatus(resultCode);
			String resultMessage = subwayInfo.getJSONObject(SeoulAPIConstants.Subway.RESULT).getString(SeoulAPIConstants.Subway.RESULT_MESSAGE);
			entry.setStatusMessgae(resultMessage);
			if(entry.getStatus().equals(SeoulAPIConstants.ResultInfo.OK)){
				ArrayList<StationVO> stationList = new ArrayList<StationVO>();
				JSONArray arr = subwayInfo.getJSONArray(SeoulAPIConstants.Subway.ROW);
				for(int i = 0 ; i < arr.length() ; i ++){
					stationList.add(getStation(arr.getJSONObject(i)));
				}
				entry.setStationList(stationList);
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return entry;
	}
	
	private StationVO getStation(JSONObject json) throws JSONException{
		StationVO vo = new StationVO();
		vo.setStationCode(json.getString(SeoulAPIConstants.Subway.STATION_CODE));
		vo.setStationName(json.getString(SeoulAPIConstants.Subway.STATION_NAME));
		vo.setLineNumber(json.getString(SeoulAPIConstants.Subway.LINE_NUMBER));
		vo.setForiegnCode(json.getString(SeoulAPIConstants.Subway.FORIEGN_CODE));
		return vo;
	}

}
