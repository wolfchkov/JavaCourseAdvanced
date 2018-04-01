/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.wolf.jcadv.lesson8.spring;

import net.wolf.jcadv.lesson8.spring.rand.RandomIntBeanPostProcessor;
import net.wolf.jcadv.lesson8.spring.service.DefaultMessageSender;
import net.wolf.jcadv.lesson8.spring.service.DefaultWelcomeService;
import net.wolf.jcadv.lesson8.spring.service.MessageSender;
import net.wolf.jcadv.lesson8.spring.service.WelcomeService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Конфигурационный класс Spring IoC контейнера
 * 
 * @author Andrey
 */
@Configuration
public class SimpleConfiguration {
    
    @Bean
    public MessageSender messageSender() {
        return new DefaultMessageSender();
    }
    
    @Bean
    public WelcomeService welcomeService(DefaultMessageSender messageSender) {
        return new DefaultWelcomeService(messageSender);
    }
    
    @Bean
    public RandomIntBeanPostProcessor randomIntBeanPostProcessor() {
        return new RandomIntBeanPostProcessor();
    }
    
}
