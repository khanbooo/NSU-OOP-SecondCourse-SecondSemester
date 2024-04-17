package org.nsu.oop.task2.calculator;


import org.nsu.oop.task2.error.ConfigException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.nsu.oop.task2.command.Command;
import org.nsu.oop.task2.error.CommandCreationException;
import org.nsu.oop.task2.error.CommandExecutionException;
import org.nsu.oop.task2.error.InvalidArgumentException;
import org.nsu.oop.task2.factory.CommandFactory;
import org.nsu.oop.task2.utility.CommandParser;
import org.nsu.oop.task2.utility.Context;

import java.util.stream.Stream;

public class Calculator {
    public final Logger LOGGER = LoggerFactory.getLogger(Calculator.class);
    private final Stream<String> command_stream;
    public Calculator(Stream<String> command_stream){
        this.command_stream = command_stream;
    }

    public void start() throws ConfigException {
        CommandFactory commandFactory = new CommandFactory();
        commandFactory.init();
        Context context = new Context();
        this.command_stream.forEach(str -> executeCommand(context, str, commandFactory));
    }

    private void executeCommand(Context context, String str, CommandFactory commandFactory) {
        CommandParser command_parser = null;
        try {
            command_parser = new CommandParser(str);
            command_parser.parse();
            Command command = commandFactory.createCommandInstanceByItsName(command_parser.getCommandName());
            command.execute(context, command_parser.getArgs());
            LOGGER.debug(command + " was successfully executed.");
        } catch (InvalidArgumentException | CommandExecutionException | CommandCreationException e) {
            LOGGER.warn("Did not execute / " + command_parser.getCommandName() + " / due to an error: " + e.getMessage());
        }
    }

    public Stream<String> getCommand_stream() {
        return command_stream;
    }
}
