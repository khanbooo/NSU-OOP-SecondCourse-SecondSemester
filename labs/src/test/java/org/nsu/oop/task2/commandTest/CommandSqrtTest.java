package org.nsu.oop.task2.commandTest;

import org.junit.jupiter.api.Test;
import org.nsu.oop.task2.command.Command;
import org.nsu.oop.task2.command.CommandSqrt;
import org.nsu.oop.task2.error.CommandExecutionException;
import org.nsu.oop.task2.error.ContextStackOperationException;
import org.nsu.oop.task2.error.InvalidArgumentException;
import org.nsu.oop.task2.utility.Context;

import static org.junit.jupiter.api.Assertions.*;

public class CommandSqrtTest {
    private final Context context = new Context();

    @Test
    void badArgumentsTest(){
        Command commandSqrt = new CommandSqrt();
        try{
            commandSqrt.execute(context, new String[]{"x"});
            fail("Too many arguments, but Sqrt executed with success.");
        } catch (InvalidArgumentException | CommandExecutionException ignored){}
    }

    @Test
    void emptyStackTest(){
        Command commandSqrt = new CommandSqrt();
        try{
            commandSqrt.execute(context, new String[]{});
            fail("Stack is empty, but Sqrt executed with success.");
        } catch (InvalidArgumentException | CommandExecutionException ignored){}
    }

    @Test
    void negativeNumberTest() {
        Command commandSqrt = new CommandSqrt();
        context.push(-5);
        try{
            commandSqrt.execute(context, new String[]{});
            fail("Number is negative, but Sqrt executed with success.");
        } catch (InvalidArgumentException | CommandExecutionException e){
            try{
                assertEquals(-5, context.peek());
            } catch (ContextStackOperationException ignored){}
        }
    }

    @Test
    void normalArgumentsTest(){
        Command commandSqrt = new CommandSqrt();
        context.push(4);
        try{
            commandSqrt.execute(context, new String[]{});
            assertEquals(2, context.peek());
        } catch (InvalidArgumentException | CommandExecutionException | ContextStackOperationException e){
            fail(e.getMessage());
        }
    }
}
