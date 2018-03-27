/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.wolf.jcadv.lesson8.spring;

import net.wolf.jcadv.lesson8.spring.service.WelcomeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author Andrey
 */
public class SpringMain {

    private static final Logger logger = LoggerFactory.getLogger(SpringMain.class);

    public static void main(String[] args) {
        logger.info("Стартуем контекст Spring...");

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SimpleConfiguration.class);
        
        WelcomeService welcomeService = context.getBean(WelcomeService.class);
        
        welcomeService.welcome();        
    }
}
