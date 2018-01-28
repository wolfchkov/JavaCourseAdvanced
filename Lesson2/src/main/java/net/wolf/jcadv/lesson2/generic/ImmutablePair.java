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

/**
 *
 * @author Andrey
 */
public class ImmutablePair <K, V> implements Pair<K, V> {

        private final K key;
        private final V value;

        public ImmutablePair(K key, V value) {
                this.key = key;
                this.value = value;
        }

        @Override
        public K getKey() {
                return key;
        }

        @Override
        public V getValue() {
                return value;
        }
        
        public static void main(String[] args) {
                Pair<String, Integer> p1 = new ImmutablePair<>("Eight", 8);
                Pair<String, String>  p2 = new ImmutablePair<>("hello", "world");
                
                ImmutablePair<String, Box<Integer>> p = new ImmutablePair<>("primes", new Box<Integer>());
        }
        
}
