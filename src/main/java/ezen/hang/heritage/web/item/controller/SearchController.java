package ezen.hang.heritage.web.item.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ezen.hang.heritage.domain.item.dto.Heritage;
import ezen.hang.heritage.domain.item.service.ItemService;

/**
 * post로 전송받은 검색단어로 검색결과 반환 클래스 view에서 heritagename의 parameter로 전송되어야 검색가능
 * 
 * @author 김정석
 * @date 2023. 3. 28.
 */
@RestController
@RequestMapping("/heritage/item/search")
public class SearchController {

	@Autowired
	private ItemService itemService;

	@PostMapping
	@ResponseBody
	public List<Heritage> search(@RequestParam("heritagename") String heritagename) {
		return itemService.searchHeritageParsing(heritagename);
	}

//	@PostMapping("/detail")
//	@ResponseBody
//	public List<Heritage> search(@RequestParam("ccbaKdcd") String ccbaKdcd, @RequestParam("ccbaAsno") String ccbaAsno, @RequestParam("ccbaCtcd") String ccbaCtcd) {
//		return itemService.detailSearchHeritageParsing(ccbaKdcd,ccbaAsno,ccbaCtcd);
//	}

	@PostMapping("/detail")
	@ResponseBody
	public List<Heritage> search(@RequestBody Map<String, Object> heritageData) {
		String ccbaKdcd = heritageData.get("ccbaKdcd").toString();
		String ccbaAsno = heritageData.get("ccbaAsno").toString();
		String ccbaCtcd = heritageData.get("ccbaCtcd").toString();
		return itemService.detailSearchHeritageParsing(ccbaKdcd, ccbaAsno, ccbaCtcd);
	}
}