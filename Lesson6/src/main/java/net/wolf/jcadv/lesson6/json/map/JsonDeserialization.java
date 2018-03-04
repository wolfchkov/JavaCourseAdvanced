/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.wolf.jcadv.lesson6.json.map;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author Andrey
 */
public class JsonDeserialization {
    public static void main(String[] args) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        List<Staff> staffs = objectMapper.readValue(JsonDeserialization.class.getResourceAsStream("../staffs.json"),
                new TypeReference<List<Staff>>(){});
        System.out.println(staffs);
    }
}
