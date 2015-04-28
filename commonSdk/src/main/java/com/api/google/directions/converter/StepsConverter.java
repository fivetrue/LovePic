package com.api.google.directions.converter;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.text.TextUtils;

import com.api.common.BaseResponseConverter;
import com.api.google.directions.DirectionsConstants;
import com.api.google.directions.model.steps.StepTransitVO;
import com.api.google.directions.model.steps.StepWalkingVO;


public class StepsConverter implements BaseResponseConverter<ArrayList<StepTransitVO>> {

	@Override
	public ArrayList<StepTransitVO> onReceive(JSONObject json) {
		// TODO Auto-generated method stub
		ArrayList<StepTransitVO> stepsList = new ArrayList<StepTransitVO>();
		try {
			JSONArray arrSteps = json.getJSONArray(DirectionsConstants.STEPS);
			
			for(int i = 0 ; i < arrSteps.length() ; i ++){
				JSONObject step = arrSteps.getJSONObject(i);
				stepsList.add(getStep(step));
			}
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return stepsList;
	}
	
	public StepTransitVO getStep(JSONObject step) throws JSONException{
		
		StepTransitVO vo = new StepTransitVO();
		String travelMode = step.getString(DirectionsConstants.TRAVEL_MODE);
		String distanceText = step.getJSONObject(DirectionsConstants.DISTANCE).getString(DirectionsConstants.TEXT);
		String distanceValue = step.getJSONObject(DirectionsConstants.DISTANCE).getString(DirectionsConstants.VALUE);
		String durationText = step.getJSONObject(DirectionsConstants.DURATION).getString(DirectionsConstants.VALUE);
		String durationValue = step.getJSONObject(DirectionsConstants.DURATION).getString(DirectionsConstants.VALUE);
		String endLocationLat = step.getJSONObject(DirectionsConstants.END_LOCATION).getString(DirectionsConstants.LONGITUDE);
		String endLocationLng = step.getJSONObject(DirectionsConstants.END_LOCATION).getString(DirectionsConstants.LATITUDE);
		String htmlInstruction = step.getString(DirectionsConstants.HTML_INSTRUCTIONS);
		String polylinePoints = step.getJSONObject(DirectionsConstants.POLYLINE).getString(DirectionsConstants.POINTS);
		String startLocationLat = step.getJSONObject(DirectionsConstants.START_LOCATION).getString(DirectionsConstants.LONGITUDE);
		String startLocationLng = step.getJSONObject(DirectionsConstants.START_LOCATION).getString(DirectionsConstants.LATITUDE);
		
		vo.setTravelMode(travelMode);
		vo.setDistanceText(distanceText);
		vo.setDistanceValue(distanceValue);
		vo.setDurationText(durationText);
		vo.setDurationValue(durationValue);
		vo.setEndLocationLatitude(endLocationLat);
		vo.setEndLocationLongitude(endLocationLng);
		vo.setHtmlInstructions(htmlInstruction);
		vo.setPolylinePoints(polylinePoints);
		vo.setStartLocationLatitude(startLocationLat);
		vo.setStartLocationLongitude(startLocationLng);
		
		if(TextUtils.isEmpty(vo.getTravelMode())){
			System.out.println("ojkwon : travelMode is null");
			return vo;
		}
		
		if(vo.getTravelMode().equals(DirectionsConstants.TravelMode.TRANSIT.toString())){
			vo.setMode(DirectionsConstants.TravelMode.TRANSIT);
			JSONObject transitDetails = step.getJSONObject(DirectionsConstants.TRANSIT_DETAILS);
			// 도착지 Parsing
			if(!step.isNull(DirectionsConstants.TRANSIT_DETAILS)){
				String arrivalStopName = transitDetails.getJSONObject(DirectionsConstants.ARRIVAL_STOP).getString(DirectionsConstants.NAME);
				String arrivalStopLat = transitDetails.getJSONObject(DirectionsConstants.ARRIVAL_STOP).getJSONObject(DirectionsConstants.LOCATION).getString(DirectionsConstants.LATITUDE);
				String arrivalStopLnt = transitDetails.getJSONObject(DirectionsConstants.ARRIVAL_STOP).getJSONObject(DirectionsConstants.LOCATION).getString(DirectionsConstants.LONGITUDE);
				String arrivalTimeText = transitDetails.getJSONObject(DirectionsConstants.ARRIVAL_TIME).getString(DirectionsConstants.TEXT);
				String arrivalTimeZone = transitDetails.getJSONObject(DirectionsConstants.ARRIVAL_TIME).getString(DirectionsConstants.TIME_ZONE);
				String arrivalTimeValue = transitDetails.getJSONObject(DirectionsConstants.ARRIVAL_TIME).getString(DirectionsConstants.VALUE);
				
				vo.setArrivalName(arrivalStopName);
				vo.setArrivalStopLatitude(arrivalStopLat);
				vo.setArrivalStopLongitude(arrivalStopLnt);
				vo.setArrivalTimeText(arrivalTimeText);
				vo.setArrivalTimeZone(arrivalTimeZone);
				vo.setArrivalTimeValue(arrivalTimeValue);
				
				// 출발지 Parsing
				String departureStopName = transitDetails.getJSONObject(DirectionsConstants.DEPARTURE_STOP).getString(DirectionsConstants.NAME);
				String departureStopLat = transitDetails.getJSONObject(DirectionsConstants.DEPARTURE_STOP).getJSONObject(DirectionsConstants.LOCATION).getString(DirectionsConstants.LATITUDE);
				String departureStopLnt = transitDetails.getJSONObject(DirectionsConstants.DEPARTURE_STOP).getJSONObject(DirectionsConstants.LOCATION).getString(DirectionsConstants.LONGITUDE);
				String departureTimeText = transitDetails.getJSONObject(DirectionsConstants.DEPARTURE_TIME).getString(DirectionsConstants.TEXT);
				String departureTimeZone = transitDetails.getJSONObject(DirectionsConstants.DEPARTURE_TIME).getString(DirectionsConstants.TIME_ZONE);
				String departureTimeValue = transitDetails.getJSONObject(DirectionsConstants.DEPARTURE_TIME).getString(DirectionsConstants.VALUE);
				vo.setDepartureStopName(departureStopName);
				vo.setDepartureStopLatitude(departureStopLat);
				vo.setDepartureStopLongitude(departureStopLnt);
				vo.setDepartureTimeText(departureTimeText);
				vo.setDepartureTimeZone(departureTimeZone);
				vo.setDepartureTimeValue(departureTimeValue);
				
				//교통 정보
				if(!transitDetails.isNull(DirectionsConstants.HEAD_SIGN)){
					String headSign = transitDetails.getString(DirectionsConstants.HEAD_SIGN);
					vo.setHeadSign(headSign);
				}
				if(!transitDetails.isNull(DirectionsConstants.HEAD_WAY)){
					String headWay  = transitDetails.getString(DirectionsConstants.HEAD_WAY);
					vo.setHeadWay(headWay);
				}
				
				if(!transitDetails.isNull(DirectionsConstants.LINE)){
					if(!transitDetails.getJSONObject(DirectionsConstants.LINE).getJSONArray(DirectionsConstants.AGENCIES).isNull(0)){
						String lineAgencyName = transitDetails.getJSONObject(DirectionsConstants.LINE).getJSONArray(DirectionsConstants.AGENCIES).getJSONObject(0).getString(DirectionsConstants.NAME);
						String lineAgencyUrl = transitDetails.getJSONObject(DirectionsConstants.LINE).getJSONArray(DirectionsConstants.AGENCIES).getJSONObject(0).getString(DirectionsConstants.URL);
						vo.setLineAgencyName(lineAgencyName);
						vo.setLineAgencyUrl(lineAgencyUrl);
					}
					
					if(!transitDetails.getJSONObject(DirectionsConstants.LINE).isNull(DirectionsConstants.COLOR)){
						String lineColor = transitDetails.getJSONObject(DirectionsConstants.LINE).getString(DirectionsConstants.COLOR);
						vo.setLineColor(lineColor);
					}
					
					if(!transitDetails.getJSONObject(DirectionsConstants.LINE).isNull(DirectionsConstants.NAME)){
						String lineName = transitDetails.getJSONObject(DirectionsConstants.LINE).getString(DirectionsConstants.NAME);
						vo.setLineName(lineName);
					}
					
					if(!transitDetails.getJSONObject(DirectionsConstants.LINE).isNull(DirectionsConstants.SHORT_NAME)){
						String lineShortName = transitDetails.getJSONObject(DirectionsConstants.LINE).getString(DirectionsConstants.SHORT_NAME);
						vo.setLineShortName(lineShortName);
					}
					
					if(!transitDetails.getJSONObject(DirectionsConstants.LINE).isNull(DirectionsConstants.TEXT_COLOR)){
						String lineTextColor = transitDetails.getJSONObject(DirectionsConstants.LINE).getString(DirectionsConstants.TEXT_COLOR);
						vo.setLineTextColor(lineTextColor);
					}
				}
				
				//교통 타입
				if(!transitDetails.isNull(DirectionsConstants.VEHICLE)){
					String vehicleIcon = transitDetails.getJSONObject(DirectionsConstants.VEHICLE).getString(DirectionsConstants.ICON);
					String vehicleName = transitDetails.getJSONObject(DirectionsConstants.VEHICLE).getString(DirectionsConstants.NAME);
					String vehicleType = transitDetails.getJSONObject(DirectionsConstants.VEHICLE).getString(DirectionsConstants.VEHICLE_TYPE);
					vo.setVehicleIcon(vehicleIcon);
					vo.setVehicleName(vehicleName);
					vo.setVehicleType(vehicleType);
					if(vo.getVehicleType().equals(DirectionsConstants.VehicleType.BUS.toString())){
						vo.setType(DirectionsConstants.VehicleType.BUS);
					}else if(vo.getVehicleType().equals(DirectionsConstants.VehicleType.SUBWAY.toString())){
						vo.setType(DirectionsConstants.VehicleType.SUBWAY);
					}
				}
				
				if(!transitDetails.isNull(DirectionsConstants.NUM_STOP)){
					String numStop = transitDetails.getString(DirectionsConstants.NUM_STOP);
					vo.setNumStop(numStop);
				}
			}
		}else if(vo.getTravelMode().equals(DirectionsConstants.TravelMode.WALKING.toString())){
			vo.setMode(DirectionsConstants.TravelMode.WALKING);
			if(!step.isNull(DirectionsConstants.STEPS)){
				JSONArray walkSteps = step.getJSONArray(DirectionsConstants.STEPS);
				if(!walkSteps.isNull(0)){
					JSONObject walkStep = walkSteps.getJSONObject(0);
					StepWalkingVO walk = new StepWalkingVO();
					String travelModeStep = walkStep.getString(DirectionsConstants.TRAVEL_MODE);
					String distanceTextStep = walkStep.getJSONObject(DirectionsConstants.DISTANCE).getString(DirectionsConstants.TEXT);
					String distanceValueStep = walkStep.getJSONObject(DirectionsConstants.DISTANCE).getString(DirectionsConstants.VALUE);
					String durationTextStep = walkStep.getJSONObject(DirectionsConstants.DURATION).getString(DirectionsConstants.VALUE);
					String durationValueStep = walkStep.getJSONObject(DirectionsConstants.DURATION).getString(DirectionsConstants.VALUE);
					String endLocationLatStep = walkStep.getJSONObject(DirectionsConstants.END_LOCATION).getString(DirectionsConstants.LONGITUDE);
					String endLocationLngStep = walkStep.getJSONObject(DirectionsConstants.END_LOCATION).getString(DirectionsConstants.LATITUDE);
					
					if(!walkStep.isNull(DirectionsConstants.HTML_INSTRUCTIONS)){
						String htmlInstructionStep = walkStep.getString(DirectionsConstants.HTML_INSTRUCTIONS);
						walk.setHtmlInstructions(htmlInstructionStep);
					}
					String polylinePointsStep = walkStep.getJSONObject(DirectionsConstants.POLYLINE).getString(DirectionsConstants.POINTS);
					String startLocationLatStep = walkStep.getJSONObject(DirectionsConstants.START_LOCATION).getString(DirectionsConstants.LONGITUDE);
					String startLocationLngStep = walkStep.getJSONObject(DirectionsConstants.START_LOCATION).getString(DirectionsConstants.LATITUDE);
					
					walk.setTravelMode(travelModeStep);
					walk.setDistanceText(distanceTextStep);
					walk.setDistanceValue(distanceValueStep);
					walk.setDurationText(durationTextStep);
					walk.setDurationValue(durationValueStep);
					walk.setEndLocationLatitude(endLocationLatStep);
					walk.setEndLocationLongitude(endLocationLngStep);

					walk.setPolylinePoints(polylinePointsStep);
					walk.setStartLocationLatitude(startLocationLatStep);
					walk.setStartLocationLongitude(startLocationLngStep);
					vo.setNextStep(walk);
				}
			}
		}
		return vo;
	}
}
