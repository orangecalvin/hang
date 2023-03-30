package ezen.hang.heritage.search.dto;

import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class HeritageDataDetailSearchParsing {
	private String ccbaKdcd;
	private String ccbaAsno;
	private String ccbaCtcd;
	private List<String> list = new ArrayList<>();
	
	public String getCcbaKdcd() {
		return ccbaKdcd;
	}


	public void setCcbaKdcd(String ccbaKdcd) {
		this.ccbaKdcd = ccbaKdcd;
	}


	public String getCcbaAsno() {
		return ccbaAsno;
	}


	public void setCcbaAsno(String ccbaAsno) {
		this.ccbaAsno = ccbaAsno;
	}


	public String getCcbaCtcd() {
		return ccbaCtcd;
	}


	public void setCcbaCtcd(String ccbaCtcd) {
		this.ccbaCtcd = ccbaCtcd;
	}


	public List<String> detailSearchHeritageParsing(){
		String url = "http://www.cha.go.kr/cha/SearchKindOpenapiDt.do?ccbaKdcd="+ccbaKdcd+"&ccbaAsno="+ccbaAsno+"&ccbaCtcd="+ccbaCtcd; // 상세조회
		try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(url);
            doc.getDocumentElement().normalize();
            NodeList nList = doc.getElementsByTagName("result");
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    StringBuilder sb = new StringBuilder();
					Element el = eElement;
					String[] fields = {"ccbaKdcd", "ccbaAsno", "ccbaCtcd", "ccbaCpno", "longitude", "latitude", "ccmaName", "crltsnoNm", "ccbaMnm1", "ccbaMnm2", "gcodeName", "bcodeName", "mcodeName", "scodeName", "ccbaQuan", "ccbaAsdt", "ccbaCtcdNm", "ccsiName", "ccbaLcad", "ccceName", "ccbaPoss", "ccbaAdmin", "ccbaCncl", "ccbaCndt", "imageUrl", "content"};
					for (String field : fields) {
						sb.append("!");
					    sb.append(el.getElementsByTagName(field).item(0).getTextContent());
					}
					list.add(sb.toString());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
		return list;
	}
	
	
}
