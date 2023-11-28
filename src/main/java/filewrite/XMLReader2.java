package filewrite;

import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


// reference : https://www.javatpoint.com/how-to-read-xml-file-in-java
public class XMLReader2 {

	static void getAreaName(String path) throws ParserConfigurationException, SAXException, IOException {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document doc = db.parse(path);

		doc.getDocumentElement().normalize();
		System.out.println("Root Element: " + doc.getDocumentElement().getNodeName());
		NodeList nodeList = doc.getElementsByTagName("responseData");// This will capture responseData node
		Node node = nodeList.item(2);// This will give responseDate at index 2
		for (int i = 0; i < nodeList.getLength(); i++) {
			Node node1 = nodeList.item(i);

//			if (node.getNodeType() == Node.ELEMENT_NODE)   
//			{  } The below code will be inside if

			Element eElement1 = (Element) node1;
			String content = eElement1.getElementsByTagName("areaName").item(0).getTextContent();
			System.out.println(content);

		}

//		System.out.println("\nNode Name :" + node.getNodeName());
//		Element eElement = (Element) node;
//		System.out.println(eElement.getElementsByTagName("areaName").item(0).getTextContent());

	}

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {

		String path = System.getProperty("user.dir") + "\\src\\test\\resources\\files\\jsontoxml.xml";

		// getAreaName(path);
		getareaName2(path);
	}

	public static void getareaName2(String path) throws ParserConfigurationException, SAXException, IOException {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document doc = db.parse(path);

		doc.getDocumentElement().normalize();
		System.out.println("Root Element: " + doc.getDocumentElement().getNodeName());
		NodeList nodeList = doc.getElementsByTagName("responseData");// This will capture responseData node
		
		for (int i = 0; i < nodeList.getLength(); i++) {
			Node node1 = nodeList.item(i);// This will give responseData at index i
			Element eElement1 = (Element) node1; // This will help to get inside the node responseData

			NodeList n2 = eElement1.getElementsByTagName("areaOfLaws"); //This will point to areaOfLaws in responseData
			for (int k = 0; k < n2.getLength(); k++) {
				Node node2 = n2.item(k);// This will give areaOfLaws at index i
				Element eElement2 = (Element) node2; // This will help to get inside the node areaOfLaws
				String content2 = eElement2.getElementsByTagName("areaName").item(0).getTextContent(); //This will point to areaName in areaOfLaws
				System.out.println(eElement1.getNodeName()+i+"--"+eElement2.getNodeName()+k+"--"+content2);
			}

		}

	}

}
