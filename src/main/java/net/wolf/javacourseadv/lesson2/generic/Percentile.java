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
package net.wolf.javacourseadv.lesson2.generic;

import java.util.Arrays;

/**
 *
 * @author Andrey
 */
public class Percentile<T> {
        
        private final float percent;

        public Percentile(int percentile) {
                this.percent = percentile / 100f;
        }
        
        public T find(T[] values) {
                Arrays.sort(values);
                int index = Math.round(values.length * percent);
                return values[index];
        }
        
        
        public static void main(String[] args) {
                Integer[] numbers = {10,546,34,234,23423,1,44,55,66,66,66,445,334,4545};
                
                Percentile<Integer> percentile = new Percentile<>(20);
                System.out.println(percentile.find(numbers));
        }
}
