package com.api.google.place.entry;


import java.util.ArrayList;

import com.api.google.geocoding.model.AddressComponentVO;
import com.api.google.place.model.PlaceVO;
import com.api.google.place.model.ReviewsVO;

import android.os.Parcel;
import android.os.Parcelable;


public class PlacesDetailEntry extends PlacesEntry {

	private ArrayList<AddressComponentVO> addressComponents = new ArrayList<AddressComponentVO>();
	private String adrAddress = null;
	private String formattedAddress = null;
	private String placeUrl = null;
	private String userRatingTotal = null;
	private String utcOffset = null;
	private String website = null;
	private String internationalPhoneNumber = null;
	private ArrayList<ReviewsVO> reviews = new ArrayList<ReviewsVO>();
	
	
	public PlacesDetailEntry(){
		
	}

	public ArrayList<AddressComponentVO> getAddressComponents() {
		return addressComponents;
	}

	public void setAddressComponents(ArrayList<AddressComponentVO> addressComponents) {
		this.addressComponents = addressComponents;
	}

	public String getAdrAddress() {
		return adrAddress;
	}

	public void setAdrAddress(String adrAddress) {
		this.adrAddress = adrAddress;
	}

	public String getFormattedAddress() {
		return formattedAddress;
	}

	public void setFormattedAddress(String formattedAddress) {
		this.formattedAddress = formattedAddress;
	}

	public String getPlaceUrl() {
		return placeUrl;
	}

	public void setPlaceUrl(String placeUrl) {
		this.placeUrl = placeUrl;
	}

	public String getUserRatingTotal() {
		return userRatingTotal;
	}

	public void setUserRatingTotal(String userRatingTotal) {
		this.userRatingTotal = userRatingTotal;
	}

	public String getUtcOffset() {
		return utcOffset;
	}

	public void setUtcOffset(String utcOffset) {
		this.utcOffset = utcOffset;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public ArrayList<ReviewsVO> getReviews() {
		return reviews;
	}

	public void setReviews(ArrayList<ReviewsVO> reviews) {
		this.reviews = reviews;
	}
	
	public String getInternationalPhoneNumber() {
		return internationalPhoneNumber;
	}

	public void setInternationalPhoneNumber(String internationalPhoneNumber) {
		this.internationalPhoneNumber = internationalPhoneNumber;
	}

	@Override
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		// TODO Auto-generated method stub
		super.writeToParcel(dest, flags);
		dest.writeParcelableArray(addressComponents.toArray(new AddressComponentVO[addressComponents.size()]), 0);
		dest.writeString(adrAddress);
		dest.writeString(formattedAddress);
		dest.writeString(placeUrl);
		dest.writeString(userRatingTotal);
		dest.writeString(utcOffset);
		dest.writeString(website);
		dest.writeString(utcOffset);
		dest.writeParcelableArray(reviews.toArray(new ReviewsVO[reviews.size()]), 0);
	}
	
	public PlacesDetailEntry(Parcel source){
		super(source);
		Parcelable[] parcelableArray =	source.readParcelableArray(AddressComponentVO[].class.getClassLoader());
		for(Parcelable data : parcelableArray){
			addressComponents.add((AddressComponentVO)data);
		}
		adrAddress = source.readString();
		formattedAddress = source.readString();
		placeUrl = source.readString();
		userRatingTotal = source.readString();
		utcOffset = source.readString();
		website = source.readString();
		utcOffset = source.readString();
		Parcelable[] parcelableArray2 =	source.readParcelableArray(ReviewsVO[].class.getClassLoader());
		for(Parcelable data : parcelableArray2){
			reviews.add((ReviewsVO)data);
		}
	}

	@Override
	public Class<?> getClassInfo() {
		// TODO Auto-generated method stub
		return PlacesDetailEntry.class;
	}
	
	public static final Parcelable.Creator<PlacesDetailEntry> CREATOR = new Parcelable.Creator<PlacesDetailEntry>() {
		@Override
		public PlacesDetailEntry createFromParcel(Parcel source) {
			return new PlacesDetailEntry(source);
		}

		@Override
		public PlacesDetailEntry[] newArray(int size) {
			return new PlacesDetailEntry[size];
		}
	};


	@Override
	public String toString() {
		return "PlacesDetailEntry [addressComponents=" + addressComponents
				+ ", adrAddress=" + adrAddress + ", formattedAddress="
				+ formattedAddress + ", placeUrl=" + placeUrl
				+ ", userRatingTotal=" + userRatingTotal + ", utcOffset="
				+ utcOffset + ", website=" + website + ", reviews=" + reviews
				+ "]";
	}
	
	
}
