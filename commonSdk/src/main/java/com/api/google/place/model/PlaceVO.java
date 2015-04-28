package com.api.google.place.model;


import java.util.ArrayList;

import com.api.common.BaseEntry;

import android.os.Parcel;
import android.os.Parcelable;


public class PlaceVO extends BaseEntry{
	/*
	 "html_attributions": [],
	"next_page_token": "CoQC_AAAAPVUsfFZRC7mQ-oeFZQxXWy0YoBtMuG1KLV00gV-zXrZHGWCdmJevJnwonvXHPgXXSeCviWOIztDC7Ez6DWOQV0JmtrdYQJaitaI-3Ij1jhW5k6gRH5UblheaJLi4Sm0gE9hcBT-Pna23KvMwfEVSgiH5D92G88WfU0REGAPR5o768XWzOpzBuDvU5UplhQgRrS3y2OVY3_R1XjR_QYznvas4XXms8-uoROYjDE9V5e_8c7HYgeWyq-UWB-XuiAkT2Pl7ZPb2b3zLkkcPK6S8_bCYf9YUu0AWaD26uTdQnRpltbOO-blLIqb8NnO7ZpLF8ajhOgMvAXpRErgk6PUAXoSEDTSSin9MinH-eWooDlsrSYaFITZZFSX_MeMXXDGIb9EMR_A7qYU",
	"results": [],
	"status": "OK"
	 "geometry": {
		"location": {
		"lat": 37.556707,
		"lng": 126.923933
		}
		},
		"icon": "http://maps.gstatic.com/mapfiles/place_api/icons/generic_business-71.png",
		"id": "a54e8ad7fa5dd917d6447260083ce1c47378e394",
		"name": "ȫ���Ա�",
		"place_id": "ChIJJ2B1FcOYfDURMpTFcDu-SfQ",
		"reference": "CnRuAAAAZurjg6beXynR0eBIVyJUkzR1CyqdD_wzW9TJK3dyyy3rWPkHnAcMcKwwa-09BSitpvffPw0ZQHxpzIatVTORNYyTaw4D4F29mBzjQm5uVV51QqV4WV7thSxOo17naN9S5wR5AnSeMdzUuV3lJ-HgYRIQ-y--ml3gMZzeiOA74oaF6BoUmMgAjZxvpBxavQ53yV6GKPZCCJk",
		"scope": "GOOGLE",
		"types": [
		"subway_station",
		"transit_station",
		"train_station",
		"establishment"
		],
		"vicinity": "������ ������ 165"{
	 */

	private String Results = null;	
	private String latitude = null;
	private String longitude = null;
	private String Icon = null;
	private String Id = null;
	private String Name = null;
	private String PlaceId = null;
	private String Reference = null;
	private String Scope = null;
	private ArrayList<String> typeList = new ArrayList<String>();
	private String Vicinity = null;
	
	
	public PlaceVO() {}

	public String getResults() {
		return Results;
	}

	public void setResults(String results) {
		Results = results;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getIcon() {
		return Icon;
	}

	public void setIcon(String icon) {
		Icon = icon;
	}

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getPlaceId() {
		return PlaceId;
	}

	public void setPlaceId(String placeId) {
		PlaceId = placeId;
	}

	public String getReference() {
		return Reference;
	}

	public void setReference(String reference) {
		Reference = reference;
	}

	public String getScope() {
		return Scope;
	}

	public void setScope(String scope) {
		Scope = scope;
	}

	public ArrayList<String> getTypeList() {
		return typeList;
	}

	public void setTypeList(ArrayList<String> typeList) {
		this.typeList = typeList;
	}

	public String getVicinity() {
		return Vicinity;
	}

	public void setVicinity(String vicinity) {
		Vicinity = vicinity;
	}

	@Override
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		// TODO Auto-generated method stub

		dest.writeString(Results);
		dest.writeString(latitude);
		dest.writeString(longitude);
		dest.writeString(Icon);
		dest.writeString(Id);
		dest.writeString(Name);
		dest.writeString(PlaceId);
		dest.writeString(Reference);
		dest.writeString(Scope);
		dest.writeStringList(typeList);
		dest.writeString(Vicinity);
	}
	
	public PlaceVO(Parcel source) {
		Results = source.readString();
		latitude = source.readString();
		longitude = source.readString();
		Icon = source.readString();
		Id = source.readString();
		Name = source.readString();
		PlaceId = source.readString();
		Reference = source.readString();
		Scope = source.readString();
		source.readStringList(typeList);
		Vicinity = source.readString();
	}

	@Override
	public Class<?> getClassInfo() {
		// TODO Auto-generated method stub
		return PlaceVO.class;
	}
	
	public static final Parcelable.Creator<PlaceVO> CREATOR = new Parcelable.Creator<PlaceVO>() {
		@Override
		public PlaceVO createFromParcel(Parcel source) {
			return new PlaceVO(source);
		}

		@Override
		public PlaceVO[] newArray(int size) {
			return new PlaceVO[size];
		}
	};

}
