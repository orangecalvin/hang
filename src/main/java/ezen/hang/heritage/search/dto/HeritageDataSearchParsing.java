package ezen.hang.heritage.search.dto;

import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import ezen.hang.heritage.Heritage;

public class HeritageDataSearchParsing {
	private String ccbaMnm1Value;

	public String getCcbaMnm1Value() {
		return ccbaMnm1Value;
	}

	public void setCcbaMnm1Value(String ccbaMnm1Value) {
		this.ccbaMnm1Value = ccbaMnm1Value;
	}

	public List<Heritage> searchHeritageParsing (){
		String url = "http://www.cha.go.kr/cha/SearchKindOpenapiList.do?ccbaMnm1="+ccbaMnm1Value;
		List<Heritage> list = new ArrayList<>();
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
						Heritage heritage = new Heritage();
						heritage.setSn(eElement.getElementsByTagName("sn").item(0).getTextContent());
	                    heritage.setNo(eElement.getElementsByTagName("no").item(0).getTextContent());
	                    heritage.setCcmaName(eElement.getElementsByTagName("ccmaName").item(0).getTextContent());
	                    heritage.setCrltsnoNm(eElement.getElementsByTagName("crltsnoNm").item(0).getTextContent());
	                    heritage.setCcbaMnm1(eElement.getElementsByTagName("ccbaMnm1").item(0).getTextContent());
	                    heritage.setCcbaMnm2(eElement.getElementsByTagName("ccbaMnm2").item(0).getTextContent());
	                    heritage.setCcbaCtcdNm(eElement.getElementsByTagName("ccbaCtcdNm").item(0).getTextContent());
	                    heritage.setCcbaAdmin(eElement.getElementsByTagName("ccbaAdmin").item(0).getTextContent());
	                    heritage.setCcbaKdcd(eElement.getElementsByTagName("ccbaKdcd").item(0).getTextContent());
	                    heritage.setCcbaCtcd(eElement.getElementsByTagName("ccbaCtcd").item(0).getTextContent());
	                    heritage.setCcbaAsno(eElement.getElementsByTagName("ccbaAsno").item(0).getTextContent());
	                    heritage.setCcbaCncl(eElement.getElementsByTagName("ccbaCncl").item(0).getTextContent());
	                    heritage.setCcbaCpno(eElement.getElementsByTagName("ccbaCpno").item(0).getTextContent());
	                    heritage.setLongitude(eElement.getElementsByTagName("longitude").item(0).getTextContent());
	                    heritage.setLatitude(eElement.getElementsByTagName("latitude").item(0).getTextContent());
	                    list.add(heritage);
					}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}
