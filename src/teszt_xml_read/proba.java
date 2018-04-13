package teszt_xml_read;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class proba {
	public static void main(String [] angs) {
		try {

			File XmlFile = new File("proba3.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(XmlFile);
			doc.getDocumentElement().normalize();
					
			NodeList nList = doc.getElementsByTagName("item");

			for (int i = 0; i < nList.getLength(); i++) {

				Node nNode = nList.item(i);	
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {

					Element eElement = (Element) nNode;

					System.out.println("Gyarto: " + eElement.getElementsByTagName("producer").item(0).getTextContent());
					System.out.println("Termek: " + eElement.getElementsByTagName("serrial").item(0).getTextContent() + " " + eElement.getElementsByTagName("serrialnumber").item(0).getTextContent());
					System.out.println("Foglalat: " + eElement.getElementsByTagName("socket").item(0).getTextContent());
					System.out.println("Órajel: " + eElement.getElementsByTagName("clock").item(0).getTextContent());
					System.out.print("\n");
				}
			}
		    } catch (Exception e) {
			e.printStackTrace();
		    }
	  }
}
