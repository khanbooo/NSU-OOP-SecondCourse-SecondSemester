package org.nsu.oop.task2.command;

import org.nsu.oop.task2.error.CommandExecutionException;
import org.nsu.oop.task2.error.ContextStackOperationException;
import org.nsu.oop.task2.error.InvalidArgumentException;
import org.nsu.oop.task2.utility.Context;

public class CommandPrint extends Command{
    public CommandPrint() {
        super("PRINT", 0);
    }

    @Override
    public void execute(Context context, String[] args) throws InvalidArgumentException,
                        CommandExecutionException {
        super.execute(context, args);

        try{
            System.out.println("The highest element on stack is: " + context.peek());
        }
        catch (ContextStackOperationException e){
            throw new CommandExecutionException(this.command_name + " is unable to perform: " + e.getMessage());
        }
    }
}
