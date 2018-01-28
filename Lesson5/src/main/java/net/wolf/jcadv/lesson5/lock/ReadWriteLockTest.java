/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.wolf.jcadv.lesson5.lock;

import java.io.Reader;
import java.util.Random;

/**
 *
 * @author Andrey
 */
public class ReadWriteLockTest {

    static class Writer extends Thread {

        private final ReadWriteList<Integer> sharedList;

        public Writer(ReadWriteList<Integer> sharedList) {
            this.sharedList = sharedList;
        }

        public void run() {
            Random random = new Random();
            int number = random.nextInt(100);
            sharedList.add(number);

            try {
                Thread.sleep(100);
                System.out.println(getName() + " -> put: " + number);
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }
        }
    }

    static class Reader extends Thread {

        private final ReadWriteList<Integer> sharedList;

        public Reader(ReadWriteList<Integer> sharedList) {
            this.sharedList = sharedList;
        }

        public void run() {
            Random random = new Random();
            int index = random.nextInt(sharedList.size());
            Integer number = sharedList.get(index);

            System.out.println(getName() + " -> get: " + number);

            try {
                Thread.sleep(100);
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }

        }
    }

    static final int READER_SIZE = 100;
    static final int WRITER_SIZE = 2;

    public static void main(String[] args) throws InterruptedException {
        Integer[] initialElements = {33, 28, 86, 99};

        ReadWriteList<Integer> sharedList = new ReadWriteList<>(initialElements);

        for (int i = 0; i < WRITER_SIZE; i++) {
            new Writer(sharedList).start();
        }

        for (int i = 0; i < READER_SIZE; i++) {
            new Reader(sharedList).start();
        }

        Thread.sleep(2000);
    }
}
