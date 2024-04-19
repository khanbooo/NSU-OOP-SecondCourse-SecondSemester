package org.nsu.oop.task2.commandTest;

import org.junit.jupiter.api.Test;
import org.nsu.oop.task2.command.Command;
import org.nsu.oop.task2.command.CommandDefine;
import org.nsu.oop.task2.error.CommandExecutionException;
import org.nsu.oop.task2.error.InvalidArgumentException;
import org.nsu.oop.task2.utility.Context;

import static org.junit.jupiter.api.Assertions.*;

public class CommandDefineTest {
    private final Context context = new Context();

    @Test
    void badArgumentsTest(){
        Command commandDefine = new CommandDefine();
        try{
            commandDefine.execute(context, new String[]{"x", "x"});
            fail("Unable to define String to String, but Define executed with success.");
        } catch (InvalidArgumentException | CommandExecutionException ignored){}
        try{
            commandDefine.execute(context, new String[]{"x"});
            fail("Too few arguments, but Define executed with success.");
        } catch (InvalidArgumentException | CommandExecutionException ignored){}
        try{
            commandDefine.execute(context, new String[]{});
            fail("Too few arguments, but Define executed with success.");
        } catch (InvalidArgumentException | CommandExecutionException ignored){}
        try{
            commandDefine.execute(context, new String[]{"x", "2", "2"});
            fail("Too many arguments, but Define executed with success.");
        } catch (InvalidArgumentException | CommandExecutionException ignored){}
        try{
            commandDefine.execute(context, new String[]{"x", "NaN"});
            fail("Defining NaN, but Define executed with success.");
        } catch (InvalidArgumentException | CommandExecutionException ignored){}
    }

    @Test
    void normalArgumentsTest(){
        CommandDefine commandDefine = new CommandDefine();
        try{
            commandDefine.execute(context, new String[]{"x", "2"});
            assertTrue(context.containsVariable("x"));
            assertEquals(2, context.getVariable("x"));
        } catch (InvalidArgumentException | CommandExecutionException e){
            fail(e.getMessage());
        }
        try{
            commandDefine.execute(context, new String[]{"x", "5.13"});
            assertTrue(context.containsVariable("x"));
            assertEquals(5.13, context.getVariable("x"));
        } catch (InvalidArgumentException | CommandExecutionException e){
            fail(e.getMessage());
        }
    }
}
