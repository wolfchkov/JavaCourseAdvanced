/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.wolf.jcadv.lesson5.executors.numintg;

import ch.obermuhlner.math.big.BigDecimalMath;
import com.google.common.base.Stopwatch;
import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Andrey
 */
public class Test {
    
    public static final BigDecimal DEG_180 = new BigDecimal(180);
    

    public static Numericalintegration.InFunction FUNCTION = 
            //sin(x)^2  + cos(x)^2 
            (x) -> {
                return Math.sin(x) * Math.sin(x) + Math.cos(x) * Math.cos(x);
            };
    
    public static void main(String[] args) {
        
        long steps = 10_000_000;
        double start = -1_000_000;
        double stop = 1_000_000;

        SequentialNumericalintegration sequentialNumericalintegration =                 
                new SequentialNumericalintegration(FUNCTION);
        
        System.out.println("Прогрев последовательного расчета интеграла...");
        double integral = sequentialNumericalintegration.calculate(start, stop, steps);
        Stopwatch stopwatch = Stopwatch.createUnstarted();
        
        System.out.println("Считаем последовательно...");
        stopwatch.start();
        integral = sequentialNumericalintegration.calculate(start, stop, steps);
        stopwatch.stop();
        
        System.out.printf("\tИнтеграл равен %f; Расчет занял %s\n",integral, stopwatch.elapsed(TimeUnit.MILLISECONDS));
                
        
        ParallellNumericalintegration parallellNumericalintegration = new ParallellNumericalintegration(FUNCTION);
        System.out.println("Прогрев паралельного расчета интеграла...");
        integral = parallellNumericalintegration.calculate(start, stop, steps);
        
        System.out.println("Считаем паралельного...");
        stopwatch = Stopwatch.createStarted();        
        integral = parallellNumericalintegration.calculate(start, stop, steps);
        stopwatch.stop();        
        System.out.printf("\tИнтеграл равен %f; Расчет занял %s;\n",integral, stopwatch.elapsed(TimeUnit.MILLISECONDS));
        
        parallellNumericalintegration.stop();
        
    }
}
