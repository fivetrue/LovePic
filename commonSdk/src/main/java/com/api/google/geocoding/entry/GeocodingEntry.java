package com.api.google.geocoding.entry;

import java.util.ArrayList;

import android.os.Parcel;
import android.os.Parcelable;

import com.api.common.BaseEntry;
import com.api.google.geocoding.model.AddressResultVO;

public class GeocodingEntry extends BaseEntry {

	private ArrayList<AddressResultVO> addressList = new ArrayList<AddressResultVO>();
	
	public GeocodingEntry(){};

	public ArrayList<AddressResultVO> getAddressList() {
		return addressList;
	}

	public void setAddressList(ArrayList<AddressResultVO> addressList) {
		this.addressList = addressList;
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
		dest.writeParcelableArray(addressList.toArray(new AddressResultVO[addressList.size()]), 0);

	}
	
	public GeocodingEntry(Parcel source){
		this.status = source.readString();
		this.statusMessgae = source.readString();
		Parcelable[] parcelableArray =	source.readParcelableArray(AddressResultVO[].class.getClassLoader());
		for(Parcelable data : parcelableArray){
			addressList.add((AddressResultVO)data);
		}
	}

	@Override
	public Class<?> getClassInfo() {
		// TODO Auto-generated method stub
		return GeocodingEntry.class;
	}
	
	public static final Parcelable.Creator<GeocodingEntry> CREATOR = new Parcelable.Creator<GeocodingEntry>() {
		@Override
		public GeocodingEntry createFromParcel(Parcel source) {
			return new GeocodingEntry(source);
		}

		@Override
		public GeocodingEntry[] newArray(int size) {
			return new GeocodingEntry[size];
		}
	};

	
	
}
