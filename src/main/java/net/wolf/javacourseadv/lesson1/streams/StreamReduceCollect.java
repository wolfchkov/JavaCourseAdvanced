/*
 * The MIT License
 *
 * Copyright 2017 Andrey.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package net.wolf.javacourseadv.lesson1.streams;

import java.util.List;
import java.util.Map;
import java.util.function.IntConsumer;
import java.util.stream.Collectors;
import net.wolf.javacourseadv.lesson1.lambda.Employee;

/**
 *
 * @author Andrey
 */
public class StreamReduceCollect {

        static public void reduce() {
                Integer totalAge = Employee.getEmpoyees()
                        .stream()
                        .mapToInt(Employee::getAge)
                        .sum();

                System.out.println("totalAge: " + totalAge);

                totalAge = Employee.getEmpoyees()
                        .stream()
                        .mapToInt(Employee::getAge)
                        .reduce(0, (a, b) -> a + b);
                System.out.println("totalAge: " + totalAge);
        }

        public static class Averager implements IntConsumer {

                private int total = 0;
                private int count = 0;

                public double average() {
                        return count > 0 ? ((double) total) / count : 0;
                }

                public void accept(int i) {
                        total += i;
                        count++;
                }

                public void combine(Averager other) {
                        total += other.total;
                        count += other.count;
                }
        }

        public static void сollector() {
                Averager averageCollect = Employee.getEmpoyees()
                        .stream()
                        .filter(у -> у.getGender() == Employee.Sex.MALE)
                        .map(Employee::getAge)
                        .collect(Averager::new, Averager::accept, Averager::combine);

                System.out.println("Средний возраст мужчин в фирме: "
                        + averageCollect.average());
        }

        public static void сollectorGroupBy() {
                Map<Employee.Sex, List<Employee>> byGender
                        = Employee.getEmpoyees()
                                .stream()
                                .collect(
                                        Collectors.groupingBy(Employee::getGender));

                System.out.println(byGender);
        }

        public static void main(String[] args) {
                reduce();

                //                Employee.getEmpoyees()
//                        .stream()
//                        .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
        }
}
