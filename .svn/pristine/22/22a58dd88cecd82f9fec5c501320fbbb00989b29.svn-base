package com.api.seoul.subway.model;

import com.api.common.BaseEntry;

import android.os.Parcel;
import android.os.Parcelable;


public class SubwayVO extends BaseEntry{
	
	
	private String stationCode = null;
	private String foriegnCode = null;
	private String subwayName = null;
	private String subwayCode = null;
	private String trainCode = null;
	private String arrivalTime = null;
	private String leftTime = null;
	private String destinationName = null;
	private String destinationCode = null;
	
	public SubwayVO(){}
	
	/**
	 * @return the stationCode
	 */
	public String getStationCode() {
		return stationCode;
	}

	/**
	 * @param stationCode the stationCode to set
	 */
	public void setStationCode(String stationCode) {
		this.stationCode = stationCode;
	}

	/**
	 * @return the foriegnCode
	 */
	public String getForiegnCode() {
		return foriegnCode;
	}

	/**
	 * @param foriegnCode the foriegnCode to set
	 */
	public void setForiegnCode(String foriegnCode) {
		this.foriegnCode = foriegnCode;
	}
	/**
	 * @return the subwayName
	 */
	public String getSubwayName() {
		return subwayName;
	}

	/**
	 * @param subwayName the subwayName to set
	 */
	public void setSubwayName(String subwayName) {
		this.subwayName = subwayName;
	}

	/**
	 * @return the subwayCode
	 */
	public String getSubwayCode() {
		return subwayCode;
	}

	/**
	 * @param subwayCode the subwayCode to set
	 */
	public void setSubwayCode(String subwayCode) {
		this.subwayCode = subwayCode;
	}

	/**
	 * @return the trainCode
	 */
	public String getTrainCode() {
		return trainCode;
	}

	/**
	 * @param trainCode the trainCode to set
	 */
	public void setTrainCode(String trainCode) {
		this.trainCode = trainCode;
	}

	/**
	 * @return the arrivalTime
	 */
	public String getArrivalTime() {
		return arrivalTime;
	}

	/**
	 * @param arrivalTime the arrivalTime to set
	 */
	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	/**
	 * @return the leftTime
	 */
	public String getLeftTime() {
		return leftTime;
	}

	/**
	 * @param leftTime the leftTime to set
	 */
	public void setLeftTime(String leftTime) {
		this.leftTime = leftTime;
	}

	/**
	 * @return the destinationName
	 */
	public String getDestinationName() {
		return destinationName;
	}

	/**
	 * @param destinationName the destinationName to set
	 */
	public void setDestinationName(String destinationName) {
		this.destinationName = destinationName;
	}

	/**
	 * @return the destinationCode
	 */
	public String getDestinationCode() {
		return destinationCode;
	}

	/**
	 * @param destinationCode the destinationCode to set
	 */
	public void setDestinationCode(String destinationCode) {
		this.destinationCode = destinationCode;
	}

	@Override
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		// TODO Auto-generated method stub
		dest.writeString(stationCode);
		dest.writeString(foriegnCode);
		dest.writeString(subwayName);
		dest.writeString(subwayCode);
		dest.writeString(trainCode);
		dest.writeString(arrivalTime);
		dest.writeString(leftTime);
		dest.writeString(destinationName);
		dest.writeString(destinationCode);
	}
	
	public SubwayVO(Parcel source){
		stationCode = source.readString();
		foriegnCode = source.readString();
		subwayName = source.readString();
		subwayCode = source.readString();
		trainCode = source.readString();
		arrivalTime = source.readString();
		leftTime = source.readString();
		destinationName = source.readString();
		destinationCode = source.readString();
	}

	@Override
	public Class<?> getClassInfo() {
		// TODO Auto-generated method stub
		return SubwayVO.class;
	}
	
	public static final Parcelable.Creator<SubwayVO> CREATOR = new Parcelable.Creator<SubwayVO>() {
		@Override
		public SubwayVO createFromParcel(Parcel source) {
			return new SubwayVO(source);
		}

		@Override
		public SubwayVO[] newArray(int size) {
			return new SubwayVO[size];
		}
	};

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SubwayVO [stationCode=" + stationCode + ", stationName="
				+ ", foriegnCode=" + foriegnCode
				+ ", subwayName=" + subwayName + ", subwayCode=" + subwayCode
				+ ", trainCode=" + trainCode + ", arrivalTime=" + arrivalTime
				+ ", leftTime=" + leftTime + ", destinationName="
				+ destinationName + ", destinationCode=" + destinationCode
				+ "]";
	}
}
