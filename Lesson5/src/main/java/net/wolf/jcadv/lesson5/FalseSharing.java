/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.wolf.jcadv.lesson5;

import java.text.DecimalFormat;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author Andrey
 */
public class FalseSharing {
    
    static volatile boolean isRun = true;
    static DecimalFormat F = new DecimalFormat("###,###,###,###,###,###,###");
    
    
    
    public static class Counter {
        private long c1;
        //private long n11,n12,n13,n14,n15,n16,n17;
        private long c2;
        //private long n21,n22,n23,n24,n25,n26,n27;
        private long c3;
        //private long n31,n32,n33,n34,n35,n36,n37;
        private long c4;
        //private long n41,n42,n43,n44,n45,n46,n47;

        public void inc1() {
            c1++;
        }
        
        public void inc2() {
            c2++;
        }
        
        public void inc3() {
            c3++;            
        }
        
        public void inc4() {
            c4++;
        }
        
        @Override
        public String toString() {            
            return "Counter{" 
                    + "c1=" + F.format(c1) 
                    + ", c2=" + F.format(c2) 
                    + ", c3=" + F.format(c3) 
                    + ", c4=" + F.format(c4)  + '}';
        }
        
    }
    
    
    
    public static void main(String[] args) throws InterruptedException {
       final Counter counter = new Counter();
       
       
       ExecutorService executorService = Executors.newFixedThreadPool(4);
        
       executorService.submit(() -> {
           while (isRun) {
               counter.inc1();
           }
       });
       executorService.submit(() -> {
           while (isRun) {
               counter.inc2();
           }
       });
       executorService.submit(() -> {
           while (isRun) {
               counter.inc3();
           }
       });
       executorService.submit(() -> {
           while (isRun) {
               counter.inc4();
           }
       });
       
       
       
       Thread.sleep(10000);
       isRun = false;
       executorService.shutdownNow();
       
       System.out.println(counter);
    }
}
