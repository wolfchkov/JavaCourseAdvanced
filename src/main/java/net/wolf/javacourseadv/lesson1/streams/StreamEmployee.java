/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.wolf.javacourseadv.lesson1.streams;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import net.wolf.javacourseadv.lesson1.lambda.Employee;

/**
 *
 * @author Andrey
 */
public class StreamEmployee {
        
        public static void withoutStreams() {
                
                Set<String> names = new HashSet<>();                
                for (Employee e : Employee.getEmpoyees()) {
                        if (e.getAge()  >= 30) {
                                names.add(e.getName());                        
                        }
                }
                
                List<String> ordered = new ArrayList<>(names);
                Collections.sort(ordered, new Comparator<String>(){
                        @Override
                        public int compare(String o1, String o2) {
                                return o1.compareToIgnoreCase(o2);
                        }
                });
                
                for (String name : ordered) {
                        System.out.println(name);
                }                
        }

        public static void print() {
                for (Employee e : Employee.getEmpoyees()) {
                        System.out.println(e.getName());
                }
        }

        public static void avgAge() {
                double average = Employee.getEmpoyees()
                        .stream()
                        .filter(p -> p.getGender() == Employee.Sex.MALE)
                        .mapToDouble(Employee::getAge)
                        .average()
                        .getAsDouble();
                
                System.out.println("average age: "  + average);
        }

        public static void main(String[] args) {
                //withoutStreams();
        }
}
