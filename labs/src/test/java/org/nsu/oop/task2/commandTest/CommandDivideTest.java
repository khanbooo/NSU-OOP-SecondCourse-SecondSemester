package org.nsu.oop.task2.commandTest;

import org.junit.jupiter.api.Test;
import org.nsu.oop.task2.command.Command;
import org.nsu.oop.task2.command.CommandDivide;
import org.nsu.oop.task2.error.CommandExecutionException;
import org.nsu.oop.task2.error.ContextStackOperationException;
import org.nsu.oop.task2.error.InvalidArgumentException;
import org.nsu.oop.task2.utility.Context;

import static org.junit.jupiter.api.Assertions.*;

public class CommandDivideTest {
    @Test
    void badOperandsTest(){
        Context context = new Context();
        Command commandDivide = new CommandDivide();

        context.push(2);
        context.push(0);
        try{
            commandDivide.execute(context, new String[]{});
            fail("Division by zero, but Divide executed with success.");
        }
        catch (InvalidArgumentException | CommandExecutionException ignored){}
    }

    @Test
    void normalInputTest(){
        Context context = new Context();
        Command commandDivide = new CommandDivide();
        context.push(2);
        context.push(2);

        try{
            commandDivide.execute(context, new String[]{});
            assertEquals(1.0, context.peek());
        } catch (InvalidArgumentException | CommandExecutionException e){
            fail(e.getMessage());
        } catch (ContextStackOperationException ignored) {}


        context.push(4);
        try{
            commandDivide.execute(context, new String[]{});
            assertEquals(0.25, context.peek());
        } catch (InvalidArgumentException | CommandExecutionException e){
            fail(e.getMessage());
        } catch (ContextStackOperationException ignored) {}
    }
}
