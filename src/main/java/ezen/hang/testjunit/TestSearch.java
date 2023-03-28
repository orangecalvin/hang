package ezen.hang.testjunit;


import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import ezen.hang.search.dao.HeritageDataSearchParsing;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestSearch {
	HeritageDataSearchParsing hdsp;
	
	@BeforeEach
	public void hdsp() {
		hdsp = new HeritageDataSearchParsing();
	}
	
	
	@Test
	@Order(1)
	public void setitem() {
		hdsp.setCcbaMnm1Value("경복궁");  // 웹 페이지 검색요청값 (문화재명)
		List<String> result = new ArrayList<>();
		result = hdsp.searchHeritageParsing();
		for (String string : result) {
			System.out.println(string);
		}
	}

	
	@AfterEach
	public void hdspEnd() {
		
	}
}
