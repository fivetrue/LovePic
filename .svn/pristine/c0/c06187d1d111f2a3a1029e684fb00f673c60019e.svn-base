package com.api.google.geocoding.model;

import java.util.ArrayList;

import com.api.common.BaseEntry;

import android.os.Parcel;
import android.os.Parcelable;

public class AddressComponentVO extends BaseEntry {
	private String longName = null;
	private String shortName = null;
	private ArrayList<String> types = new ArrayList<String>();
	
	
	public AddressComponentVO(){};
	/**
	 * @return the longName
	 */
	public String getLongName() {
		return longName;
	}

	/**
	 * @param longName the longName to set
	 */
	public void setLongName(String longName) {
		this.longName = longName;
	}

	/**
	 * @return the shortName
	 */
	public String getShortName() {
		return shortName;
	}

	/**
	 * @param shortName the shortName to set
	 */
	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	/**
	 * @return the types
	 */
	public ArrayList<String> getTypes() {
		return types;
	}

	/**
	 * @param types the types to set
	 */
	public void setTypes(ArrayList<String> types) {
		this.types = types;
	}

	@Override
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		// TODO Auto-generated method stub
		dest.writeString(longName);
		dest.writeString(shortName);
		dest.writeStringList(types);
	}

	public AddressComponentVO(Parcel source){
		this.longName = source.readString();
		this.shortName = source.readString();
		source.readStringList(this.types);
	}

	@Override
	public Class<?> getClassInfo() {
		// TODO Auto-generated method stub
		return AddressComponentVO.class;
	}
	
	public static final Parcelable.Creator<AddressComponentVO> CREATOR = new Parcelable.Creator<AddressComponentVO>() {
		@Override
		public AddressComponentVO createFromParcel(Parcel source) {
			return new AddressComponentVO(source);
		}

		@Override
		public AddressComponentVO[] newArray(int size) {
			return new AddressComponentVO[size];
		}
	};

}
