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

/**
 * Реализация ЭХО-сервера использующего протоко UDP
 * @author Andrey
 */
public class EchoServer  {

    /**
     * UDP сокет который будет "слушать" наш сервер 
     */
    private final DatagramSocket socket;
    /**
     * Буффер данных
     */
    private final byte[] buf = new byte[1024];

    public EchoServer(int port) throws SocketException {
        socket = new DatagramSocket(port);
        System.out.println("Server started on port " + port + ".");
    }

    public void run() {
        
        while (true) {
            //пакет - приемник
            DatagramPacket packet
                    = new DatagramPacket(buf, buf.length);
            //читаем пришедший пакет
            try {
                socket.receive(packet);
            } catch (IOException ex) {
                System.err.println(ex);
            }
            //получаем адрес клиента
            InetAddress address = packet.getAddress();
            int port = packet.getPort();
            
            //проверяем, может пришло сообщение закрыть сервер
            String received
                    = new String(packet.getData(), 0, packet.getLength());
            if (received.equals("end")) {
                break;
            }
            
            //создаем пакет для отправки
            packet = new DatagramPacket(packet.getData(), packet.getLength(), address, port);
            
            //отправляем
            try {
                socket.send(packet);
            } catch (IOException ex) {
                System.err.println(ex);
            }
        }
        socket.close();
    }
    
    public static void main(String[] args) throws SocketException {
        new EchoServer(4545).run();
    }
}
