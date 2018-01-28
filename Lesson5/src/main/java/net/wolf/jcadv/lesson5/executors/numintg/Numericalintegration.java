/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.wolf.jcadv.lesson5.executors.numintg;

import java.math.MathContext;

/**
 * Общий класс для расчета интегралла методом прямоугольников
 * @author Andrey
 */
public abstract class Numericalintegration {
    
    public static final MathContext DECIMAL_CONTEXT = MathContext.DECIMAL128;
    
    protected final InFunction function;

    public Numericalintegration(InFunction function) {
        this.function = function;
    }
    
    public double calculate(double start, double stop, double step) {
        double res = 0.0d;
        double x = start;        
        while (x < stop) {
            res += step * function.apply(x);
            x += step;
        }
        return res;        
    }

    @FunctionalInterface
    public static interface InFunction {
        
        public double apply(double x);
    }
    
}
