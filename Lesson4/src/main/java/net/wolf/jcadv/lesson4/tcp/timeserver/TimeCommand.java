/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.wolf.jcadv.lesson4.tcp.timeserver;

import java.io.PrintWriter;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * Команда выводящая время
 * @author Andrey
 */
public class TimeCommand implements Command{

    @Override
    public void execute(PrintWriter writer) {
        writer.format("Current time is %s %n", LocalTime.now().format(DateTimeFormatter.ISO_TIME));
    }
}
