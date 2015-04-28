package com.api.google.place.converter;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.api.common.BaseResponseConverter;
import com.api.google.geocoding.GeocodingConstants;
import com.api.google.geocoding.model.AddressComponentVO;
import com.api.google.place.PlacesConstans;
import com.api.google.place.entry.PlacesDetailEntry;
import com.api.google.place.model.PlaceVO;
import com.api.google.place.model.ReviewsVO;

public class PlacesDetailConverter implements BaseResponseConverter<PlacesDetailEntry>{
	
	@Override
	public PlacesDetailEntry onReceive(JSONObject json) {
		// TODO Auto-generated method stub
		PlacesDetailEntry entry = new PlacesDetailEntry();
		
		try {
			String status = json.getString(PlacesConstans.STATUS);
			entry.setStatus(status);
			if(entry.getStatus().equals(PlacesConstans.Status.OK.toString())){
				if(!json.isNull(PlacesConstans.HTML_ATTRIBUTIONS)){
					String htmlAttr = json.getString(PlacesConstans.HTML_ATTRIBUTIONS);
					entry.setHtmlAttributions(htmlAttr);
				}

				JSONObject results = json.getJSONObject(PlacesConstans.RESULT);
				
				ArrayList<AddressComponentVO> addressComponents = new ArrayList<AddressComponentVO>();
				
				if(!results.isNull(GeocodingConstants.ADDRESS_CONPONENTS)){
					JSONArray addressList = results.getJSONArray(GeocodingConstants.ADDRESS_CONPONENTS);
					for(int i = 0 ; i < addressList.length() ; i++){
						addressComponents.add(getAddressComponent(addressList.getJSONObject(i)));
					}
					entry.setAddressComponents(addressComponents);
				}

				ArrayList<PlaceVO> placeList = new ArrayList<PlaceVO>();
				placeList.add(getPlaceResult(results));
				entry.setPlaceList(placeList);
				
				if(!results.isNull(PlacesConstans.REVIEWS)){
					ArrayList<ReviewsVO> reviewList = new ArrayList<ReviewsVO>();
					JSONArray arrReview = results.getJSONArray(PlacesConstans.REVIEWS);
					for(int i = 0 ; i < arrReview.length() ; i ++){
						reviewList.add(getReview(arrReview.getJSONObject(i)));
					}
					entry.setReviews(reviewList);
				}
				
				if(!results.isNull(PlacesConstans.PHONE_NUMBER)){
					entry.setInternationalPhoneNumber(results.getString(PlacesConstans.PHONE_NUMBER));
				}
				
				if(!results.isNull(PlacesConstans.ADR_ADDRESS)){
					entry.setAdrAddress(results.getString(PlacesConstans.ADR_ADDRESS));
				}
				
				if(!results.isNull(PlacesConstans.FORMATTED_ADDRESS)){
					entry.setFormattedAddress(results.getString(PlacesConstans.FORMATTED_ADDRESS));
				}
				
				if(!results.isNull(PlacesConstans.URL)){
					entry.setPlaceUrl(results.getString(PlacesConstans.URL));
				}
				
				if(!results.isNull(PlacesConstans.USER_RATINGS_TOTAL)){
					entry.setUserRatingTotal(results.getString(PlacesConstans.USER_RATINGS_TOTAL));
				}
				
				if(!results.isNull(PlacesConstans.UTC_OFFSET)){
					entry.setUtcOffset(results.getString(PlacesConstans.UTC_OFFSET));
				}
				
				if(!results.isNull(PlacesConstans.WEBSITE)){
					entry.setWebsite(results.getString(PlacesConstans.WEBSITE));
				}
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
	
	private ReviewsVO getReview(JSONObject json) throws JSONException{
		ReviewsVO vo = new ReviewsVO();
		
		if(json.isNull(PlacesConstans.ASPECTS)){
			vo.setAspectRating(json.getJSONArray(PlacesConstans.ASPECTS).getJSONObject(0).getString(PlacesConstans.RATING));
			vo.setAspectRating(json.getJSONArray(PlacesConstans.ASPECTS).getJSONObject(0).getString(PlacesConstans.TYPE));
			
			vo.setAuthorName(json.getString(PlacesConstans.AUTHOR_NAME));
			vo.setLanguage(json.getString(PlacesConstans.LANGUAGE));
			vo.setRating(json.getString(PlacesConstans.RATING));
			vo.setText(json.getString(PlacesConstans.TEXT));
			vo.setTime(json.getString(PlacesConstans.TIME));
		}
		return vo;
	}

}
