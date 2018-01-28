/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.wolf.jcadv.lesson4.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * Реализация клиента, работающего по протоколу UDP
 * @author Andrey
 */
public class EchoClient {

    /**
     * UDP сокет, через который клиент осуществляфет отправку/прием сообщений
     */
    private final DatagramSocket socket;
    
    /**
     * Адрес сервера
     */
    private final InetAddress address;
    
    /**
     * Порт сервера
     */
    private final int port;

    /**
     * Буффер для приема сообщений
     */
    private final byte[] buf = new byte[1024];

    public EchoClient(String server, int port) throws SocketException, UnknownHostException {
        socket = new DatagramSocket();
        address = InetAddress.getByName(server);
        this.port = port;
    }

    public String sendEcho(String msg) throws IOException {
        byte[] msgData = msg.getBytes();
        //создаем пакет для отправки 
        DatagramPacket packet
                = new DatagramPacket(msgData, msgData.length, address, port);
        
        //отправляем
        socket.send(packet);
        
        //создаем пакет для приема 
        packet = new DatagramPacket(buf, buf.length);
        //принимаем
        socket.receive(packet);
        
        //преобразовуем в строку
        String received = new String(
                packet.getData(), 0, packet.getLength());
        return received;
    }

    public void close() {
        socket.close();
    }
    
    public static void main(String[] args) throws SocketException, UnknownHostException, IOException {
        Scanner scanner = new Scanner(System.in);
        
        String msg = "";
        EchoClient echoClient = new EchoClient("localhost", 4545);
        
        System.out.print("Enter message: ");
        while (!"end".equalsIgnoreCase(msg)
                && scanner.hasNextLine()) {                    
        
            msg = scanner.nextLine();
            
            String echo = echoClient.sendEcho(msg);

            System.out.print("Echo server say: " + echo);
            System.out.println();
            System.out.print("Enter message: ");
        } 
        
    }
}
