/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.wolf.jcadv.lesson6.xml.jaxb;

import java.math.BigDecimal;
import java.util.Arrays;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

/**
 *
 * @author Andrey
 */
public class JAXBMarshalExample {
    
    public static void main(String[] args) throws JAXBException {
        //Создаем JAXB контекст, указывае все доменные классы 
        JAXBContext context = JAXBContext.newInstance(Company.class, Staff.class);
        
        //Создаем JAXB маршалер, из полученного выше контекста
        Marshaller marshaller = context.createMarshaller();
        
        Staff staff1 = new Staff(1, "Petr", "Petrov", "petya", new BigDecimal("12000"));
        Staff staff2 = new Staff(2, "Ivan", "Ivanov", "vano", new BigDecimal("11000"));
        Staff staff3 = new Staff(3, "Ilya", "Ilichov", "iluha", new BigDecimal("25000"));
        
        Company company = new Company(Arrays.asList(staff1, staff2, staff3));
        
        marshaller.marshal(company, System.out);
    }
}
