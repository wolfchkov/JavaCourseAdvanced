/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.wolf.jcadv.lesson6.xml.sax;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import net.wolf.jcadv.lesson6.xml.Staff;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author Andrey
 */
public class StaffHandler extends DefaultHandler {

    private List<Staff> saffs;

    private Staff proccesedStaff;
    private Field proccesedField;
    private boolean readData = false;

    @Override
    public void startDocument() throws SAXException {
        saffs = new ArrayList<>();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        switch (qName) {
            case "document":
                //нечего делать
                break;
            case "staff":
                //начало ставки
                proccesedStaff = new Staff();
                proccesedStaff.setId(Integer.parseInt(attributes.getValue("id")));
                break;
            case "firstname":
                field(Field.FIRST_NAME);
                break;
            case "lastname":
                field(Field.LAST_NAME);
                break;
            case "nickname":
                field(Field.NICK);
                break;
            case "salary":
                field(Field.SALARY);
                break;
        }
    }

    @Override
    public void endElement(String uri, String localName,
            String qName) throws SAXException {
        if ("staff".equals(qName)) {
            saffs.add(proccesedStaff);
        }
        readData = false;
    }

    @Override
    public void characters(char ch[], int start, int length) throws SAXException {
        if (!readData) {
            return;
        }
        
        String value = new String(ch, start, length);
        System.out.println("characters => " + value);
        switch (proccesedField) {
            case FIRST_NAME:
                proccesedStaff.setFirstName(value);
                break;
            case LAST_NAME:
                proccesedStaff.setLastName(value);
                break;
            case NICK:
                proccesedStaff.setNick(value);
                break;
            case SALARY:
                proccesedStaff.setSalary(new BigDecimal(value));
                break;
        }
    }

    public List<Staff> getSaffs() {
        return saffs;
    }

    private void field(Field field) {
        proccesedField = field;
        readData = true;
    }

    private static enum Field {
        FIRST_NAME,
        LAST_NAME,
        NICK,
        SALARY
    }
}
