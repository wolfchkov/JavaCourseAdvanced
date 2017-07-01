/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.wolf.javacourseadv.lesson1.lambda;

/**
 * Интерфейс с контрактом предиката для сотрудника
 * @author Andrey
 */
public interface CheckEmployee {
                
        /**
         *  Метод выполнаяющий предикат для сотруднка
         * @param empl сотрудник для предиката
         * @return true или false
         */
        boolean test(Employee empl);
        
}
