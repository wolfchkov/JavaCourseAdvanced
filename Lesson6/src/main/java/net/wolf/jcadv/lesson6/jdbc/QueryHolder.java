/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.wolf.jcadv.lesson6.jdbc;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.stream.Collectors;

/**
 *
 * @author Andrey
 */
public class QueryHolder {
    
    private static final QueryHolder INSTANCE;
    
    static {
        INSTANCE = new QueryHolder();
        try {
            INSTANCE.init();
        } catch (IOException ex) {
            System.err.println("Can't load sql queries! " + ex);
        }
    }
    
    private final Map<String, String> queries = new HashMap<>();    
    
    public static QueryHolder getInstance() {
        return INSTANCE;
    }
    
    private void init() throws IOException {        
        queries.putAll(loadProperties("tables.xml"));
        queries.putAll(loadProperties("queries.xml"));                
    }
    
    private Map<String, String> loadProperties(String resource) throws IOException {
        Properties properties = new Properties();
        properties.loadFromXML(QueryHolder.class.getResourceAsStream("tables.xml"));
        return properties.entrySet()
                .stream()
                .collect(Collectors.toMap(e -> e.getKey().toString(), e -> e.getValue().toString()));
    }
 
    public String getQuery(String name) {
        return queries.get(name);
    }
}
