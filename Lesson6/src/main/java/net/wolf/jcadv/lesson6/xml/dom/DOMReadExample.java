/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.wolf.jcadv.lesson6.xml.dom;


import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import net.wolf.jcadv.lesson6.xml.Staff;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * Пример работы с DOM Parser для xntybz XML
 * @author Andrey
 */
public class DOMReadExample {
      public static void main(String argv[]) {

    try {
	//Создаем фабрику документа
	DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        
        //Создаем билдер документа 
	DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        
        
        
        //Парсим XML
	Document doc = dBuilder.parse(DOMReadExample.class.getResourceAsStream("../staff.xml"));

	//не обязательно но рекомендуется 
	//почитать - http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
	doc.getDocumentElement().normalize();

	System.out.println("Главный элемент :" + doc.getDocumentElement().getNodeName());

        //получаем список элементов staff
	NodeList nList = doc.getElementsByTagName("staff");

	System.out.println("----------------------------");

        List<Staff> saffs = new ArrayList<>();
        //Создаем объекты Staff
	for (int temp = 0; temp < nList.getLength(); temp++) {

		Node nNode = nList.item(temp);

                
		if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                        Staff staff = new Staff();                        
			Element eElement = (Element) nNode;

                        staff.setId(Integer.parseInt(eElement.getAttribute("id")));
                        staff.setFirstName(eElement.getElementsByTagName("firstname").item(0).getTextContent());
                        staff.setLastName(eElement.getElementsByTagName("lastname").item(0).getTextContent());
                        staff.setNick(eElement.getElementsByTagName("nickname").item(0).getTextContent());
                        staff.setSalary(new BigDecimal(eElement.getElementsByTagName("salary").item(0).getTextContent()));
                        
                        saffs.add(staff);
		}
	}
        
        System.out.println(saffs);
    } catch (IOException | ParserConfigurationException | DOMException | SAXException e) {
	e.printStackTrace();
    }
  }
}
