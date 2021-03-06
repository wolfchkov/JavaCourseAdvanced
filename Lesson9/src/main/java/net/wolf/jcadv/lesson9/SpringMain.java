/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.wolf.jcadv.lesson9;

import net.wolf.jcadv.lesson9.services.WelcomeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

/**
 *
 * @author Andrey
 */
@Configuration
@ComponentScan("net.wolf.jcadv.lesson9")
@PropertySource("classpath:settings.properties")
public class SpringMain {

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfigInDev() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    private static final Logger logger = LoggerFactory.getLogger(SpringMain.class);

    public static void main(String[] args) {
        logger.info("Стартуем контекст Spring...");

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.getEnvironment().setActiveProfiles("prod");
        context.register(SpringMain.class);
        context.refresh();

        WelcomeService welcomeService = context.getBean(WelcomeService.class);

        welcomeService.welcome();
        context.registerShutdownHook();
    }
}
