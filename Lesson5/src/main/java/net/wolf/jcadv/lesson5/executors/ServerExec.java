/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.wolf.jcadv.lesson5.executors;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Andrey
 */
public class ServerExec {
    
    static ExecutorService executorService = new ThreadPoolExecutor(10, 50, 10, TimeUnit.MINUTES, 
            new ArrayBlockingQueue<>(1000));
      //static ExecutorService executorService = Executors.newFixedThreadPool(50);
    
    
    public static void main(String[] args) throws IOException {

        ServerSocket socket = new ServerSocket(9000);
        while (true) {
            final Socket s = socket.accept();
            /**
             * Проблема в том, что такая реализация плохо масштабируется, 
             * так как при большом наплыве подключений сервер может породить
             * много потоков
             */
            new Thread(() -> doWork(s))
                    .start();
        }
        
    }

    static void doWork(Socket s) {
        //обрабатываем соединение с клиентом
    }
}
