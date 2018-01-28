/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.wolf.jcadv.lesson5.executors.numintg;

/**
 * Последовательное решение интегралла
 * @author Andrey
 */
public class SequentialNumericalintegration extends Numericalintegration {
    
    public SequentialNumericalintegration(InFunction function) {
        super(function);
    }
            
    public double calculate(double start, double stop, long steps) {
        double step = Math.abs(stop - start) / steps;
        return super.calculate(start, stop, step);
    }
}
