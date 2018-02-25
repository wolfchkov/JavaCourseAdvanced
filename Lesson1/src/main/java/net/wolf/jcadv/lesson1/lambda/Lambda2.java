/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.wolf.jcadv.lesson1.lambda;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Andrey
 */
public class Lambda2 {

    public static void example1() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        //Секвенциальный подход
        for (int number : numbers) {
            System.out.println(number);
        }
        
        //Вывод через лямбды
        numbers.forEach(System.out::println);
    }
    
    public static void main(String[] args) {
        example1();
    }
}
