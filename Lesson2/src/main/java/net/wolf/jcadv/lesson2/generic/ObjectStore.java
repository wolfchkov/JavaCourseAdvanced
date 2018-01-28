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

import java.util.Collection;
import java.util.Map;
import java.util.function.Predicate;

/**
 *
 * @author Andrey
 */
public interface ObjectStore<K, V> {

        /**
         * Кладёт значение в хранилище по заданному ключу.
         *
         * @param key Ключ.
         * @param value Значение.
         */
        void put(K key, V value);

        /**
         * Читает значение из хранилища по заданному ключу.
         *
         * @param key Ключ.
         * @return Значение либо null.
         */
        V get(K key);

        /**
         * Кладёт все пары ключ-значение в хранилище.
         *
         * @param entries Набор пар ключ-значение.
         */
        void putAll(Map<K, V> entries);

        /**
         * Читает все значения из хранилища по заданным ключам.
         *
         * @param keys Набор ключей.
         * @return Пары ключ-значение.
         */
        Map<K, V> getAll(Collection<K> keys);

        /**
         * Читает из хранилища все значения, удовлетворяющие заданному условию
         * (предикату).
         *
         * @param p Предикат для проверки значений.
         * @return Значения, удовлетворяющие предикату.
         */
        Collection<V> getAll(Predicate<? super V> p);

}
