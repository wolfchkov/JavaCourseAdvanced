/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.wolf.jcadv.lesson9.services;

import net.wolf.jcadv.lesson9.domain.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 *
 * @author Andrey
 */
@Component
public class DefaultWelcomeService implements WelcomeService{
    
    private final MessageSender messageSender;
    private final MessageRepository messageRepository;


    @Autowired
    public DefaultWelcomeService(@Qualifier("smsMessageSender") MessageSender messageSender, MessageRepository messageRepository) {
        this.messageSender = messageSender;
        this.messageRepository = messageRepository;
    }
    
    

    @Override
    public void welcome() {
        System.out.println("Сервис говорит Привет и отправляет сообщение!");
        messageSender.sendMessage(messageRepository.getMessage());
    }
}
