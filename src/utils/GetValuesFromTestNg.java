package io.smartnexus.ats.utils;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class GetValuesFromTestNg {
  private Map map;

  public static final String xmlFilePath = System.getProperty("user.dir") + File.separator + "testNg.xml";
  // public static final String xmlFilePath="C:\\Users\\pm00339675\\testNg.xml";

  @SuppressWarnings({ "unchecked", "rawtypes" })
  public Map getValuesFromXml() {
    try {
      File xmlFile = new File(xmlFilePath);
      DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
      DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
      Document doc = documentBuilder.parse(xmlFile);
      doc.getDocumentElement().normalize();
      // System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
      NodeList nodeList = doc.getElementsByTagName("parameter");
      // System.out.println(nodeList.getLength());
      map = new HashMap<String, String>();
      for (int itr = 0; itr < nodeList.getLength(); itr++) {
        Node node = nodeList.item(itr);
        // System.out.println("\nNode Name :" + node.getNodeName());
        if (node.getNodeType() == Node.ELEMENT_NODE) {
          Element eElement = (Element) node;

          map.put(eElement.getAttribute("name"), eElement.getAttribute("value"));
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return map;
  }

}