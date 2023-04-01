package ezen.hang.heritage.domain.item.service;

import java.util.List;

import ezen.hang.heritage.domain.item.dto.Heritage;

public interface ItemService {

	public List<Heritage> searchHeritageParsing(String heritagename);

	public List<Heritage> detailSearchHeritageParsing(String ccbaKdcd, String ccbaAsno, String ccbaCtcd);
}
