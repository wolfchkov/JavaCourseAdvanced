/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.wolf.jcadv.lesson4.tcp.timeserver;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * Обработчик клиентского подключения. Запускается в новом потоке. Обрабатывает
 * команды клиента.
 *
 * @author Andrey
 */
public class CommandExecutor implements Runnable {

    /**
     * Кодовая страница для взаимодействия с клиентом
     */
    private static final String CHARSET = "UTF-8";

    /**
     * Сокет подключения
     */
    private final Socket socket;

    /**
     * Парсер команд
     */
    private final CommandParser commandParser;

    public CommandExecutor(Socket socket) {
        this.socket = socket;
        this.commandParser = new CommandParser();
    }

    @Override
    public void run() {

        try (Socket s = socket;) {
            //Получаем потоки ввода/вывода для нашего соединения
            Scanner scanner = new Scanner(s.getInputStream(), CHARSET);
            PrintWriter writer = new PrintWriter(new OutputStreamWriter(s.getOutputStream(), CHARSET), true);

            //постоянно обрабатываем команды
            while (true) {

                if (scanner.hasNextLine()) {

                    String commandString = scanner.nextLine().trim();
                    System.out.println(commandString);

                    if ("exit".equalsIgnoreCase(commandString)) {
                        //выходим с цикла, закрываем сокет и завершаем поток
                        break;
                    }

                    //парсим и выполняем команду
                    try {                        
                        Command command = commandParser.parseCommand(commandString);
                        command.execute(writer);
                    } catch (IllegalArgumentException ex) {
                        writer.format("Unknown command '%s'.%n", commandString);
                    }
                }

            }
        } catch (IOException ioe) {
            System.err.println(ioe);
        }
    }

}
