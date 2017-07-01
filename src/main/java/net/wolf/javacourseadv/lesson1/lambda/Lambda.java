/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.wolf.javacourseadv.lesson1.lambda;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 *
 * @author Andrey
 */
public class Lambda {

        /**
         * Вывести на экран сотрдников для которх предикат возвращает истину
         *
         * @param empls - список сотрудников
         * @param tester - реализация предиката
         */
        public static void printPersonsWithPredicate(List<Employee> empls, Predicate<Employee> tester) {
                for (Employee e : empls) {
                        if (tester.test(e)) {
                                e.print();
                        }
                }
        }

        /**
         * Применить действие к сотрдникам, для которх предикат возвращает
         * истину
         *
         * @param empls - список сотрудников
         * @param tester - реализация предиката
         * @param action - реализация действия
         */
        public static void processPersons(List<Employee> empls, Predicate<Employee> tester, Consumer<Employee> action) {
                for (Employee e : empls) {
                        if (tester.test(e)) {
                                action.accept(e);
                        }
                }
        }

        /**
         * Применить действие к струковому полю сотрдникков, для которх предикат
         * возвращает истину. Строковое поле определяется в mapper.
         *
         * @param empls - список сотрудников
         * @param tester - реализация предиката
         * @param mapper - реализация получения строкового поля сотрудника
         * @param action - реализация действия
         */
        public static void processPersonsWithFunction(List<Employee> empls, Predicate<Employee> tester,
                Function<Employee, String> mapper, Consumer<String> action) {
                for (Employee e : empls) {
                        if (tester.test(e)) {
                                String data = mapper.apply(e);
                                action.accept(data);
                        }
                }
        }

        /**
         * Универсальный метод с алгоритмом обхода итератора по X, 
         * фильтрацией по предикате  X, мапингом  X с помощью функции в Y
         * и применением действия к  Y-результату  функции.
         * @param <X>
         * @param <Y>
         * @param source
         * @param tester
         * @param mapper
         * @param block 
         */
        public static <X, Y> void processElements(
                Iterable<X> source,
                Predicate<X> tester,
                Function<X, Y> mapper,
                Consumer<Y> block) {
                for (X p : source) {
                        if (tester.test(p)) {
                                Y data = mapper.apply(p);
                                block.accept(data);
                        }
                }
        }

        /**
         * @param args the command line arguments
         */
        public static void main(String[] args) {
                // TODO code application logic here
        }

}
