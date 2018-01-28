/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.wolf.jcadv.lesson4.tcp.timeserver;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

/**
 * Простой парсер команд.
 * @author Andrey
 */
public class CommandParser {
    
    private final Map<String, Supplier<Command>> commandMap;

    public CommandParser() {
        commandMap = new HashMap<>();
        commandMap.put("time", () -> new TimeCommand());
        commandMap.put("datetime", () -> new DateTimeCommand());
    }
    
    public Command parseCommand(String command) {
        Supplier<Command> commandFactory = commandMap.get( command.toLowerCase() );
        if (commandFactory == null) {
            throw new IllegalArgumentException(command);
        }
        return commandFactory.get();
    }
}
