/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.wolf.jcadv.lesson8.spring.rand;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.concurrent.ThreadLocalRandom;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.util.ReflectionUtils;

/**
 * BeanPostProcessor который осуществляет инъекцию случайного числа в поля
 * бинов помеченных аннотацией @RandomInt
 * 
 * @author Andrey
 */
public class RandomIntBeanPostProcessor implements BeanPostProcessor {

    private static final Logger logger = LoggerFactory.getLogger(RandomIntBeanPostProcessor.class);

    @Override
    public Object postProcessBeforeInitialization(final Object bean, final String beanName) throws BeansException {

        logger.debug("postProcessBeforeInitialization::beanName = {}, beanClass = {}", beanName, bean.getClass().getSimpleName());

        ReflectionUtils.doWithFields(bean.getClass(),
                (field) -> {
                        field.setAccessible(true);
                        RandomInt annotation = field.getAnnotation(RandomInt.class);
                        ReflectionUtils.setField(field, bean, ThreadLocalRandom.current().nextInt(annotation.min(), annotation.max()));
                }, this::isFieldMarkedRandomInt);
        ReflectionUtils.doWithMethods(bean.getClass(),
                (method) -> {                        
                        RandomInt annotation = method.getAnnotation(RandomInt.class);
                        ReflectionUtils.invokeMethod(method, bean, ThreadLocalRandom.current().nextInt(annotation.min(), annotation.max()));
                }, this::isMethodMarkedRandomInt);
        return bean;
    }

    private boolean isFieldMarkedRandomInt(Field field) {
        return field.isAnnotationPresent(RandomInt.class);
    }
    
    private boolean isMethodMarkedRandomInt(Method method) {
        return method.isAnnotationPresent(RandomInt.class);
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

}
