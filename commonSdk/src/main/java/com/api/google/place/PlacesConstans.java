package com.api.google.place;

public class PlacesConstans{ 
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
	
	//https://developers.google.com/places/documentation/search#PlaceSearchStatusCodes
	static public enum Status{
		OK, //는 응답에 유효한 result가 있음을 나타냅니다.
		ZERO_RESULTS,
		OVER_QUERY_LIMIT,
		REQUEST_DENIED,
		INVALID_REQUEST,
	}
	
	static public enum FilterType{
		accounting,
		airport,
		amusement_park,
		aquarium,
		art_gallery,
		atm,
		bakery,
		bank,
		bar,
		beauty_salon,
		bicycle_store,
		book_store,
		bowling_alley,
		bus_station,
		cafe,
		campground,
		car_dealer,
		car_rental,
		car_repair,
		car_wash,
		cemetery,
		church,
		city_hall,
		clothing_store,
		convenience_store,
		courthouse,
		dentist,
		department_store,
		doctor,
		electrician,
		electronics_store,
		embassy,
		establishment,
		finance,
		fire_station,
		florist,
		food,
		funeral_home,
		furniture_store,
		gas_station,
		general_contractor,
		grocery_or_supermarket,
		gym,
		hair_care,
		hardware_store,
		health,
		hindu_temple,
		home_goods_store,
		hospital,
		insurance_agency,
		jewelry_store,
		laundry,
		lawyer,
		library,
		liquor_store,
		local_government_office,
		locksmith,
		lodging,
		meal_delivery,
		meal_takeaway,
		mosque,
		movie_rental,
		movie_theater,
		moving_company,
		museum,
		night_club,
		painter,
		park,
		parking,
		pet_store,
		pharmacy,
		physiotherapist,
		place_of_worship,
		plumber,
		police,
		post_office,
		real_estate_agency,
		restaurant,
		roofing_contractor,
		rv_park,
		school,
		shoe_store,
		shopping_mall,
		spa,
		stadium,
		storage,
		store,
		subway_station,
		synagogue,
		taxi_stand,
		train_station,
		travel_agency,
		university,
		veterinary_care,
		zoo
	};
	
	static public enum NonFilterType{
		administrative_area_level_1,
		administrative_area_level_2,
		administrative_area_level_3,
		colloquial_area,
		country,
		floor,
		geocode,
		intersection,
		locality,
		natural_feature,
		neighborhood,
		political,
		point_of_interest,
		post_box,
		postal_code,
		postal_code_prefix,
		postal_town,
		premise,
		room,
		route,
		street_address,
		street_number,
		sublocality,
		sublocality_level_4,
		sublocality_level_5,
		sublocality_level_3,
		sublocality_level_2,
		sublocality_level_1,
		subpremise,
		transit_station
	}

	static public String HTML_ATTRIBUTIONS = "html_attributions";
	static public String NEXT_PAGE_TOKEN = "next_page_token";
	static public String RESULTS = "results";
	static public String RESULT = "result";
	static public String STATUS = "status";
	static public String GEOMETRY = "geometry"; 
	static public String LOCATION = "location";
	static public String LATITUDE = "lat";
	static public String LONGITUDE = "lng";
	static public String ICON = "icon";
	static public String ID = "id";
	static public String NAME = "name";
	static public String PLACE_ID = "place_id";
	static public String REFERENCE = "reference";
	static public String SCOPE = "scope";
	static public String TYPES = "types";
	static public String VICINITY = "vicinity";
	
	//Place Detail Parameter
	static public String ADR_ADDRESS = "adr_address";
	static public String FORMATTED_ADDRESS = "formatted_address";
	static public String URL = "url";
	static public String USER_RATINGS_TOTAL = "user_ratings_total";
	static public String UTC_OFFSET = "utc_offset";
	static public String WEBSITE = "website";
	
	static public String REVIEWS = "reviews";
	static public String PHONE_NUMBER = "international_phone_number";
	static public String ASPECTS = "aspects";
	static public String RATING = "rating";
	static public String TYPE = "type";
	static public String AUTHOR_NAME = "author_name";
	static public String LANGUAGE = "language";
	static public String TEXT = "text";
	static public String TIME = "time";
}
