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
package net.wolf.jcadv.lesson2.jdkcol;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 *
 * @author Andrey
 */
public class SubList {

        /**
         * Плохо! Забыли/незнали про subList
         *
         * @param list
         * @param from
         * @param to
         */
        void processListPart(List<Integer> list, int from, int to) {
                for (int idx = from; idx < to; idx++) {
                        Integer num = list.get(idx);
                        System.out.println(num);
                }
        }

        /**
         * Просто передаем list.subList(from, to)
         */
        void processListPart(List<Integer> list) {
                for (Integer num : list) {
                        System.out.println(num);
                }
        }

        public static <T extends Comparable<T>> List<T> leastN(Collection<T> input, int n) {
                // создаем очеред приоритетов с сортировкой по убыванию 
                PriorityQueue<T> pq = new PriorityQueue<>(Collections.reverseOrder());
                
                
                for (T t : input) {
                        
                        if (pq.size() < n) {
                                //если не заполнили очередь количество первых N элементов - заполняем
                                pq.add(t);
                        } else if (pq.peek().compareTo(t) > 0) {
                                //если наш хвост больше текущего элемента, вытесняем элемент в хвосте 
                               
                                pq.poll();
                                //и добавлеем очередной 
                                pq.add(t);
                        }
                }
                
                List<T> list = new ArrayList<>(pq);
                
                Collections.sort(list);
                
                return list;
        }
        
        public static void leastNExsample() {
                ThreadLocalRandom rand = ThreadLocalRandom.current();
                final int size = 10_000_000;
                final int leastN = 10;
                

                
                ArrayList<Integer> numbers = IntStream.range(0, size + 1)
                        .map((i) -> rand.nextInt())
                        .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
                
                ArrayList<Integer> copy = new ArrayList<>(numbers);
                long st = System.nanoTime();
                Collections.sort(copy);
                List<Integer> result = copy.subList(0, leastN);
                long time = System.nanoTime() - st;                                                                
                System.out.println(result + " takes " + time + " nanos");
                
                st = System.nanoTime();
                List<Integer> result2 = leastN(numbers, leastN);
                time = System.nanoTime() - st;                                                                
                System.out.println(result2 + " takes " + time + " nanos");
                
                
        }

        public static void main(String[] args) {
                List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16));

                //нужно удалить часть списка? легко
                numbers.subList(5, 10).clear();
                System.out.println(numbers);

                //начинается ли список с определённых элементов?
                System.out.println(numbers.subList(0, 3).equals(Arrays.asList(1, 2, 3)));

                //нужно вставить в список часть элементов другого списка?
                numbers.addAll(Arrays.asList(-1, -2, -3).subList(2, 3));
                System.out.println(numbers);
                
                leastNExsample();

        }
}
