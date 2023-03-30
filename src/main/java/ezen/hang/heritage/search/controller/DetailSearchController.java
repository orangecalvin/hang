package ezen.hang.heritage.search.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ezen.hang.heritage.Heritage;
import ezen.hang.heritage.search.dto.HeritageDataDetailSearchParsing;
/**
 * post로 전송받은 검색단어로 검색결과 반환 클래스
 * view에서 heritagename의 parameter로 전송되어야 검색가능
 * @author 김정석
 * @date   2023. 3. 28.
 */
@RestController
@RequestMapping("/search/detail")
public class DetailSearchController {
	
	@PostMapping
	@ResponseBody
	public List<Heritage> search(@RequestParam("ccbaKdcd") String ccbaKdcd, @RequestParam("ccbaAsno") String ccbaAsno, @RequestParam("ccbaCtcd") String ccbaCtcd) {
		HeritageDataDetailSearchParsing hddsp = new HeritageDataDetailSearchParsing();
		hddsp.setCcbaKdcd(ccbaKdcd);
		hddsp.setCcbaAsno(ccbaAsno);
		hddsp.setCcbaCtcd(ccbaCtcd);
		return hddsp.detailSearchHeritageParsing();
	}
}
