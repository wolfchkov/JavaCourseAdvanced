/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.wolf.jcadv.lesson2.gscol;

import com.google.common.base.Stopwatch;
import com.gs.collections.api.map.primitive.IntObjectMap;
import com.gs.collections.api.list.primitive.IntList;
import com.gs.collections.impl.list.mutable.primitive.IntArrayList;
import com.gs.collections.impl.list.mutable.primitive.LongArrayList;
import com.gs.collections.impl.map.mutable.primitive.IntObjectHashMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.function.IntConsumer;

/**
 *
 * @author Andrey
 */
public class PrimitivesCollections {
        
        
        public static void list() {
                
                 int size = 10_000_000;
                 LongArrayList intList = new LongArrayList(size);
                 List<Long> objIntList = new ArrayList<>(size);
                 
                //заполним массивы 
                ThreadLocalRandom.current()
                        .ints()
                        .limit(size)
                        .forEach(new IntConsumer() {
                         @Override
                         public void accept(int i) {
                                 intList.add(i);

                                 objIntList.add(Long.valueOf(i));
                         }
                 });
                
                long[] intArray = intList.toArray();
                
                Stopwatch perfomance = Stopwatch.createUnstarted();
                
                //найдем минимальный элемент в каждом 
                perfomance.start();
                long minObj  = Collections.min(objIntList);
                perfomance.stop();
                System.out.printf("Минимальный элемент %d для List<Long> найден за %d милисекунд %n", minObj, 
                        perfomance.elapsed(TimeUnit.MILLISECONDS));
                
                perfomance.reset();
                
                perfomance.start();
                long min = intList.min();
                perfomance.stop();
                System.out.printf("Минимальный элемент %d для LongArrayList найден за %d милисекунд %n", min, 
                        perfomance.elapsed(TimeUnit.MILLISECONDS));
                
                perfomance.reset();
                
                perfomance.start();
                long minArray = Long.MIN_VALUE;
                for (int i=0; i < size;++i)  {
                        long el = intArray[i];
                        if (minArray > el) {
                               minArray = el;
                        }
                }
                perfomance.stop();
                System.out.printf("Минимальный элемент %d для long[] найден за %d милисекунд %n", min, 
                        perfomance.elapsed(TimeUnit.MILLISECONDS));
                 
        }
        
        public static void map() {
                
                 int size = 10_000_000;
                 //наши карты
                 IntObjectHashMap<String> intMap= new IntObjectHashMap();
                 Map<Integer, String> intObjMap = new HashMap<>();

                 //случайны ключ будем хранить сдесь
                 IntArrayList hashs = new IntArrayList();
                          
                 ThreadLocalRandom.current().nextBoolean();
                 for (int i = 0; i < size; i++) {
                         String uuid = UUID.randomUUID().toString();
                         int uuidKey = uuid.hashCode();
                         intMap.put(uuidKey, uuid);
                         intObjMap.put(uuidKey, uuid);
                         if (ThreadLocalRandom.current().nextInt(0, 100) <= 2) {
                                 hashs.add(uuidKey);
                         }
                 }
                
                
                Stopwatch perfomance = Stopwatch.createUnstarted();
                
                //найдем минимальный элемент в каждом 
                
                perfomance.start();
                        hashs.forEach((i) -> {
                                String uuid = intObjMap.get(i);
                        });
                perfomance.stop();
                System.out.printf("%d милисекунд %n",   perfomance.elapsed(TimeUnit.MILLISECONDS));
                
                perfomance.reset();
                
                
                perfomance.start();
                        hashs.forEach((i) -> {
                                String uuid = intMap.get(i);
                        });
                perfomance.stop();
                System.out.printf("%d милисекунд %n",   perfomance.elapsed(TimeUnit.MILLISECONDS));
                 
        }        
        
        public static void main(String[] args) {
                map();
        }
}
