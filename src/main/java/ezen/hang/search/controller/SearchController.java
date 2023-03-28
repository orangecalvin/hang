package ezen.hang.search.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import ezen.hang.heritage.dto.Heritage;
import ezen.hang.search.dao.HeritageDataSearchParsing;
/**
 * post로 전송받은 검색단어로 검색결과 반환 클래스
 * view에서 heritagename의 parameter로 전송되어야 검색가능
 * @author 김정석
 * @date   2023. 3. 28.
 */
@Controller
@RequestMapping("/search")
public class SearchController {
	
	@PostMapping
	@ResponseBody
	public List<Heritage> search(@RequestParam("heritagename") String heritagename) {
		HeritageDataSearchParsing hdsp = new HeritageDataSearchParsing();
		hdsp.setCcbaMnm1Value(heritagename); // test.html에서 받아온 검색단어를 문화재청 API에 단어검색으로 입력
		return hdsp.searchHeritageParsing();
	}
}
