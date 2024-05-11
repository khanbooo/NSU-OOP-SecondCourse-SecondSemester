package org.nsu.oop.task2.command;

import org.nsu.oop.task2.error.CommandExecutionException;
import org.nsu.oop.task2.error.ContextStackOperationException;
import org.nsu.oop.task2.error.InvalidArgumentException;
import org.nsu.oop.task2.utility.Context;

public class CommandPop extends Command{
    public CommandPop() {
        super("POP", 0);
    }

    @Override
    public void execute(Context context, String[] args) throws InvalidArgumentException,
                        CommandExecutionException {
        super.execute(context, args);
        try{
            context.pop();
        }
        catch (ContextStackOperationException e){
            throw new CommandExecutionException(this.command_name + " executed with exception. " +
                                                " unable to pop from stack: " + e.getMessage());
        }
    }
}
