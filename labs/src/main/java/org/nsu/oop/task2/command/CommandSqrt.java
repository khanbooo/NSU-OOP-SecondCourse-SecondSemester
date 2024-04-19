package org.nsu.oop.task2.command;

import org.nsu.oop.task2.error.CommandExecutionException;
import org.nsu.oop.task2.error.ContextStackOperationException;
import org.nsu.oop.task2.error.InvalidArgumentException;
import org.nsu.oop.task2.utility.Context;

public class CommandSqrt extends Command{
    private double operand;

    private double squareRoot;

    public CommandSqrt() {
        super("SQRT", 0);
    }

    @Override
    public void execute(Context context, String[] args) throws InvalidArgumentException,
                        CommandExecutionException {
        super.execute(context, args);
        try {
            this.operand = context.pop();
        }
        catch (ContextStackOperationException e){
            throw new CommandExecutionException(this.num_of_args + " unable to perform: " + e.getMessage());
        }

        this.squareRoot = Math.sqrt(this.operand);
        if (Double.isNaN(this.squareRoot)){
            context.push(this.operand);
            throw new CommandExecutionException(this.command_name +
                    " executed with arithmetic exception: unable to compute square root of negative number.");
        }
        context.push(squareRoot);
    }
}
