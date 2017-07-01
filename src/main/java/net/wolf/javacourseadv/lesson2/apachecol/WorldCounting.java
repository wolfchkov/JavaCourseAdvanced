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
package net.wolf.javacourseadv.lesson2.apachecol;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import org.apache.commons.collections4.Bag;
import org.apache.commons.collections4.MultiMap;
import org.apache.commons.collections4.bag.HashBag;
import org.apache.commons.collections4.bag.TreeBag;
import org.apache.commons.collections4.map.MultiValueMap;

/**
 *
 * @author Andrey
 */
public class WorldCounting {

        //http://uncyclopedia.wikia.com/wiki/Badger_Badger_Badger
        public static final String SENTENCE = "Badger badgers Badger badgers badger badger Badger badgers";

        public static void countWorlds(Supplier<Bag<String>> bagFactory, String sentence) {

                List<String> words = Arrays.asList(sentence.split(" "));

                Bag<String> bag = bagFactory.get();

                // Заполним Multiset
                for (String word : words) {
                        bag.add(word);
                }

                // Выводим кол-вом вхождений слов
                System.out.println(bag);
                // Выводим все уникальные слова
                System.out.println(bag.uniqueSet());

                // Выводим количество по каждому слову
                System.out.println("Badger = " + bag.getCount("Badger"));
                System.out.println("badgers = " + bag.getCount("badgers"));
                System.out.println("badger = " + bag.getCount("badger"));
                System.out.println("Empty = " + bag.getCount("Empty"));

                // Выводим общее количества всех слов в тексте
                System.out.println(bag.size());

                // Выводим общее количество всех уникальных слов
                System.out.println(bag.uniqueSet().size());
        }

        public static void countWorldsWithIndex(Supplier<MultiMap<String, Integer>> multimapFactory, String sentence) {

                List<String> words = Arrays.asList(sentence.split(" "));

                MultiMap<String, Integer> multiMap = multimapFactory.get();

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
                System.out.println(multiMap.size());

                // Выводим общее количество всех уникальных слов
                System.out.println(multiMap.keySet().size());
        }

        public static void main(String[] args) {
                //значения в произвольном порядке
                System.out.println("==============================HashBag===============================");
                countWorlds(HashBag::new, SENTENCE);

                //значения отсортированы
                System.out.println("===============================TreeBag==============================");
                countWorlds( TreeBag::new, SENTENCE);
                
                System.out.println("===============================MultiValueMap==============================");
                countWorldsWithIndex(MultiValueMap::new, SENTENCE);
                
        }
}

