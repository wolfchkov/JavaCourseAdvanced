/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.wolf.javacourseadv.lesson2.apachecol;

import org.apache.commons.collections4.BidiMap;
import org.apache.commons.collections4.bidimap.DualHashBidiMap;

/**
 * Английско-Русский-Английский словарь реализованный с помощью BiMap
 * @author Andrey
 */
public class Dictionary {

        private static final String[] englishWords = {"one", "two", "three", "ball", "snow"};
        private static final String[] russianWords = {"один", "два", "три", "мяч", "cнег"};

        private static final BidiMap<String, String> DICTIONARY = new DualHashBidiMap<>();

        static {
                for (int i = 0; i < englishWords.length; ++i) {
                        DICTIONARY.put(englishWords[i], russianWords[i]);
                }
        }

        public static void main(String[] args) {
                // Выводим кол-вом вхождений слов
                System.out.println(DICTIONARY);
                // Выводим все уникальные слова
                System.out.println(DICTIONARY.keySet());
                System.out.println(DICTIONARY.values());

                // Выводим перевод по каждому слову
                System.out.println("one = " + DICTIONARY.get("one"));
                System.out.println("two = " + DICTIONARY.get("two"));
                System.out.println("мяч = " + DICTIONARY.getKey("мяч"));
                System.out.println("снег = " + DICTIONARY.getKey("cнег"));
                System.out.println("empty = " + DICTIONARY.get("empty"));

                // Выводим общее количество переводов в словаре
                System.out.println(DICTIONARY.size());
        }

}
