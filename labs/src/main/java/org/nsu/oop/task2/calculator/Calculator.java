package org.nsu.oop.task2.calculator;

import org.nsu.oop.task2.factory.CommandFactory;
import org.nsu.oop.task2.utility.CommandParser;
import org.nsu.oop.task2.utility.Context;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Calculator {
    private final Stream<String> command_stream;
    public Calculator(Stream<String> command_stream){
        this.command_stream = command_stream;
    }

    private void start() {
        CommandFactory commandFactory = new CommandFactory();
        Context context = new Context();
        this.command_stream.forEach(str -> executeCommand(context, str, commandFactory));
    }

    private void executeCommand(Context context, String str, CommandFactory commandFactory) {
        CommandParser commandParser = new CommandParser(str);
        commandParser.parse();
        Command command = commandFactory.createCommand(commandParser.getCommandName());
        command.execute(context, commandParser.getArgs());
    }

    public Stream<String> getCommand_stream() {
        return command_stream;
    }
}
