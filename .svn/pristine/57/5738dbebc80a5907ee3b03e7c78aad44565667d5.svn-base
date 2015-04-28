package com.api.google.place.converter;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.api.common.BaseResponseConverter;
import com.api.google.place.PlacesConstans;
import com.api.google.place.entry.PlacesEntry;
import com.api.google.place.model.PlaceVO;

public class PlacesConverter implements BaseResponseConverter<PlacesEntry>{
	
	@Override
	public PlacesEntry onReceive(JSONObject json) {
		// TODO Auto-generated method stub
		PlacesEntry entry = new PlacesEntry();
		
		try {
			String status = json.getString(PlacesConstans.STATUS);
			entry.setStatus(status);
			if(entry.getStatus().equals(PlacesConstans.Status.OK.toString())){
				if(!json.isNull(PlacesConstans.HTML_ATTRIBUTIONS)){
					String htmlAttr = json.getString(PlacesConstans.HTML_ATTRIBUTIONS);
					entry.setHtmlAttributions(htmlAttr);
				}
				if(!json.isNull(PlacesConstans.NEXT_PAGE_TOKEN)){
					String nextPageToken = json.getString(PlacesConstans.NEXT_PAGE_TOKEN);
					entry.setNextPageToken(nextPageToken);
				}
			
				JSONArray results = json.getJSONArray(PlacesConstans.RESULTS);
				ArrayList<PlaceVO> placeList = new ArrayList<PlaceVO>();
				
				for(int i = 0 ; i < results.length() ; i++){
					placeList.add(getPlaceResult(results.getJSONObject(i)));
				}
				entry.setPlaceList(placeList);
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return entry;
	}
	
	private PlaceVO getPlaceResult(JSONObject json) throws JSONException{
		PlaceVO vo = new PlaceVO();
		
		String latitude = json.getJSONObject(PlacesConstans.GEOMETRY).getJSONObject(PlacesConstans.LOCATION).getString(PlacesConstans.LATITUDE);
		String longitude = json.getJSONObject(PlacesConstans.GEOMETRY).getJSONObject(PlacesConstans.LOCATION).getString(PlacesConstans.LONGITUDE);
		String icon = json.getString(PlacesConstans.ICON);
		String id = json.getString(PlacesConstans.ID);
		String name = json.getString(PlacesConstans.NAME);
		String placeId = json.getString(PlacesConstans.PLACE_ID);
		String reference = json.getString(PlacesConstans.REFERENCE);
		String scope = json.getString(PlacesConstans.SCOPE);
		String vicinity = json.getString(PlacesConstans.VICINITY);

		JSONArray types = json.getJSONArray(PlacesConstans.TYPES);
		ArrayList<String> typeList = new ArrayList<String>();
		for(int i = 0 ; i < types.length() ; i++){
			typeList.add(types.getString(i));
		}
		
		vo.setLatitude(latitude);
		vo.setLongitude(longitude);
		vo.setIcon(icon);
		vo.setId(id);
		vo.setName(name);
		vo.setPlaceId(placeId);
		vo.setReference(reference);
		vo.setScope(scope);
		vo.setVicinity(vicinity);
		vo.setTypeList(typeList);
		
		return vo;
		
	}

}
