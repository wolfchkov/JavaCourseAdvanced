/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.wolf.jcadv.lesson4.ip;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

/**
 *
 * @author Andrey
 */

public class InetAdressExsample {
    
    
    public static void main(String[] args) throws UnknownHostException {
        /**
         * Получить локальный IP-адрес
         */
        System.out.println(InetAddress.getLocalHost());
        
        /**
         * Получить адрес google по его имени
         */
        System.out.println(InetAddress.getByName("google.com"));
        System.out.println(InetAddress.getByName("google.com.ua"));
        
        /**
         * Получить все адреса
         */
        System.out.println(
                Arrays.toString(InetAddress.getAllByName("nba.com"))
        );
        
    }
}
