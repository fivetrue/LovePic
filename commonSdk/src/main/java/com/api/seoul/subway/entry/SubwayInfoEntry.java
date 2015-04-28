package com.api.seoul.subway.entry;

import java.util.ArrayList;

import android.os.Parcel;
import android.os.Parcelable;

import com.api.common.BaseEntry;
import com.api.seoul.subway.model.StationVO;

public class SubwayInfoEntry extends SubwayBaseEntry{
	
	private ArrayList<StationVO> stationList = new ArrayList<StationVO>();

	/**
	 * @return the stationList
	 */
	
	public SubwayInfoEntry(){
	}
	
	public ArrayList<StationVO> getStationList() {
		return stationList;
	}

	/**
	 * @param stationList the stationList to set
	 */
	public void setStationList(ArrayList<StationVO> stationList) {
		this.stationList = stationList;
	}

	@Override
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		// TODO Auto-generated method stub
		dest.writeString(status);
		dest.writeString(statusMessgae);
		dest.writeParcelableArray(stationList.toArray(new StationVO[stationList.size()]), 0);
		
	}
	
	public SubwayInfoEntry(Parcel source){
		status = source.readString();
		statusMessgae = source.readString();
		Parcelable[] parcelableArray =	source.readParcelableArray(StationVO[].class.getClassLoader());
		for(Parcelable data : parcelableArray){
			stationList.add((StationVO)data);
		}
	}

	@Override
	public Class<?> getClassInfo() {
		// TODO Auto-generated method stub
		return SubwayInfoEntry.class;
	}
	
	public static final Parcelable.Creator<SubwayInfoEntry> CREATOR = new Parcelable.Creator<SubwayInfoEntry>() {
		@Override
		public SubwayInfoEntry createFromParcel(Parcel source) {
			return new SubwayInfoEntry(source);
		}

		@Override
		public SubwayInfoEntry[] newArray(int size) {
			return new SubwayInfoEntry[size];
		}
	};

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SubwayInfoEntry [stationList=" + stationList + "]";
	}
	
	

}
