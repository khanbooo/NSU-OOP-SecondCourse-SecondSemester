package org.nsu.oop.task2.command;

import org.nsu.oop.task2.error.CastException;
import org.nsu.oop.task2.error.CommandExecutionException;
import org.nsu.oop.task2.error.InvalidArgumentException;
import org.nsu.oop.task2.utility.Context;

public class CommandPush extends Command{
    private double num_to_push = Double.NaN;
    public CommandPush() {
        super("PUSH", 1);
    }

    @Override
    public void execute(Context context, String[] args) throws InvalidArgumentException,
                        CommandExecutionException {
        super.execute(context, args);

        try {
            num_to_push = getValue(context, args[0]);
        }
        catch(CastException e){
            throw new InvalidArgumentException("Could not parse get value: " + e.getMessage());
        }

        if (Double.isNaN(num_to_push)){
            throw new CommandExecutionException(this.command_name + " tried to push NaN on stack");
        }

        context.push(num_to_push);
    }
}
