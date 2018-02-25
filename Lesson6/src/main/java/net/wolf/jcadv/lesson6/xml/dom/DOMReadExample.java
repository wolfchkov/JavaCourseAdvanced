/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.wolf.jcadv.lesson6.xml.dom;


import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
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
	Document doc = dBuilder.parse(DOMReadExample.class.getResourceAsStream("staff.xml"));

	//не обязательно но рекомендуется 
	//почитать - http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
	doc.getDocumentElement().normalize();

	System.out.println("Главный элемент :" + doc.getDocumentElement().getNodeName());

        //получаем список элементов staff
	NodeList nList = doc.getElementsByTagName("staff");

	System.out.println("----------------------------");

        //выводим в консоль
	for (int temp = 0; temp < nList.getLength(); temp++) {

		Node nNode = nList.item(temp);

		System.out.println("\nТекущий элемент: " + nNode.getNodeName());

		if (nNode.getNodeType() == Node.ELEMENT_NODE) {

			Element eElement = (Element) nNode;

			System.out.println("id ставки: " + eElement.getAttribute("id"));
			System.out.println("Имя: " + eElement.getElementsByTagName("firstname").item(0).getTextContent());
			System.out.println("Фамилия: " + eElement.getElementsByTagName("lastname").item(0).getTextContent());
			System.out.println("Ник: " + eElement.getElementsByTagName("nickname").item(0).getTextContent());
			System.out.println("Ставка: " + eElement.getElementsByTagName("salary").item(0).getTextContent());

		}
	}
    } catch (IOException | ParserConfigurationException | DOMException | SAXException e) {
	e.printStackTrace();
    }
  }
}
