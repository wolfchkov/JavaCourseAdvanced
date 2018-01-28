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
package net.wolf.jcadv.lesson2.generic;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 *
 * @author Andrey
 */
public class Wildcards {

        public static void printList(List<Object> list) {
                for (Object elem : list) {
                        System.out.println(elem + " ");
                }
                System.out.println();
        }

        public static double sumOfList(List<? extends Number> list) {
                double s = 0.0;
                for (Number n : list) {
                        s += n.doubleValue();
                }
                return s;
        }

        public static void addNumbers(List<? super Integer> list) {
                for (int i = 1; i <= 10; i++) {
                        list.add(i);
                }
        }

        public static void main(String[] args) {
                List<Integer> numbers = Arrays.asList(10, 20, 40, 50);
                //printList(numbers); //проблема, может печатать только список Object'ов

                Predicate<Vehicle> speedBound = (Vehicle v) -> v.getSpeed() > 90.0f;

                ObjectStore<String, Car> objectStore = null;
                objectStore.getAll(speedBound);

        }

}
