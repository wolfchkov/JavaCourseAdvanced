/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.wolf.jcadv.lesson8.spring.service;

/**
 *
 * @author Andrey
 */
public class DefaultWelcomeService implements WelcomeService{
    
    private final MessageSender messageSender;

    public DefaultWelcomeService(MessageSender messageSender) {
        this.messageSender = messageSender;
    }

    @Override
    public void welcome() {
        System.out.println("Сервис говорит Привет и отправляет сообщение!");
        messageSender.sendMessage("Привет!");
    }
}
