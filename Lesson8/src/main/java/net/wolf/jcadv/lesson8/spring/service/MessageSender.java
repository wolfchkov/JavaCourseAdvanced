/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.wolf.jcadv.lesson8.spring.service;

import net.wolf.jcadv.lesson8.spring.rand.RandomInt;

/**
 *
 * @author Andrey
 */
public class MessageSender {    
    
    @RandomInt
    private int randomId;
    
    public void sendMessage(String msg) {
        System.out.printf("%d - отправили сообщение: '%s'%n", randomId, msg);
    }
    
}
