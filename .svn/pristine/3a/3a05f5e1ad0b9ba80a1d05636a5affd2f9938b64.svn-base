package com.api.seoul.subway.entry;

import java.util.ArrayList;

import android.os.Parcel;
import android.os.Parcelable;

import com.api.common.BaseEntry;
import com.api.seoul.subway.model.SubwayVO;

public class SubwayArrivalInfoEntry extends SubwayBaseEntry{
	
	private ArrayList<SubwayVO> arrivalList = new ArrayList<SubwayVO>();

	
	public SubwayArrivalInfoEntry(){
	}
	/**
	 * @return the arrivalList
	 */
	public ArrayList<SubwayVO> getArrivalList() {
		return arrivalList;
	}

	/**
	 * @param arrivalList the arrivalList to set
	 */
	public void setArrivalList(ArrayList<SubwayVO> arrivalList) {
		this.arrivalList = arrivalList;
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
		dest.writeParcelableArray(arrivalList.toArray(new SubwayVO[arrivalList.size()]), 0);
	}
	
	public SubwayArrivalInfoEntry(Parcel source){
		status = source.readString();
		statusMessgae = source.readString();
		Parcelable[] parcelableArray =	source.readParcelableArray(SubwayVO[].class.getClassLoader());
		for(Parcelable data : parcelableArray){
			arrivalList.add((SubwayVO)data);
		}
	}

	@Override
	public Class<?> getClassInfo() {
		// TODO Auto-generated method stub
		return SubwayArrivalInfoEntry.class;
	}
	
	public static final Parcelable.Creator<SubwayArrivalInfoEntry> CREATOR = new Parcelable.Creator<SubwayArrivalInfoEntry>() {
		@Override
		public SubwayArrivalInfoEntry createFromParcel(Parcel source) {
			return new SubwayArrivalInfoEntry(source);
		}

		@Override
		public SubwayArrivalInfoEntry[] newArray(int size) {
			return new SubwayArrivalInfoEntry[size];
		}
	};

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SubwayArrivalInfoEntry [arrivalList=" + arrivalList + "]";
	}
	
	
}
