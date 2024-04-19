package org.nsu.oop.task2.commandTest;
import org.junit.jupiter.api.Test;
import org.nsu.oop.task2.command.Command;
import org.nsu.oop.task2.command.CommandBinary;
import org.nsu.oop.task2.error.CommandExecutionException;
import org.nsu.oop.task2.error.InvalidArgumentException;
import org.nsu.oop.task2.utility.Context;

import static org.junit.jupiter.api.Assertions.*;

public class CommandBinaryTest {

    @Test
    void badArgumentsTest() {
        Context context = new Context();
        Command commandBinary = new CommandBinary("Binary operation");
        try {
            commandBinary.execute(context, new String[]{"x"});
            fail("Too many arguments, but Divide executed with success.");
        } catch (InvalidArgumentException | CommandExecutionException ignored) {}
    }

    @Test
    void badOperandsTest() {
        Context context = new Context();
        Command commandBinary = new CommandBinary("Binary operation");

        try {
            commandBinary.execute(context, new String[]{});
            fail("No objects in stack, but Operation executed with success.");
        } catch (InvalidArgumentException | CommandExecutionException ignored) {}

        context.push(2);
        try {
            commandBinary.execute(context, new String[]{});
            fail("Only one object in stack, but Operation executed with success.");
        } catch (InvalidArgumentException | CommandExecutionException ignored) {}

        context.push(0);
    }
}
