/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.wolf.jcadv.lesson9.services;

import net.wolf.jcadv.lesson9.SpringMain;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.context.event.ContextStoppedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 *
 * @author Andrey
 */
@Component
public class AllEventsListener {

    private static final Logger logger = LoggerFactory.getLogger(SpringMain.class);

    @EventListener
    public void handleContextRefreshed(ContextRefreshedEvent event) {
        logger.info("Контекст обновлен: {}", event);
    }

    @EventListener
    public void handleContextStarted(ContextStartedEvent event) {
        logger.info("Контекст запущен: {}", event);
    }

    @EventListener
    public void handleContextStopped(ContextStoppedEvent event) {
        logger.info("Контекст остановлен: {}", event);
    }

    @EventListener
    public void handleContextClosed(ContextClosedEvent event) {
        logger.info("Контекст закрыт: {}", event);
    }

}
