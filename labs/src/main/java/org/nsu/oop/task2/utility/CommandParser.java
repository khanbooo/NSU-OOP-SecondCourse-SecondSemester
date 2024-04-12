package org.nsu.oop.task2.utility;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CommandParser {
    private String commandName;

    private String[] args;
    private final String stringToParse;
    public CommandParser(String str){
        this.stringToParse = str;
    }

    public void parse(){
        String[] parsedString = stringToParse.split(" ");
        commandName = parsedString[0];
        args = Arrays.stream(parsedString).skip(1).toArray(String[]::new);
    }

    public String getCommandName(){
        return commandName;
    }

    public String[] getArgs() {
        return args;
    }
}
