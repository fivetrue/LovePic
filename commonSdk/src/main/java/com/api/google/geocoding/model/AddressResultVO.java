package com.api.google.geocoding.model;

import java.util.ArrayList;

import android.os.Parcel;
import android.os.Parcelable;

import com.api.common.BaseEntry;
import com.api.google.geocoding.model.AddressComponentVO;

public class AddressResultVO extends BaseEntry {
	private String address = null;
	private String latitude = null;
	private String longitude = null;
	
	private String northeastLatitude = null;
	private String northeastLongitude = null;
	
	private String locationType = null;
	
	private String southwestLatitude = null;
	private String southwestLongitude = null;
	
	private ArrayList<String> types = new ArrayList<String>();
	private ArrayList<AddressComponentVO> addressComponents = new ArrayList<AddressComponentVO>();
	
	public AddressResultVO(){};

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the latitude
	 */
	public String getLatitude() {
		return latitude;
	}

	/**
	 * @param latitude the latitude to set
	 */
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	/**
	 * @return the longitude
	 */
	public String getLongitude() {
		return longitude;
	}

	/**
	 * @param longitude the longitude to set
	 */
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	/**
	 * @return the northeastLatitude
	 */
	public String getNortheastLatitude() {
		return northeastLatitude;
	}

	/**
	 * @param northeastLatitude the northeastLatitude to set
	 */
	public void setNortheastLatitude(String northeastLatitude) {
		this.northeastLatitude = northeastLatitude;
	}

	/**
	 * @return the northeastLongitude
	 */
	public String getNortheastLongitude() {
		return northeastLongitude;
	}

	/**
	 * @param northeastLongitude the northeastLongitude to set
	 */
	public void setNortheastLongitude(String northeastLongitude) {
		this.northeastLongitude = northeastLongitude;
	}
	
	/**
	 * @return the locationType
	 */
	public String getLocationType() {
		return locationType;
	}

	/**
	 * @param locationType the locationType to set
	 */
	public void setLocationType(String locationType) {
		this.locationType = locationType;
	}

	/**
	 * @return the southwestLatitude
	 */
	public String getSouthwestLatitude() {
		return southwestLatitude;
	}

	/**
	 * @param southwestLatitude the southwestLatitude to set
	 */
	public void setSouthwestLatitude(String southwestLatitude) {
		this.southwestLatitude = southwestLatitude;
	}

	/**
	 * @return the southwestLongitude
	 */
	public String getSouthwestLongitude() {
		return southwestLongitude;
	}

	/**
	 * @param southwestLongitude the southwestLongitude to set
	 */
	public void setSouthwestLongitude(String southwestLongitude) {
		this.southwestLongitude = southwestLongitude;
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

	/**
	 * @return the addressComponents
	 */
	public ArrayList<AddressComponentVO> getAddressComponents() {
		return addressComponents;
	}

	/**
	 * @param addressComponents the addressComponents to set
	 */
	public void setAddressComponents(ArrayList<AddressComponentVO> addressComponents) {
		this.addressComponents = addressComponents;
	}

	@Override
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		// TODO Auto-generated method stub
		
		dest.writeString(address.trim());
		dest.writeString(latitude.trim());
		dest.writeString(longitude.trim());
		dest.writeString(northeastLatitude.trim());
		dest.writeString(northeastLongitude.trim());
		dest.writeString(locationType.trim());
		dest.writeString(southwestLatitude.trim());
		dest.writeString(southwestLongitude.trim());
		dest.writeStringList(types);
		dest.writeString(status);
		dest.writeString(statusMessgae);
		dest.writeParcelableArray(addressComponents.toArray(new AddressComponentVO[addressComponents.size()]), 0);

	}
	
	public AddressResultVO(Parcel source){
		this.address = source.readString();
		this.latitude = source.readString();
		this.longitude = source.readString();
		this.northeastLatitude = source.readString();
		this.northeastLongitude = source.readString();
		this.locationType = source.readString();
		this.southwestLatitude = source.readString();
		this.southwestLongitude = source.readString();
		source.readStringList(this.types);
		this.status = source.readString();
		this.statusMessgae = source.readString();
		Parcelable[] parcelableArray =	source.readParcelableArray(AddressComponentVO[].class.getClassLoader());
		for(Parcelable data : parcelableArray){
			addressComponents.add((AddressComponentVO)data);
		}
	}

	@Override
	public Class<?> getClassInfo() {
		// TODO Auto-generated method stub
		return AddressResultVO.class;
	}
	
	public static final Parcelable.Creator<AddressResultVO> CREATOR = new Parcelable.Creator<AddressResultVO>() {
		@Override
		public AddressResultVO createFromParcel(Parcel source) {
			return new AddressResultVO(source);
		}

		@Override
		public AddressResultVO[] newArray(int size) {
			return new AddressResultVO[size];
		}
	};

	
	
}
