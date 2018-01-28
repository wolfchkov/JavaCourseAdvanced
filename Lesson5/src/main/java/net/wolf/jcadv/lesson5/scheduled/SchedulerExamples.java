/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.wolf.jcadv.lesson5.scheduled;

import java.time.LocalDateTime;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Andrey
 */
public class SchedulerExamples {

    static void println(String str) {
        System.out.println(Thread.currentThread().getName() + " =>" + str);
    }

    public static void main(String[] args) {
        ScheduledExecutorService scheduledThreadPool
                = Executors.newScheduledThreadPool(10);

        //выполним печать через 5 минут
        scheduledThreadPool.schedule(
                () -> println("Выполнили через 5 секунд."),
                5, TimeUnit.SECONDS);

        //будем печатать каждую секунду
        scheduledThreadPool.scheduleAtFixedRate(() -> println("Время: " + LocalDateTime.now()),
                0, 1, TimeUnit.SECONDS);

        //будем печатать с задержкой 0,5 секунды
        scheduledThreadPool.scheduleWithFixedDelay(
                () -> {
                    println("Текущее время: " + LocalDateTime.now());
                    try {
                        //заснем на 0,5 секунды
                        Thread.sleep(500);
                    } catch (InterruptedException ex) {

                    }
                },
                0, 500, TimeUnit.MILLISECONDS );

    }
}
