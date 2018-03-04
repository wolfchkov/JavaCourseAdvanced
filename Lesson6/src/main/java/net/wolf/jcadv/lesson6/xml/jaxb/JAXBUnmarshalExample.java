/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.wolf.jcadv.lesson6.xml.jaxb;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author Andrey
 */
public class JAXBUnmarshalExample {
    
    public static void main(String[] args) throws JAXBException {
        //Создаем JAXB контекст, указывае все доменные классы 
        JAXBContext context = JAXBContext.newInstance(Company.class, Staff.class);
        
        //Создаем JAXB анмаршалер, из полученного выше контекста
        Unmarshaller unmarshaller = context.createUnmarshaller();
        
        Company company = (Company) unmarshaller
                .unmarshal(JAXBUnmarshalExample.class.getResourceAsStream("../staff.xml"));
        
        System.out.println(company);
    }
}
