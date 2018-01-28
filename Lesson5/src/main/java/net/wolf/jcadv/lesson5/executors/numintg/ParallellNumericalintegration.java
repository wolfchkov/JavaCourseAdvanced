/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.wolf.jcadv.lesson5.executors.numintg;

import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * Паралельное решение интегралла
 * @author Andrey
 */
public class ParallellNumericalintegration extends Numericalintegration {

    private static final int PROCESSORS_COUNT = Runtime.getRuntime().availableProcessors();

    public final CompletionService completionService;
    public final ExecutorService executorService;

    public ParallellNumericalintegration(InFunction function) {
        super(function);
        this.executorService = Executors.newFixedThreadPool(PROCESSORS_COUNT);
        this.completionService = new ExecutorCompletionService(this.executorService);
    }

    public double calculate(double start, double stop, long steps) {
        final double calcRange = (stop - start) / (double) PROCESSORS_COUNT;

        final double step = Math.abs(stop - start) / steps;

        double s = start;
        Numericalintegration partialNI = new Numericalintegration(function) {
        };
        for (int i = 0; i < PROCESSORS_COUNT; ++i) {
            final double pStart = s;
            final double pEnd = s + calcRange;
            completionService.submit(() -> partialNI.calculate(pStart, pEnd, step));
            s = pEnd;
        }

        double res = 0d;
        for (int i = 0; i < PROCESSORS_COUNT; ++i) {
            try {
                Future<Double> partRes = completionService.take();
                res += partRes.get();
            } catch (InterruptedException | ExecutionException ex) {
                ex.printStackTrace();
            }
        }
        return res;
    }

    public void stop() {
        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(10, TimeUnit.SECONDS)) {
                executorService.shutdownNow();
                if (!executorService.awaitTermination(60, TimeUnit.SECONDS)) {
                    System.err.println("Пул потоков не остановлено!!!");
                }
            }
        } catch (InterruptedException ie) {
            executorService.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }

}
