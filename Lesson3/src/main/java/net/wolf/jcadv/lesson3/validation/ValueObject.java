/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.wolf.jcadv.lesson3.validation;

/**
 *
 * @author Andrey
 */

public class ValueObject {
        
        @PatternCheck(
                value = "[A-Z]+",
                message = "Неверно заданно имя, допустимы только заглавыне буквы")
        private final String name;
        
        @PatternCheck(value = "\\+38[0-9]{10}",
                 message = "Неверно задан номер телефона"
                )
        private final String phone;

        public ValueObject(String name, String phone) {
                this.name = name;
                this.phone = phone;
        }

        public String getName() {
                return name;
        }

        public String getPhone() {
                return phone;
        }
        
}
