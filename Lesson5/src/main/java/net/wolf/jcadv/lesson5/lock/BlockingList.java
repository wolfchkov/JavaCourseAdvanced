/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.wolf.jcadv.lesson5.lock;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author Andrey
 */
public class BlockingList<T> {

    private final List<T> list;
    
    private final ReentrantLock lock;
    private final Condition condition;

    public BlockingList() {        
        this.list = new ArrayList<>();
        this.lock = new ReentrantLock(true);
        this.condition = lock.newCondition();
    }

    public void add(T value) {
        lock.lock();    
        
        try {
        
            list.add(value);            
            condition.signalAll();           
        }finally {
            lock.unlock();
        }        
    }

    public T get() throws InterruptedException {
        lock.lock();
        
        try {
            
            if (list.isEmpty()) {
                condition.await();
            }
            
            return list.remove(0);
            
        }finally {
            lock.unlock();
        }                     
    }

    public static void main(String[] args) {
        
        final BlockingList<Integer> blockingList = new BlockingList<>();

        Thread reader = new Thread() {
            @Override
            public void run() {
                while (true) {
                    try {
                        System.out.printf("В очереди появилось число %d %n", blockingList.get());
                    } catch (InterruptedException ex) {
                        return;
                    }
                }
            }
        };
        reader.start();

        Thread writer = new Thread() {
            @Override
            public void run() {
                while (true) {

                    int num = ThreadLocalRandom.current().nextInt();
                    System.out.printf("Положим число %d %n", num);
                    blockingList.add(num);
                    try {
                        Thread.sleep(ThreadLocalRandom.current().nextInt(500, 3000));
                    } catch (InterruptedException ex) {
                        return;
                    }
                }
            }
        };
        writer.start();

        Thread writer2 = new Thread() {
            @Override
            public void run() {
                while (true) {

                    int num = ThreadLocalRandom.current().nextInt();
                    System.out.printf("Положим число %d %n", num);
                    blockingList.add(num);
                    try {
                        Thread.sleep(ThreadLocalRandom.current().nextInt(500, 3000));
                    } catch (InterruptedException ex) {
                        return;
                    }
                }
            }
        };
        writer2.start();
    }

}
