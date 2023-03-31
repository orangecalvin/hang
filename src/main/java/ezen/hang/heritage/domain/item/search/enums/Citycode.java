package ezen.hang.heritage.domain.item.search.enums;

public enum Citycode {
	SEOUL("서울", "11"),
	BUSAN("부산", "21"),
	DAEGU("대구", "22"),
	INCHEON("인천", "23"),
	GWANGJU("광주", "24"),
	DAEJEON("대전", "25"),
	ULSAN("울산", "26"),
	SEJONG("세종", "45"),
	GYEONGGI("경기", "31"),
	GANGWON("강원", "32"),
	CHUNGCHEONBUKDO("충북", "33"),
	CHUNGCHEONNAMDO("충남", "34"),
	JEOLLABUKDO("전북", "35"),
	JEOLLANAMDO("전남", "36"),
	GYEONGSANGBUKDO("경북", "37"),
	GYEONGSANGNAMDO("경남", "38"),
	JEJU("제주", "50"),
	NATIONALWIDE("전국","ZZ");

	private String cityName;
	private String cityCode;
	
	Citycode(String cityName, String cityCode) {
		this.cityName = cityName;
		this.cityCode = cityCode;
	}

	public String getCityName() {
		return cityName;
	}

	public String getCityCode() {
		return cityCode;
	}
	
}
