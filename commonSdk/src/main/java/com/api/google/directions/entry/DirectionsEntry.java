package com.api.google.directions.entry;

import java.util.ArrayList;

import android.os.Parcel;
import android.os.Parcelable;

import com.api.common.BaseEntry;
import com.api.google.directions.model.RouteVO;

public class DirectionsEntry extends BaseEntry {
	
	private ArrayList<RouteVO> routeArray = new ArrayList<RouteVO>();
	
	public DirectionsEntry(){}

	/**
	 * @return the routeArray
	 */
	public ArrayList<RouteVO> getRouteArray() {
		return routeArray;
	}
	/**
	 * @param routeArray the routeArray to set
	 */
	public void setRouteArray(ArrayList<RouteVO> routeArray) {
		this.routeArray = routeArray;
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
		dest.writeParcelableArray(routeArray.toArray(new RouteVO[routeArray.size()]), 0);
	}
	
	public DirectionsEntry(Parcel source){
		this.status = source.readString();
		this.statusMessgae = source.readString();
		Parcelable[] parcelableArray =	source.readParcelableArray(RouteVO[].class.getClassLoader());
		for(Parcelable data : parcelableArray){
			routeArray.add((RouteVO)data);
		}
	}

	@Override
	public Class<?> getClassInfo() {
		// TODO Auto-generated method stub
		return DirectionsEntry.class;
	}
	
	public static final Parcelable.Creator<DirectionsEntry> CREATOR = new Parcelable.Creator<DirectionsEntry>() {
		@Override
		public DirectionsEntry createFromParcel(Parcel source) {
			return new DirectionsEntry(source);
		}

		@Override
		public DirectionsEntry[] newArray(int size) {
			return new DirectionsEntry[size];
		}
	};

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "DirectionsEntry [routeArray=" + routeArray + "]";
	}
	
	
}
