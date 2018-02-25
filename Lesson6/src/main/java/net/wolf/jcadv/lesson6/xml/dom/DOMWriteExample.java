/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.wolf.jcadv.lesson6.xml.dom;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 *
 * @author Andrey
 */
public class DOMWriteExample {

    public static void main(String argv[]) {
        try {
            //Создаем фабрику документа
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            //Создаем билдер документа 
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

            //Корневой элемент
            Document doc = docBuilder.newDocument();
            Element rootElement = doc.createElement("company");
            doc.appendChild(rootElement);

            //элемент staff
            Element staff = doc.createElement("staff");
            rootElement.appendChild(staff);

            //атрибут для элемента staff
            staff.setAttribute("id", "1");
            
            //имя
            Element firstname = doc.createElement("firstname");
            firstname.appendChild(doc.createTextNode("Andrey"));
            staff.appendChild(firstname);

            //фамилия
            Element lastname = doc.createElement("lastname");
            lastname.appendChild(doc.createTextNode("Volchkov"));
            staff.appendChild(lastname);

            //ник
            Element nickname = doc.createElement("nickname");
            nickname.appendChild(doc.createTextNode("wolfchkov"));
            staff.appendChild(nickname);

            //ставка
            Element salary = doc.createElement("salary");
            salary.appendChild(doc.createTextNode("100000"));
            staff.appendChild(salary);

            //превращаем в строку через преобразователь
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            
            //Ввводим в консоль
            //StreamResult result = new StreamResult(new File("C:\\file.xml"));
            StreamResult result = new StreamResult(System.out);
            transformer.transform(source, result);

        } catch (ParserConfigurationException | TransformerException pce) {
            pce.printStackTrace();
        }
    }
}
