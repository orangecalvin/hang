package ezen.hang.search.dao;

import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class HeritageDataSearchParsing {
	private String ccbaMnm1Value;
	private List<String> list = new ArrayList<>();

	public String getCcbaMnm1Value() {
		return ccbaMnm1Value;
	}

	public void setCcbaMnm1Value(String ccbaMnm1Value) {
		this.ccbaMnm1Value = ccbaMnm1Value;
	}

	public List<String> searchHeritageParsing (){
		String url = "http://www.cha.go.kr/cha/SearchKindOpenapiList.do?ccbaMnm1="+ccbaMnm1Value;
		try {
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(url);
			doc.getDocumentElement().normalize();
			NodeList nList = doc.getElementsByTagName("item");
			for (int temp = 0; temp < nList.getLength(); temp++) {
				Node nNode = nList.item(temp);
					if (nNode.getNodeType() == Node.ELEMENT_NODE) {
						Element eElement = (Element) nNode;
						StringBuilder sb = new StringBuilder();
						Element el = eElement;
						String[] fields = {"sn", "no", "ccmaName", "crltsnoNm", "ccbaMnm1", "ccbaMnm2", "ccbaCtcdNm", "ccbaAdmin", "ccbaKdcd", "ccbaCtcd", "ccbaAsno", "ccbaCncl", "ccbaCpno", "longitude", "latitude"};
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
