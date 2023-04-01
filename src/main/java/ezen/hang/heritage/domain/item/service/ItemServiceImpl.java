package ezen.hang.heritage.domain.item.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ezen.hang.heritage.domain.item.dao.DataSearchDao;
import ezen.hang.heritage.domain.item.dto.Heritage;

@Service
public class ItemServiceImpl implements ItemService{
	
	@Autowired
	private DataSearchDao dsd;
	
	@Override
	public List<Heritage> searchHeritageParsing(String heritagename) {
		dsd.setCcbaMnm1Value(heritagename);
		return dsd.searchHeritage();
	}

	@Override
	public List<Heritage> detailSearchHeritageParsing(String ccbaKdcd, String ccbaAsno, String ccbaCtcd) {
		dsd.setCcbaKdcd(ccbaKdcd);
		dsd.setCcbaAsno(ccbaAsno);
		dsd.setCcbaCtcd(ccbaCtcd);
		return dsd.detailSearchHeritage();
	}

}
