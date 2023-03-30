package ezen.hang.heritage.search.enums;

public enum Classification {
	NATIONAL_TREASURE("국보", "11"),
	TREASURE("보물", "12"),
	HISTORIC_SITES("사적", "13"),
	HISTORICAL_SITES_AND_SCENIC_SPOTS("사적 및 명승", "14"),
	SCENIC_SPOTS("명승", "15"),
	NATURAL_MONUMENT("천연기념물", "16"),
	NATIONAL_INTANGIBLE_CULTURAL_PROPERTY("국가무형문화재", "17"),
	NATIONAL_FOLK_CULTURAL_HERITAGE("국가민속문화재", "18"),
	CITY_TANGIBLE_CULTURAL_HERITAGE("시도유형문화재", "21"),
	CITY_INTANGIBLE_CULTURAL_HERITAGE("시도무형문화재", "22"),
	CITY_MONUMENT("시도기념물", "23"),
	CITY_FOLK_CULTURAL_HERITAGE("시도민속문화재", "24"),
	CITY_PROVAINCIAL_REGISTERED_CULTURAL_PROPERTY("시도등록문화재", "25"),
	CULTURAL_HERITAGE_DATA("문화재자료", "31"),
	NATIONAL_REGISTERED_CULTURAL_PROPERTY("국가등록문화재", "79"),
	INTANGIBLE_CULTURAL_HERITAGE_OF_THE_NORTH_5_PROVINCES("이북5도 무형문화재", "80");
	
	private final String type;
	private final String heritageCode;
	
	Classification(String type, String heritageCode) {
		this.type = type;
		this.heritageCode = heritageCode;
	}

	public String getType() {
		return type;
	}

	public String getHeritageCode() {
		return heritageCode;
	}
	
}
