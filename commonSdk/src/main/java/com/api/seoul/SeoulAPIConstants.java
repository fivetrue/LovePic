package com.api.seoul;

public class SeoulAPIConstants {

	static public String USER_ID = "fivetrue";
	static public String AUTH_KEY = "4c5665687566697632314557724f55";
	static public String TYPE_JSON = "json";

	static public String API_HOST = "http://openAPI.seoul.go.kr:8088/";

	/**
	 * @author Administrator
	 * 서울 지하철 공공 API 의 파라메터 순은 Authkey / type / serviceName /startIndex / endIndex / 이후 정보로 URL에 넣는다
	 */

	/*static public enum RESSULT_INFO{
		INFO-000,// : 정상 처리되었습니다
		ERROR-300,// : 필수 값이 누락되어 있습니다.요청인자를 참고 하십시오.
		INFO-100,// : 인증키가 유효하지 않습니다.	인증키가 없는 경우, 열린 데이터 광장 홈페이지에서 인증키를 신청하십시오.
		ERROR-301,// : 파일타입 값이 누락 혹은 유효하지 않습니다.	요청인자 중 TYPE을 확인하십시오.
		ERROR-310,// : 해당하는 서비스를 찾을 수 없습니다.	요청인자 중 SERVICE를 확인하십시오.
		ERROR-331,// : 요청시작위치 값을 확인하십시오.	요청인자 중 START_INDEX를 확인하십시오.
		ERROR-332,// : 요청종료위치 값을 확인하십시오.	요청인자 중 END_INDEX를 확인하십시오.
		ERROR-333,// : 요청위치 값의 타입이 유효하지 않습니다.	요청위치 값은 정수를 입력하세요.
		ERROR-334,// : 요청종료위치 보다 요청시작위치가 더 큽니다.	요청시작조회건수는 정수를 입력하세요.
		ERROR-335,// : 샘플데이터(샘플키:sample) 는 한번에 최대 5건을 넘을 수 없습니다.	요청시작위치와 요청종료위치 값은 1 ~ 5 사이만 가능합니다.
		ERROR-336,// : 데이터요청은 한번에 최대 1000건을 넘을 수 없습니다.요청종료위치에서 요청시작위치를 뺀 값이 1000을 넘지 않도록 수정하세요.
		ERROR-500,// : 서버 오류입니다.	지속적으로 발생시 열린 데이터 광장으로 문의(Q&A) 바랍니다.
		ERROR-600,// : 데이터베이스 연결 오류입니다.지속적으로 발생시 열린 데이터 광장으로 문의(Q&A) 바랍니다.
		ERROR-601,// : SQL 문장 오류 입니다.지속적으로 발생시 열린 데이터 광장으로 문의(Q&A) 바랍니다.
		INFO-200,// : 해당하는 데이터가 없습니다
	}*/
	
	//1~9: 1~9호선, I: 인천1호선, K: 경의선, B: 분당선, J: 중앙선, A: 공항철도, G: 경춘선, S:신분당선, SU:수인선
	
	static public class LineInfo{
		
	}
	
	static public class ResultInfo{
		static public String OK = "INFO-000";
		static public String NO_DATA = "INFO-200";
		static public String INVALID_KEY = "INFO-100";
		static public String CHECK_PARAM = "ERROR-300";
	}
	
	static public class Subway{
		static public String START_INDEX = "1"; 
		static public String END_INDEX = "5";

		static public String RESULT = "RESULT";
		static public String RESULT_CODE = "CODE";
		static public String RESULT_MESSAGE = "MESSAGE";
		static public String ROW = "row";
		static public String STATION_CODE = "STATION_CD";
		static public String STATION_NAME = "STATION_NM";
		static public String LINE_NUMBER = "LINE_NUM";
		static public String FORIEGN_CODE = "FR_CODE";
		static public String ARRIVAL_TIME = "ARRIVETIME";
		static public String LEFT_TIME = "LEFTTIME";
		static public String SUBWAY_NAME = "SUBWAYNAME";
		static public String SUBWAY_CODE = "SUBWAYCODE";
		static public String TRAIN_CODE = "TRAINCODE";
		static public String DESTSTATION_NAME = "DESTSTATION_NAME";
		static public String DESTSTATION_CODE = "DESTSTATION_CODE";

		
		static public String UP_GOING = "1"; //상행
		static public String DOWN_GOING = "2"; //하행
		static public String WEEKDAY = "1"; // 평일
		static public String SATURDAY = "2"; // 토요일
		static public String HOLIDAY = "3"; // 휴일
		
		static public String ARRIVAL_INFO_SERVICE = "SearchArrivalTimeOfLine2SubwayByIDService";
		static public String FIND_INFO_SERVICE = "SearchInfoBySubwayNameService";
		//http://openAPI.seoul.go.kr:8088/sample/xml/SearchArrivalTimeOfLine2SubwayByIDService/1/5/0201/1/1/
	}
}
