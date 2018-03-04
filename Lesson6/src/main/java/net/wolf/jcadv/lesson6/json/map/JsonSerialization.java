/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.wolf.jcadv.lesson6.json.map;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Andrey
 */
public class JsonSerialization {
    
    static ObjectMapper objectMapper = new ObjectMapper();
    
    static void serialize() throws IOException {
        Staff staff = new Staff(10, "Petr", "Petrov", "petya", BigDecimal.valueOf(154565));
        objectMapper.writeValue(System.out, staff);
    }
    
    static void serializeArray() throws IOException {
        Staff staff1 = new Staff(10, "Petr", "Petrov", "petya", BigDecimal.valueOf(154565));
        Staff staff2 = new Staff(10231, "Jim", "Kerry", "jkerry", BigDecimal.valueOf(20000));
        Staff staff3 = new Staff(10, "John", "Snow", "jsnow", BigDecimal.valueOf(100000));
        List<Staff> list = Arrays.asList(staff1, staff2, staff3);
        objectMapper.writeValue(System.out, list);
    }
    
    public static void main(String[] args) throws IOException {
        //serialize();
        serializeArray();
    }
            
}
