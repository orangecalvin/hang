package ezen.hang.search.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ezen.hang.search.dao.HeritageDataSearchParsing;

@Controller
@RequestMapping("/search")
public class SearchController {
	
	@PostMapping
	public String search(@RequestParam("heritagename") String heritagename, Model model) {
		HeritageDataSearchParsing hdsp = new HeritageDataSearchParsing();
		hdsp.setCcbaMnm1Value(heritagename); // test.html에서 받아온 검색단어를 문화재청 API에 단어검색으로 입력
		List<String> result = new ArrayList<>();
		result = hdsp.searchHeritageParsing(); // 문화재청 API 검색결과 반환 값 list로 담기
		// API 결과값 result로 반환
		model.addAttribute("result", result);
		return "main";
	}
	
	
}
