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
public class WelcomeService {
    
    private final MessageSender messageSender;

    public WelcomeService(MessageSender messageSender) {
        this.messageSender = messageSender;
    }

    public void welcome() {
        System.out.println("Сервис говорит Привет и отправляет сообщение!");
        messageSender.sendMessage("Привет!");
    }
}
