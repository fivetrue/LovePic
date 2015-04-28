package com.api.google.place.entry;


import java.util.ArrayList;

import android.os.Parcel;
import android.os.Parcelable;

import com.api.common.BaseEntry;
import com.api.google.place.model.PlaceVO;

public class PlacesEntry extends BaseEntry {

	String htmlAttributions = null;
	String nextPageToken = null;
	String Status = null;
	ArrayList<PlaceVO> placeList = new ArrayList<PlaceVO>();
	
	public PlacesEntry(){
		
	}
	
	public String getHtmlAttributions() {
		return htmlAttributions;
	}

	public void setHtmlAttributions(String htmlAttributions) {
		this.htmlAttributions = htmlAttributions;
	}

	public String getNextPageToken() {
		return nextPageToken;
	}

	public void setNextPageToken(String nextPageToken) {
		this.nextPageToken = nextPageToken;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	public ArrayList<PlaceVO> getPlaceList() {
		return placeList;
	}

	public void setPlaceList(ArrayList<PlaceVO> placeList) {
		this.placeList = placeList;
	}

	@Override
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		// TODO Auto-generated method stub
		dest.writeString(htmlAttributions);
		dest.writeString(nextPageToken);
		dest.writeString(Status);
		dest.writeString(status);
		dest.writeString(statusMessgae);
		dest.writeParcelableArray(placeList.toArray(new PlaceVO[placeList.size()]), 0);
	}
	
	public PlacesEntry(Parcel source){
		htmlAttributions = source.readString();
		nextPageToken = source.readString();
		Status = source.readString();
		status = source.readString();
		statusMessgae = source.readString();
		Parcelable[] parcelableArray =	source.readParcelableArray(PlaceVO[].class.getClassLoader());
		for(Parcelable data : parcelableArray){
			placeList.add((PlaceVO)data);
		}
		
	}

	@Override
	public Class<?> getClassInfo() {
		// TODO Auto-generated method stub
		return PlacesEntry.class;
	}
	
	public static final Parcelable.Creator<PlacesEntry> CREATOR = new Parcelable.Creator<PlacesEntry>() {
		@Override
		public PlacesEntry createFromParcel(Parcel source) {
			return new PlacesEntry(source);
		}

		@Override
		public PlacesEntry[] newArray(int size) {
			return new PlacesEntry[size];
		}
	};
}
