/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.wolf.jcadv.lesson2.guava;

import com.google.common.collect.Range;
import com.google.common.collect.RangeSet;
import com.google.common.collect.TreeRangeSet;
import java.time.LocalTime;

/**
 *
 * @author Andrey
 */
public class RangesExample {
        
        
        public static void rangeSet() {
                RangeSet<LocalTime> timeRanges = TreeRangeSet.create();
                
                timeRanges.add(Range.closed(LocalTime.of(0, 0), LocalTime.of(3, 30)));
                timeRanges.add(Range.closed(LocalTime.of(6, 0), LocalTime.of(8, 40)));
                timeRanges.add(Range.closed(LocalTime.of(18, 0), LocalTime.of(22, 20)));
                
                System.out.println( "Пересекает ли 6:49:35 => " +
                        timeRanges.contains(LocalTime.of(6, 49, 35))
                );
                
                System.out.println( "Пересекает ли 15:49:35 => " +
                        timeRanges.contains(LocalTime.of(15, 49, 35))
                );
                
                System.out.println( "Пересекает ли 22:20 => " +
                        timeRanges.contains(LocalTime.of(22, 20))
                );
                
                System.out.println( "Пересекает ли 22:20:01 => " +
                        timeRanges.contains(LocalTime.of(22, 20, 1))
                );
                
                
        }
        
        public static void main(String[] args) {
                rangeSet();
        }
}
