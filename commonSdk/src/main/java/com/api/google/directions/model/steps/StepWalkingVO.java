package com.api.google.directions.model.steps;


import com.api.google.model.DirectionsBaseVO;

import android.os.Parcel;
import android.os.Parcelable;


public class StepWalkingVO extends DirectionsBaseVO{
	
	private String travelMode = null;
	
	private String distanceText = null;
	private String distanceValue = null;
	
	private String durationText = null;
	private String durationValue = null;
	
	private String endLocationLatitude = null;
	private String endLocationLongitude = null;
	
	private String htmlInstructions = null;
	
	private String polylinePoints = null;
	
	private String startLocationLatitude = null;
	private String startLocationLongitude = null;
	
	private StepWalkingVO nextStep = null;
	
	public StepWalkingVO(){};
	
	public String getTravelMode() {
		return travelMode;
	}



	public void setTravelMode(String travelMode) {
		this.travelMode = travelMode;
	}



	public String getDistanceText() {
		return distanceText;
	}



	public void setDistanceText(String distanceText) {
		this.distanceText = distanceText;
	}



	public String getDistanceValue() {
		return distanceValue;
	}



	public void setDistanceValue(String distanceValue) {
		this.distanceValue = distanceValue;
	}



	public String getDurationText() {
		return durationText;
	}



	public void setDurationText(String durationText) {
		this.durationText = durationText;
	}



	public String getDurationValue() {
		return durationValue;
	}



	public void setDurationValue(String durationValue) {
		this.durationValue = durationValue;
	}



	public String getEndLocationLatitude() {
		return endLocationLatitude;
	}



	public void setEndLocationLatitude(String endLocationLatitude) {
		this.endLocationLatitude = endLocationLatitude;
	}



	public String getEndLocationLongitude() {
		return endLocationLongitude;
	}



	public void setEndLocationLongitude(String endLocationLongitude) {
		this.endLocationLongitude = endLocationLongitude;
	}



	public String getHtmlInstructions() {
		return htmlInstructions;
	}



	public void setHtmlInstructions(String htmlInstructions) {
		this.htmlInstructions = htmlInstructions;
	}



	public String getPolylinePoints() {
		return polylinePoints;
	}



	public void setPolylinePoints(String polylinePoints) {
		this.polylinePoints = polylinePoints;
	}



	public String getStartLocationLatitude() {
		return startLocationLatitude;
	}



	public void setStartLocationLatitude(String startLocationLatitude) {
		this.startLocationLatitude = startLocationLatitude;
	}



	public String getStartLocationLongitude() {
		return startLocationLongitude;
	}



	public void setStartLocationLongitude(String startLocationLongitude) {
		this.startLocationLongitude = startLocationLongitude;
	}


	/**
	 * @return the nextStep
	 */
	public StepWalkingVO getNextStep() {
		return nextStep;
	}

	/**
	 * @param nextStep the nextStep to set
	 */
	public void setNextStep(StepWalkingVO nextStep) {
		this.nextStep = nextStep;
	}



	@Override
	public String toString() {
		return "StepsBaseVO [travelMode=" + travelMode + ", distanceText="
				+ distanceText + ", distanceValue=" + distanceValue
				+ ", durationText=" + durationText + ", durationValue="
				+ durationValue + ", endLocationLatitude="
				+ endLocationLatitude + ", endLocationLongitude="
				+ endLocationLongitude + ", htmlInstructions="
				+ htmlInstructions + ", startLocationLatitude="
				+ startLocationLatitude + ", startLocationLongitude="
				+ startLocationLongitude + "]";
	}

	@Override
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public void writeToParcel(Parcel dest, int flags) {
		// TODO Auto-generated method stub
		dest.writeString(travelMode);
		dest.writeString(distanceText);
		dest.writeString(distanceValue);
		dest.writeString(durationText);
		dest.writeString(durationValue);
		dest.writeString(endLocationLatitude);
		dest.writeString(endLocationLongitude);
		dest.writeString(htmlInstructions);
		dest.writeString(polylinePoints);
		dest.writeString(startLocationLatitude);
		dest.writeString(startLocationLongitude);
		dest.writeParcelable(nextStep, 0);
	}
	
	public StepWalkingVO(Parcel source){
		
		travelMode = source.readString();
		distanceText = source.readString();
		distanceValue = source.readString();
		durationText = source.readString();
		durationValue = source.readString();
		endLocationLatitude = source.readString();
		endLocationLongitude = source.readString();
		htmlInstructions = source.readString();
		polylinePoints = source.readString();
		startLocationLatitude = source.readString();
		startLocationLongitude = source.readString();
		nextStep = (StepWalkingVO)source.readParcelable(getClassInfo().getClassLoader());
		
	}
	

	
	public static final Parcelable.Creator<StepWalkingVO> CREATOR = new Parcelable.Creator<StepWalkingVO>() {
		@Override
		public StepWalkingVO createFromParcel(Parcel source) {
			return new StepWalkingVO(source);
		}

		@Override
		public StepWalkingVO[] newArray(int size) {
			return new StepWalkingVO[size];
		}
	};

	@Override
	public Class<?> getClassInfo() {
		// TODO Auto-generated method stub
		return StepWalkingVO.class;
	}

}
