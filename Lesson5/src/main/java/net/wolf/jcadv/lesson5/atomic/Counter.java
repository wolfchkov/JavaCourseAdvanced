/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.wolf.jcadv.lesson5.atomic;

import com.google.common.base.Stopwatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/**
 *
 * @author Andrey
 */
public class Counter {

    private long count;

    public Counter() {
        this(0);
    }

    public Counter(long count) {
        this.count = count;
    }

    public synchronized long getCount() {
        return count;

    }

    public synchronized void inc() {
        count++;
    }

    public synchronized void dec() {
        count--;
    }
    
    public static void main(String[] args) {
        
        final long COUNT = 1_000_000_000;
        
        int threadsCount = Runtime.getRuntime().availableProcessors();
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(100, 100, 1, TimeUnit.DAYS, 
                        new LinkedBlockingQueue<>());
        
        final Counter counterSync = new Counter();
        final AtomicLong counterAtomic = new AtomicLong();
        
        Runnable counterSRun = () -> {
            while(counterSync.getCount() < COUNT) {
                counterSync.inc();
            }
        };
        Runnable counteraARun = () -> {            
            while(counterAtomic.incrementAndGet() < COUNT) {                
            }
        };
         
        Stopwatch sw = Stopwatch.createUnstarted();
        
        sw.start();
        for (int i = 0; i < threadsCount; ++i) {
            poolExecutor.submit(counterSRun);
        }
        while(poolExecutor.getActiveCount() != 0) {
            Thread.yield();
        }
        sw.stop();
        
        System.out.println("take " + sw.elapsed(TimeUnit.MILLISECONDS));
        System.out.println("counterSync " + counterSync.getCount());
        
        
        sw.reset();
        
        sw.start();
        for (int i = 0; i < threadsCount; ++i) {
            poolExecutor.submit(counteraARun);
        }
        while(poolExecutor.getActiveCount() != 0) {
            Thread.yield();
        }
        sw.stop();
        
        System.out.println("take " + sw.elapsed(TimeUnit.MILLISECONDS));
        System.out.println("counterSync " + counterAtomic.get());
        
         poolExecutor.shutdown();
                
    }
}
