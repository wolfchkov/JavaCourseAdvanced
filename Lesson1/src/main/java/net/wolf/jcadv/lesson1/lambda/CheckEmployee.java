/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.wolf.jcadv.lesson1.lambda;

/**
 * Интерфейс с контрактом предиката для сотрудника
 * @author Andrey
 */
@FunctionalInterface
public interface CheckEmployee {
                
        /**
         *  Метод выполнаяющий предикат для сотруднка
         * @param empl сотрудник для предиката
         * @return true или false
         */
        boolean test(Employee empl);
        
}
