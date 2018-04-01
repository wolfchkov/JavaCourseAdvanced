/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.wolf.jcadv.lesson9.services;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 *
 * @author Andrey
 */
@Component
@Qualifier("emailMessageSender")
public class EmailMessageSender implements MessageSender {    
        
    @Override
    public void sendMessage(String msg) {
        System.out.printf("Отправили сообщение по email: '%s'%n", msg);
    }
    
}
