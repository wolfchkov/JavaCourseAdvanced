/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.wolf.jcadv.lesson8.spring.service;

import javax.annotation.PostConstruct;
import net.wolf.jcadv.lesson8.spring.rand.RandomInt;

/**
 *
 * @author Andrey
 */
public class DefaultMessageSender implements MessageSender {    
        
    private int randomId;

    @RandomInt
    @PostConstruct
    public void setRandomId(int randomId) {
        this.randomId = randomId;
    }
    
    @Override
    public void sendMessage(String msg) {
        System.out.printf("%d - отправили сообщение: '%s'%n", randomId, msg);
    }
    
}
