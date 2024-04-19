package org.nsu.oop.task2.commandTest;

import org.junit.jupiter.api.Test;
import org.nsu.oop.task2.command.Command;
import org.nsu.oop.task2.command.CommandPrint;
import org.nsu.oop.task2.error.CommandExecutionException;
import org.nsu.oop.task2.error.InvalidArgumentException;
import org.nsu.oop.task2.utility.Context;

import static org.junit.jupiter.api.Assertions.*;

public class CommandPrintTest {
    private final Context context = new Context();

    @Test
    void badArgumentsTest(){
        Command commandPrint = new CommandPrint();
        try{
            commandPrint.execute(context, new String[]{"x"});
            fail("Too many arguments, but Print executed with success.");
        } catch (InvalidArgumentException | CommandExecutionException ignored){}
    }

    @Test
    void emptyStackTest(){
        Command commandPrint = new CommandPrint();
        try{
            commandPrint.execute(context, new String[]{});
            fail("Stack is empty, but Print executed with success.");
        } catch (InvalidArgumentException | CommandExecutionException ignored){}
    }

    @Test
    void normalArgumentsTest(){
        Command commandPrint = new CommandPrint();
        context.push(4.3);
        try{
            commandPrint.execute(context, new String[]{});
        } catch (InvalidArgumentException | CommandExecutionException e){
            fail(e.getMessage());
        }
    }
}
