/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.wolf.jcadv.lesson4.tcp.timeserver;

import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Команда выводящая дату и время.
 * @author Andrey
 */
public class DateTimeCommand implements Command {

    @Override
    public void execute(PrintWriter writer) {
         writer.format("Current date and time is %s %n", LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));       
    }
    
    
}
