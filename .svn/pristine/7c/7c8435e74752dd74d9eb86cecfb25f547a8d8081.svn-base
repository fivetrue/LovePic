package com.api.google.geocoding;

public class GeocodingConstants {
	
	static public enum Types{
		street_address, //는 정확한 번지수를 나타냅니다.
		route, //는 이름이 지정된 경로(예: 'US 101')를 나타냅니다.
		intersection, //은 일반적으로 두 주요 도로의 주요 교차로를 나타냅니다.
		political, //은 정치적 구역을 나타냅니다. 일반적으로 이 유형은 몇몇 도시 행정구역의 폴리곤을 나타냅니다.
		country, //는 국가 정치적 구역을 나타내고 일반적으로 지오코더에 의해 반환되는 최상위 유형입니다.
		administrative_area_level_1, //은 국가 수준 아래 첫 번째 도시 구역을 나타냅니다. 미국 내에서 이러한 행정구역 수준은 주입니다. 모든 국가가 이러한 행정구역 수준을 나타내지는 않습니다.
		administrative_area_level_2, //는 국가 수준 아래 두 번째 도시 구역을 나타냅니다. 미국 내에서 이러한 행정구역 수준은 카운티입니다. 모든 국가가 이러한 행정구역 수준을 나타내지는 않습니다.
		administrative_area_level_3, //은 국가 수준 아래 세 번째 도시 구역을 나타냅니다. 이 유형은 작은 도시 구획을 나타냅니다. 모든 국가가 이러한 행정구역 수준을 나타내지는 않습니다.
		colloquial_area, //는 구역에 일반적으로 사용되는 대체 이름을 나타냅니다.
		locality, //는 편입된 시/군/구의 정치적 구역을 나타냅니다.
		sublocality, //는 locality 아래 첫 번째 도시 구역 나타냅니다.
		neighborhood, //는 이름이 지정된 인근 지역을 나타냅니다.
		premise, //는 이름이 지정된 위치, 일반적으로 공통 이름을 가진 건물 또는 여러 건물을 나타냅니다.
		subpremise, //는 이름이 지정된 위치 아래 첫 번째 구역, 일반적으로 공통 이름을 가진 여러 건물 중 하나를 나타냅니다.
		postal_code, //는 국가 내에서 우편을 보낼 때 주소로 사용되는 우편번호를 나타냅니다.
		natural_feature, //는 주요 자연지물을 나타냅니다.
		airport, //는 공항을 나타냅니다.
		park, //는 이름이 지정된 공원을 나타냅니다.
		point_of_interest, //는 이름이 지정된 관심 장소를 나타냅니다. 일반적으로 'POI'는 '엠파이어 스테이트 빌딩'이나 '자유의 여신상' 같이 다른 카테고리에 쉽게 넣을 수 없는 유명한 장소입니다.
	}
	
	static public enum Status{
		OK, // 는 일반적으로 쿼리(address 또는 latlng)가 누락되었음을 나타냅니다.
		ZERO_RESULTS, //  는 지오코딩이 성공했지만 반환된 결과가 없음을 나타냅니다. 이는 지오코딩이 존재하지 않는 address 또는 원격 지역의 latlng을 전달받는 경우 발생할 수 있습니다.
		OVER_QUERY_LIMIT, // 는 할당량을 초과되었음을 나타냅니다.
		REQUEST_DENIED, // 는 요청이 거부되었음을 나타내며 대부분의 경우 sensor 매개변수가 없기 때문입니다.
		INVALID_REQUEST //는  일반적으로 쿼리(address 또는 latlng)가 누락되었음을 나타냅니다.
	}
	
	static public final String RESULT = "results";
	static public final String ADDRESS_CONPONENTS = "address_components";
	static public final String LONG_NAME = "long_name";
	static public final String SHORT_NAME = "short_name";
	static public final String TYPES = "types";
	
	static public final String FORMATTED_ADDRESS = "formatted_address";
	static public final String LOCATION = "location";
	static public final String GEOMETRY = "geometry";
	static public final String LATITUDE = "lat";
	static public final String LONGITUDE = "lng";
	
	
	static public final String LOCATION_TYPE = "location_type";
	static public final String VIEW_PORT = "viewport";
	
	static public final String NORTHEAST = "northeast";
	static public final String SOUTHWEST = "southwest";
	static public final String COPY_RIGHTS = "copyrights";
	static public final String STATUS = "status";
}
