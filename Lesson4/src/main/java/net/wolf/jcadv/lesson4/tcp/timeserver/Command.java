/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.wolf.jcadv.lesson4.tcp.timeserver;

import java.io.PrintWriter;

/**
 * Интерфейс нашей telnet-команды
 * @author Andrey
 */
public interface Command {
    
    void execute(PrintWriter writer);
}
