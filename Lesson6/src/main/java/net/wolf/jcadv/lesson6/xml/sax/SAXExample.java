/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.wolf.jcadv.lesson6.xml.sax;

import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.SAXException;

/**
 *
 * @author Andrey
 */
public class SAXExample {

    public static void main(String argv[]) {

        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            
            StaffHandler staffHandler = new StaffHandler();
            saxParser.parse(SAXExample.class.getResourceAsStream("../staff.xml"), staffHandler);
            
            System.out.println(staffHandler.getSaffs());
        } catch (IOException | SAXException | ParserConfigurationException ex) {
            System.out.println(ex);
        }
    }

}
