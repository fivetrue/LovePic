package com.api.google.place.model;



import com.api.common.BaseEntry;

import android.os.Parcel;
import android.os.Parcelable;


public class ReviewsVO extends BaseEntry{

	private String aspectRating = null;
	private String aspectType = null;
	
	private String authorName = null;
	private String language = null;
	private String rating = null;
	private String text = null;
	private String time = null;
	
	
	public String getAspectRating() {
		return aspectRating;
	}


	public void setAspectRating(String aspectRating) {
		this.aspectRating = aspectRating;
	}


	public String getAspectType() {
		return aspectType;
	}


	public void setAspectType(String aspectType) {
		this.aspectType = aspectType;
	}


	public String getAuthorName() {
		return authorName;
	}


	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}


	public String getLanguage() {
		return language;
	}


	public void setLanguage(String language) {
		this.language = language;
	}


	public String getRating() {
		return rating;
	}


	public void setRating(String rating) {
		this.rating = rating;
	}


	public String getText() {
		return text;
	}


	public void setText(String text) {
		this.text = text;
	}


	public String getTime() {
		return time;
	}


	public void setTime(String time) {
		this.time = time;
	}


	public ReviewsVO() {}


	@Override
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		// TODO Auto-generated method stub
		dest.writeString(aspectRating);
		dest.writeString(aspectType);
		dest.writeString(authorName);
		dest.writeString(language);
		dest.writeString(rating);
		dest.writeString(text);
		dest.writeString(time);
	}
	
	public ReviewsVO(Parcel source) {
		aspectRating = source.readString();
		aspectType = source.readString();
		authorName = source.readString();
		language = source.readString();
		rating = source.readString();
		text = source.readString();
		time = source.readString();
	}

	@Override
	public Class<?> getClassInfo() {
		// TODO Auto-generated method stub
		return ReviewsVO.class;
	}
	
	public static final Parcelable.Creator<ReviewsVO> CREATOR = new Parcelable.Creator<ReviewsVO>() {
		@Override
		public ReviewsVO createFromParcel(Parcel source) {
			return new ReviewsVO(source);
		}

		@Override
		public ReviewsVO[] newArray(int size) {
			return new ReviewsVO[size];
		}
	};

}
