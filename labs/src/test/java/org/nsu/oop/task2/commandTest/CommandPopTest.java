package org.nsu.oop.task2.commandTest;

import org.junit.jupiter.api.Test;
import org.nsu.oop.task2.command.Command;
import org.nsu.oop.task2.command.CommandPop;
import org.nsu.oop.task2.error.CommandExecutionException;
import org.nsu.oop.task2.error.ContextStackOperationException;
import org.nsu.oop.task2.error.InvalidArgumentException;
import org.nsu.oop.task2.utility.Context;

import static org.junit.jupiter.api.Assertions.*;

public class CommandPopTest {
    private final Context context = new Context();

    @Test
    void badArgumentsTest(){
        Command commandPop = new CommandPop();
        try{
            commandPop.execute(context, new String[]{"x"});
            fail("Too many arguments, but Pop executed with success.");
        } catch (InvalidArgumentException | CommandExecutionException ignored){}
    }

    @Test
    void emptyStackTest(){
        Command commandPop = new CommandPop();
        try{
            commandPop.execute(context, new String[]{});
            fail("Stack is empty, but Pop executed with success.");
        } catch (InvalidArgumentException | CommandExecutionException ignored){}
    }

    @Test
    void normalArgumentsTest(){
        Command commandPop = new CommandPop();
        context.push(4.3);
        context.push(2);
        try{
            commandPop.execute(context, new String[]{});
            assertEquals(4.3, context.peek());
        } catch (InvalidArgumentException | CommandExecutionException | ContextStackOperationException e){
            fail(e.getMessage());
        }
    }
}
