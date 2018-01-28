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
package net.wolf.jcadv.lesson2.guava;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.HashMultiset;
import com.google.common.collect.LinkedHashMultimap;
import com.google.common.collect.LinkedHashMultiset;
import com.google.common.collect.LinkedListMultimap;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multiset;
import com.google.common.collect.TreeMultimap;
import com.google.common.collect.TreeMultiset;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

/**
 *
 * @author Andrey
 */
public class WorldCounting {

        //http://uncyclopedia.wikia.com/wiki/Badger_Badger_Badger
        public static final String SENTENCE = "Badger badgers Badger badgers badger badger Badger badgers";

        public static void countWorlds(Supplier<Multiset<String>> multisetFactory, String sentence) {

                List<String> words = Arrays.asList(sentence.split(" "));

                Multiset<String> multiset = multisetFactory.get();

                // Заполним Multiset
                for (String word : words) {
                        multiset.add(word);
                }

                // Выводим кол-вом вхождений слов
                System.out.println(multiset);
                // Выводим все уникальные слова
                System.out.println(multiset.elementSet());

                // Выводим количество по каждому слову
                System.out.println("Badger = " + multiset.count("Badger"));
                System.out.println("badgers = " + multiset.count("badgers"));
                System.out.println("badger = " + multiset.count("badger"));
                System.out.println("Empty = " + multiset.count("Empty"));

                // Выводим общее количества всех слов в тексте
                System.out.println(multiset.size());

                // Выводим общее количество всех уникальных слов
                System.out.println(multiset.elementSet().size());
        }

        public static void countWorldsWithIndex(Supplier<Multimap<String, Integer>> multimapFactory, String sentence) {

                List<String> words = Arrays.asList(sentence.split(" "));

                Multimap<String, Integer> multiMap = multimapFactory.get();

                // Заполним Multimap
                int i = 0;
                for (String word : words) {
                        multiMap.put(word, i);
                        i++;
                }

                // Выводим все вхождения слов в текст
                System.out.println(multiMap); 
                // Выводим все уникальные слова
                System.out.println(multiMap.keySet()); 

                // Выводим все индексы вхождения слова в текст
                System.out.println("Badger = " + multiMap.get("Badger"));
                System.out.println("badgers = " + multiMap.get("badgers"));
                System.out.println("badger = " + multiMap.get("badger"));
                System.out.println("Empty = " + multiMap.get("Empty"));

                // Выводим общее количества всех слов в тексте
                System.out.println(multiMap.size()); //напечатает 6

                // Выводим общее количество всех уникальных слов
                System.out.println(multiMap.keySet().size()); //напечатает 4
        }

        public static void main(String[] args) {
                //значения в произвольном порядке
                System.out.println("==============================HashMultiset===============================");
                countWorlds(HashMultiset::create, SENTENCE);

                //значения отсортированы
                System.out.println("===============================TreeMultiset==============================");
                countWorlds(TreeMultiset::create, SENTENCE);

                //значения в порядке первого добавления элемента
                System.out.println("===============================LinkedHashMultiset==============================");
                countWorlds(LinkedHashMultiset::create, SENTENCE);
                
                System.out.println("===============================ArrayListMultimap==============================");
                countWorldsWithIndex(ArrayListMultimap::create, SENTENCE);
                
                System.out.println("===============================HashMultimap==============================");
                countWorldsWithIndex(HashMultimap::create, SENTENCE);

                System.out.println("===============================LinkedListMultimap==============================");
                countWorldsWithIndex(LinkedListMultimap::create, SENTENCE);
                
                System.out.println("===============================TreeMultimap==============================");
                countWorldsWithIndex(TreeMultimap::create, SENTENCE);
                
                System.out.println("===============================LinkedHashMultimap==============================");
                countWorldsWithIndex(LinkedHashMultimap::create, SENTENCE);
                
        }
}

