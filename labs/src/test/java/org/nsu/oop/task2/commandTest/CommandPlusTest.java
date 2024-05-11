package org.nsu.oop.task2.commandTest;

import org.junit.jupiter.api.Test;
import org.nsu.oop.task2.command.Command;
import org.nsu.oop.task2.command.CommandPlus;
import org.nsu.oop.task2.error.CommandExecutionException;
import org.nsu.oop.task2.error.ContextStackOperationException;
import org.nsu.oop.task2.error.InvalidArgumentException;
import org.nsu.oop.task2.utility.Context;

import static org.junit.jupiter.api.Assertions.*;

public class CommandPlusTest {

    @Test
    void normalInputTest(){
        Context context = new Context();
        Command commandPlus = new CommandPlus();
        context.push(2);
        context.push(2);

        try{
            commandPlus.execute(context, new String[]{});
            assertEquals(4.0, context.peek());
        } catch (InvalidArgumentException | CommandExecutionException e){
            fail(e.getMessage());
        } catch (ContextStackOperationException ignored) {}


        context.push(1.3);
        try{
            commandPlus.execute(context, new String[]{});
            assertEquals(5.3, context.peek());
        } catch (InvalidArgumentException | CommandExecutionException e){
            fail(e.getMessage());
        } catch (ContextStackOperationException ignored) {}
    }
}
