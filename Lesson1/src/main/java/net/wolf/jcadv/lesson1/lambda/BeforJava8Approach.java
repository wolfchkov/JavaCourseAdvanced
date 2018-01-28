/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.wolf.jcadv.lesson1.lambda;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

/**
 * Решение задач по сотрудникам до java 8
 *
 * @author Andrey
 */
public class BeforJava8Approach {

        /**
         * Вывести на экран сотрдников старше либо равных,определенного возраста
         *
         * @param empls - список сотрудников
         * @param age - возраст, страшле либо ровно которому вывести сотрудников
         */
        public static void printEmplsOlderThan(List<Employee> empls, int age) {
                for (Employee e : empls) {
                        if (e.getAge() >= age) {
                                e.print();
                        }
                }
        }

        /**
         * Вывести на экран сотрдников которые старше (включительно) и младше
         * заданных возрастов
         *
         * @param empls - список сотрудников
         * @param low - нижняя граница возраста (включительно)
         * @param high - верхняя граница возраста
         */
        public static void printEmplsWithinAgeRange(
                List<Employee> empls, int low, int high) {
                for (Employee e : empls) {
                        if (low <= e.getAge() && e.getAge() < high) {
                                e.print();
                        }
                }
        }

        /**
         * Вывести на экран сотрдников для которх предикат возвращает истину
         *
         * @param empls - список сотрудников
         * @param tester - реализация предиката
         */
        public static void printPersons(List<Employee> empls, CheckEmployee tester) {
                for (Employee e : empls) {
                        if (tester.test(e)) {
                                e.print();
                        }
                }
        }

        public static void main(String[] args) {

        }
}
