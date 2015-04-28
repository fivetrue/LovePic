package com.api.seoul.subway.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.api.common.BaseEntry;

public class StationVO extends BaseEntry{
	
	private String stationCode = null;
	private String stationName = null;
	private String lineNumber = null;
	private String foriegnCode = null;
	
	public StationVO(){
		
	}
	
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
	 * @return the stationName
	 */
	public String getStationName() {
		return stationName;
	}

	/**
	 * @param stationName the stationName to set
	 */
	public void setStationName(String stationName) {
		this.stationName = stationName;
	}

	/**
	 * @return the lineNumber
	 */
	public String getLineNumber() {
		return lineNumber;
	}

	/**
	 * @param lineNumber the lineNumber to set
	 */
	public void setLineNumber(String lineNumber) {
		this.lineNumber = lineNumber;
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

	@Override
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		// TODO Auto-generated method stub
		dest.writeString(stationCode);
		dest.writeString(stationName);
		dest.writeString(lineNumber);
		dest.writeString(foriegnCode);
	}
	
	public StationVO(Parcel source){
		stationCode = source.readString();
		stationName = source.readString();
		lineNumber = source.readString();
		foriegnCode = source.readString();
	}
	
	@Override
	public Class<?> getClassInfo() {
		// TODO Auto-generated method stub
		return StationVO.class;
	}
	
	public static final Parcelable.Creator<StationVO> CREATOR = new Parcelable.Creator<StationVO>() {
		@Override
		public StationVO createFromParcel(Parcel source) {
			return new StationVO(source);
		}

		@Override
		public StationVO[] newArray(int size) {
			return new StationVO[size];
		}
	};

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "StationVO [stationCode=" + stationCode + ", stationName="
				+ stationName + ", lineNumber=" + lineNumber + ", foriegnCode="
				+ foriegnCode + "]";
	}
	
	

}
