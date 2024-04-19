package org.nsu.oop.task2.commandTest;

import org.junit.jupiter.api.Test;
import org.nsu.oop.task2.command.Command;
import org.nsu.oop.task2.command.CommandPush;
import org.nsu.oop.task2.error.CommandExecutionException;
import org.nsu.oop.task2.error.ContextStackOperationException;
import org.nsu.oop.task2.error.InvalidArgumentException;
import org.nsu.oop.task2.utility.Context;

import static org.junit.jupiter.api.Assertions.*;

public class CommandPushTest {
    private final Context context = new Context();

    @Test
    void badArgumentsTest(){
        Command commandPush = new CommandPush();
        try{
            commandPush.execute(context, new String[]{});
            fail("Too few arguments, but Push executed with success.");
        } catch (InvalidArgumentException | CommandExecutionException ignored){}
        try{
            commandPush.execute(context, new String[]{""});
            fail("Too few arguments, but Push executed with success.");
        } catch (InvalidArgumentException | CommandExecutionException ignored){}
        try{
            commandPush.execute(context, new String[]{"x", "2"});
            fail("Too many arguments, but Push executed with success.");
        } catch (InvalidArgumentException | CommandExecutionException ignored){}
        try{
            commandPush.execute(context, new String[]{"NaN"});
            fail("Tried to Push NaN, but Push executed with success.");
        } catch (InvalidArgumentException | CommandExecutionException ignored){}
    }

    @Test
    void undefinedVariableTest(){
        Command commandPush = new CommandPush();
        try{
            commandPush.execute(context, new String[]{"x"});
            fail("Variable is undefined, but Push executed with success.");
        } catch (InvalidArgumentException | CommandExecutionException ignored){}
    }

    @Test
    void normalArgumentsTest(){
        Command commandPush = new CommandPush();
        try{
            commandPush.execute(context, new String[]{"4.3"});
            assertEquals(4.3, context.peek());
        } catch (InvalidArgumentException | CommandExecutionException | ContextStackOperationException e){
            fail(e.getMessage());
        }

        context.addVariable("x", 2);

        try{
            commandPush.execute(context, new String[]{"x"});
            assertEquals(2, context.peek());
        } catch (InvalidArgumentException | CommandExecutionException | ContextStackOperationException e){
            fail(e.getMessage());
        }
    }
}
