package org.nsu.oop.task2.command;

import org.nsu.oop.task2.error.CommandExecutionException;
import org.nsu.oop.task2.error.ContextStackOperationException;
import org.nsu.oop.task2.error.InvalidArgumentException;
import org.nsu.oop.task2.utility.Context;

public class CommandPush extends Command{
    private double num_to_push = Double.NaN;
    public CommandPush() {
        super("PUSH", 1);
    }

    @Override
    public void execute(Context context, String[] args) throws InvalidArgumentException,
                        ContextStackOperationException, CommandExecutionException {
        super.execute(context, args);
        try{
            this.num_to_push
        }
    }
}
