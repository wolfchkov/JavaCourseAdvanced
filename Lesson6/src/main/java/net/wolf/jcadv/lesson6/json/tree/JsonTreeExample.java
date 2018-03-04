/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.wolf.jcadv.lesson6.json.tree;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;

/**
 *
 * @author Andrey
 */
public class JsonTreeExample {
    
    public static void main(String[] args) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        
        JsonNode json = objectMapper.readTree(JsonTreeExample.class.getResourceAsStream("../staff.json"));
        
        System.out.println("JsonNode type: " + json.getNodeType());        
        System.out.println("field id: " + json.get("id").asText());
        System.out.println("field firstname: " + json.get("firstname").asText());
        System.out.println("field lastname: " + json.get("lastname").asText());
        System.out.println("field nickname: " + json.get("nickname").asText());
        System.out.println("field salary: " + json.get("salary").asText());
    }
}
