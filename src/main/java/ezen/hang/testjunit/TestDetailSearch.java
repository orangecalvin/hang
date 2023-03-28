package ezen.hang.testjunit;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ezen.hang.search.dao.HeritageDataDetailSearchParsing;

class TestDetailSearch {
	HeritageDataDetailSearchParsing hddsr;

	@BeforeEach
	public void hddsr() {
		hddsr = new HeritageDataDetailSearchParsing();
	}

	@Test
	void test() {
		hddsr.setCcbaAsno("00010000"); // 관리번호
		hddsr.setCcbaCtcd("11"); // 시도코드
		hddsr.setCcbaKdcd("11"); // 종목코드
		List<String> result = new ArrayList<>();
		result = hddsr.detailSearchHeritageParsing();
		for (String string : result) {
			System.out.println(string);
		}
	}
	
	@AfterEach
	public void hdssrEnd() {
		
	}

}
