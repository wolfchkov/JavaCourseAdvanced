/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.wolf.jcadv.lesson4.tcp;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.net.Socket;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 *
 * @author Andrey
 */
public class WhoIsUtil {
    
    private final String host;
    private final int port;

    public WhoIsUtil(String host, int port) {
        this.host = host;
        this.port = port;
    }
    
    public List<String> whoIs(String name) throws IOException {
        try (Socket socket = new Socket(host, port);) {
        
        
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
            
            writer.print(name);            
            writer.print("\r\n");            
            writer.flush();
            
            return reader.lines()
                    .collect(Collectors.toList());
        }
    }
    
    
    public static void main(String[] args) {
        WhoIsUtil whoIsUtil = new WhoIsUtil("whois.internic.net", 43);
        
        
        try {
            List<String> google = whoIsUtil.whoIs("wikipedia.com");
            google.forEach(System.out::println);
        } catch (IOException ex) {
            Logger.getLogger(WhoIsUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
