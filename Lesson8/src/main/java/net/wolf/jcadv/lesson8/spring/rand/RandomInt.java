/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.wolf.jcadv.lesson8.spring.rand;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Аннотация для инжекта случайных чисел.
 * 
 * @author Andrey
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface RandomInt {
    
    /**
     * Минимальное число для генерации
     * @return 
     */
    int min() default 0;
    
    /**
     * Максимальное число для генерации
     * @return 
     */
    int max() default Integer.MAX_VALUE;
    
}
