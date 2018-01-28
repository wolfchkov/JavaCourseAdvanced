/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.wolf.jcadv.lesson4.tcp.timeserver;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Наш сервер 
 * @author Andrey
 */
public class TimeServer {

    /**
     * Порт который слушает наш сервер
     */
    private final int port;


    public TimeServer(int port) {
        this.port = port;
    }

    public void start(int maxQueue) {
        System.out.println("Starting server...");
        
        try (ServerSocket serverSocket = new ServerSocket(port, maxQueue);) {
            
            while (true) {
                System.out.println("Waiting new client on port " + port);
                Socket accept = serverSocket.accept();
                System.out.println("New client connected " + accept.getRemoteSocketAddress());
                Thread thread = new Thread(new CommandExecutor(accept));
                thread.start();
            }

        } catch (IOException ioe) {
            System.out.println(ioe);
        }
    }

    
    public static void main(String[] args) {
        TimeServer timeServer = new TimeServer(15245);
        timeServer.start(200);
    }
}
