package org.nsu.oop.task2.commandTest;

import org.junit.jupiter.api.Test;
import org.nsu.oop.task2.command.Command;
import org.nsu.oop.task2.command.CommandMultiply;
import org.nsu.oop.task2.error.CommandExecutionException;
import org.nsu.oop.task2.error.ContextStackOperationException;
import org.nsu.oop.task2.error.InvalidArgumentException;
import org.nsu.oop.task2.utility.Context;

import static org.junit.jupiter.api.Assertions.*;

public class CommandMultiplyTest {

    @Test
    void normalInputTest(){
        Context context = new Context();
        Command commandMultiply = new CommandMultiply();
        context.push(2);
        context.push(2);

        try{
            commandMultiply.execute(context, new String[]{});
            assertEquals(4.0, context.peek());
        } catch (InvalidArgumentException | CommandExecutionException e){
            fail(e.getMessage());
        } catch (ContextStackOperationException ignored) {}


        context.push(1.3);
        try{
            commandMultiply.execute(context, new String[]{});
            assertEquals(5.2, context.peek());
        } catch (InvalidArgumentException | CommandExecutionException e){
            fail(e.getMessage());
        } catch (ContextStackOperationException ignored) {}
    }
}
