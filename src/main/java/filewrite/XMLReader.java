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

//Java DOM Parser

public class XMLReader {

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {

		String path = System.getProperty("user.dir") + "\\src\\test\\resources\\files\\jsontoxml.xml";
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse(path);

		// extract root node from xml doc
		Element root = document.getDocumentElement();
		NodeList nodeList = root.getChildNodes();

		System.out.println(nodeList.getLength());

		/*
		 * for (int i = 0; i < nodeList.getLength(); i++) { Node node =
		 * nodeList.item(i); if (node.getNodeType() == Node.ELEMENT_NODE) { Element
		 * element = (Element) node; String tagName = element.getTagName(); String
		 * textContent = element.getTextContent(); System.out.println(tagName + " " +
		 * textContent); } }
		 */

		for (int i = 0; i < nodeList.getLength(); i++) {
			Node node = nodeList.item(i);
			if (node.getNodeType() == Node.ELEMENT_NODE) {
				Element element = (Element) node;
				NodeList n1 = element.getChildNodes();
				for (int k = 0; k < n1.getLength(); k++) {
					Node node2 = n1.item(k);
					if (node2.getNodeType() == Node.ELEMENT_NODE) {
						Element ele2 = (Element) node2;
						String tagName2 = ele2.getTagName();
						String textContent2 = ele2.getTextContent();
						System.out.println(tagName2 + " " + textContent2);
					}
				}
				String tagName = element.getTagName();
				String textContent = element.getTextContent();
				System.out.println(tagName + " " + textContent);
			}
		}

	}

}
