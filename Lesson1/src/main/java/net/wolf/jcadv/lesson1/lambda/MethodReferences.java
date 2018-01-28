/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.wolf.jcadv.lesson1.lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Примеры ссылок на методы
 *
 * @author Andrey
 */
public class MethodReferences {

        public static void toArbitraryObjOfParticularType() {
                String[] stringArray = {"Barbara", "James", "Mary", "John",
                        "Patricia", "Robert", "Michael", "Linda"};
                Arrays.sort(stringArray, String::compareToIgnoreCase);
                System.out.println(Arrays.toString(stringArray));
        }

        static class ComparisonProvider {

                public int compareByName(Employee a, Employee b) {
                        return a.getName().compareTo(b.getName());
                }

                public int compareByAge(Employee a, Employee b) {
                        return a.getBirthday().compareTo(b.getBirthday());
                }
        }

        public static void main(String[] args) {
                ComparisonProvider myComparisonProvider = new ComparisonProvider();
                List<Employee> empoyees = Employee.getEmpoyees();
                                System.out.println(empoyees);
                Collections.sort(empoyees, myComparisonProvider::compareByName);
                System.out.println(empoyees);
        }
}
