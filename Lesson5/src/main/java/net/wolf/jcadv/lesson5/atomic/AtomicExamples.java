/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.wolf.jcadv.lesson5.atomic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author Andrey
 */
public class AtomicExamples {

    public static class Counter {

        private final AtomicInteger value = new AtomicInteger();

        public int getValue() {
            return value.get();
        }

        public int increment() {
            int readValue = value.get();
            while (!value.compareAndSet(readValue, readValue + 1)) {
                readValue = value.get();
            }
            return readValue + 1;
        }
    }
    
    public static void main(String[] args) throws InterruptedException {
        final Counter counter = new Counter();
        Runnable count = () -> {
            for(int i = 0; i < 1000; ++i) 
                counter.increment();
        };
        
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; ++i) {
            executorService.submit(count);
        }
        
        Thread.sleep(2000);
        
        System.out.println("Счетчик: " + counter.getValue());
        
        executorService.shutdown();
    }
}
