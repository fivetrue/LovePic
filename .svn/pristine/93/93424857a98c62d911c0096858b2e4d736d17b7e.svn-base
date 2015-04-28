package com.api.google.geocoding.converter;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.api.common.BaseResponseConverter;
import com.api.google.geocoding.GeocodingConstants;
import com.api.google.geocoding.entry.GeocodingEntry;
import com.api.google.geocoding.model.AddressComponentVO;
import com.api.google.geocoding.model.AddressResultVO;


public class GeocodingConverter implements BaseResponseConverter<GeocodingEntry> {

	@Override
	public GeocodingEntry onReceive(JSONObject json) {
		// TODO Auto-generated method stub
		GeocodingEntry entry = new GeocodingEntry();
		String status;
		try {
			status = json.getString(GeocodingConstants.STATUS);
			entry.setStatus(status);
			if(entry.getStatus().equals(GeocodingConstants.Status.OK.toString())){
				JSONArray results = json.getJSONArray(GeocodingConstants.RESULT);
				ArrayList<AddressResultVO> arrAddress = new ArrayList<AddressResultVO>();
				if(results.length() > 0){
					for(int i = 0 ; i < results.length() ; i ++){
						arrAddress.add(getAddressResult(results.getJSONObject(i)));
					}
					entry.setAddressList(arrAddress);
				}
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return entry;
	}
	
	private AddressResultVO getAddressResult(JSONObject json) throws JSONException{
		AddressResultVO result = new AddressResultVO();
		
		JSONArray componets = json.getJSONArray(GeocodingConstants.ADDRESS_CONPONENTS);
		ArrayList<AddressComponentVO> arrComponent = new ArrayList<AddressComponentVO>();
		for(int i = 0 ; i < componets.length() ; i ++){
			arrComponent.add(getAddressComponent(componets.getJSONObject(i)));
		}
		result.setAddressComponents(arrComponent);
		
		String address = json.getString(GeocodingConstants.FORMATTED_ADDRESS);
		result.setAddress(address);
		JSONObject geometry = json.getJSONObject(GeocodingConstants.GEOMETRY);
		String latitude = geometry
				.getJSONObject(GeocodingConstants.LOCATION)
				.getString(GeocodingConstants.LATITUDE);
		String longitude = geometry
				.getJSONObject(GeocodingConstants.LOCATION)
				.getString(GeocodingConstants.LONGITUDE);
		result.setLatitude(latitude);
		result.setLongitude(longitude);
		
		String locationType = geometry.getString(GeocodingConstants.LOCATION_TYPE);
		result.setLocationType(locationType);
		
		String northeastLang = geometry.getJSONObject(GeocodingConstants.VIEW_PORT)
				.getJSONObject(GeocodingConstants.NORTHEAST)
				.getString(GeocodingConstants.LATITUDE);
		String northeastLong = geometry.getJSONObject(GeocodingConstants.VIEW_PORT)
				.getJSONObject(GeocodingConstants.NORTHEAST)
				.getString(GeocodingConstants.LONGITUDE);
		result.setNortheastLatitude(northeastLang);
		result.setNortheastLongitude(northeastLong);
		
		
		String southwestLang = geometry.getJSONObject(GeocodingConstants.VIEW_PORT)
				.getJSONObject(GeocodingConstants.SOUTHWEST)
				.getString(GeocodingConstants.LATITUDE);
		String southwestLong = geometry.getJSONObject(GeocodingConstants.VIEW_PORT)
				.getJSONObject(GeocodingConstants.SOUTHWEST)
				.getString(GeocodingConstants.LONGITUDE);
		result.setSouthwestLatitude(southwestLang);
		result.setSouthwestLongitude(southwestLong);
		
		JSONArray types = json.getJSONArray(GeocodingConstants.TYPES);
		ArrayList<String> type = new ArrayList<String>();
		for(int i = 0 ; i < types.length() ; i ++){
			type.add(types.getString(i));
		}
		result.setTypes(type);
		
		return result;
	}

	private AddressComponentVO getAddressComponent(JSONObject json) throws JSONException{
		AddressComponentVO vo = new AddressComponentVO();
		String longName = json.getString(GeocodingConstants.LONG_NAME);
		vo.setLongName(longName);

		String shortName = json.getString(GeocodingConstants.SHORT_NAME);
		vo.setShortName(shortName);

		ArrayList<String> types = new ArrayList<String>();
		JSONArray type = json.getJSONArray(GeocodingConstants.TYPES);
		for(int i = 0 ; i < type.length() ; i ++){
			types.add(type.getString(i));
		}
		vo.setTypes(types);
		return vo;
	}
}
