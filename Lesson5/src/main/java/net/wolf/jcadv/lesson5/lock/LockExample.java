/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.wolf.jcadv.lesson5.lock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author Andrey
 */
public class LockExample {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        final ReentrantLock rl = new ReentrantLock();

        class Worker implements Runnable {

            private String name;

            Worker(String name) {
                this.name = name;
            }

            @Override
            public void run() {
                rl.lock();
                try {
                    if (rl.isHeldByCurrentThread()) {
                        System.out.printf("Поток %s вошел в критическую секцию.%n",
                                name);
                    }
                    System.out.printf("Поток %s выполняет работу 3 секунды.%n", name);
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException ie) {
                        ie.printStackTrace();
                    }
                    System.out.printf("Поток %s закончил работу.%n", name);
                } finally {
                    rl.unlock();
                }
            }
        }

        executor.execute(new Worker("A"));
        executor.execute(new Worker("B"));

        try {
            executor.awaitTermination(8, TimeUnit.SECONDS);
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }
        executor.shutdownNow();
    }
}
