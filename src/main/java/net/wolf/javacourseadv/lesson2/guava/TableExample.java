/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.wolf.javacourseadv.lesson2.guava;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;

/**
 * Пример работы с таблицей Guava - Table
 * @author Andrey
 */
public class TableExample {

        public static void main(String args[]) {

                //создадим таблицу
                //<Дата рождения, Имя, Возраст>
                Table<LocalDate, String, BigDecimal> personTable = HashBasedTable.create();

                personTable.put(LocalDate.of(1985, Month.MARCH, 15), "Вася", BigDecimal.valueOf(5250.50));
                personTable.put(LocalDate.of(1992, Month.JANUARY, 15), "Петя", BigDecimal.valueOf(8150.50));
                personTable.put(LocalDate.of(1982, Month.JUNE, 15), "Коля", BigDecimal.valueOf(3250.50));
                personTable.put(LocalDate.of(1985, Month.MARCH, 15), "Ира", BigDecimal.valueOf(15250.50));
                personTable.put(LocalDate.of(1985, Month.MARCH, 15), "Света", BigDecimal.valueOf(12250.50));
                personTable.put(LocalDate.of(2000, Month.APRIL, 15), "Саша", BigDecimal.valueOf(25250.50));
                personTable.put(LocalDate.of(2000, Month.AUGUST, 15), "Вова", BigDecimal.valueOf(21150.50));
                personTable.put(LocalDate.of(2000, Month.JUNE, 15), "Вася", BigDecimal.valueOf(5000.15));
                personTable.put(LocalDate.of(2000, Month.FEBRUARY, 15), "Витя", BigDecimal.valueOf(5050.00));
                personTable.put(LocalDate.of(2000, Month.FEBRUARY, 15), "Андрей", BigDecimal.valueOf(7255.13));
                personTable.put(LocalDate.of(1985, Month.MARCH, 15), "Петя", BigDecimal.valueOf(5250.5));
                personTable.put(LocalDate.of(2015, Month.MARCH, 15), "Вася", BigDecimal.valueOf(5350.5));
                        
                //Ввыведем всю карту
                System.out.println(personTable);
                                
                //Посмотрим на вью - все кто родились 1985-03-15
                System.out.println(
                        personTable.row(LocalDate.of(1985, Month.MARCH, 15))
                );
                
                //Посмотрим на вью - все кто родились 2000-02-15
                System.out.println(
                        personTable.row(LocalDate.of(2000, Month.FEBRUARY, 15))
                );
                
                //Посмотрим на вью - у кого имя Вася
                 System.out.println(
                        personTable.column("Вася")
                );
                
                //Посмотрим на вью - у кого имя Петя
                System.out.println(
                        personTable.column("Петя")
                );
                
                 //Посмотрим на уникальные значения колонок
                System.out.println(
                        personTable.columnKeySet()
                );
                
                //Посмотрим на уникальные значения строк
                System.out.println(
                        personTable.rowKeySet()
                );
                
                //так как вы возращаем вью, удалями все колонки c именем Вася
                personTable.column("Вася").clear();
                
                 //Ввыведем всю карту
                System.out.println(personTable);
                                

        }
}
