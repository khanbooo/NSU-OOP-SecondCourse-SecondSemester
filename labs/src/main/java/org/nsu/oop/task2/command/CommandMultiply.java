package org.nsu.oop.task2.command;

import org.nsu.oop.task2.error.CommandExecutionException;
import org.nsu.oop.task2.error.ContextStackOperationException;
import org.nsu.oop.task2.error.InvalidArgumentException;
import org.nsu.oop.task2.utility.Context;

public class CommandMultiply extends CommandBinary{
    public CommandMultiply() {
        super("MULTIPLY");
    }

    @Override
    public void execute(Context context, String[] args) throws InvalidArgumentException,
                        ContextStackOperationException, CommandExecutionException {
        super.execute(context, args);
        try{
            context.push(first_operand * second_operand);
        }
        catch (ArithmeticException e){
            context.push(first_operand);
            context.push(second_operand);
            throw new CommandExecutionException(this.command_name + " executed with arithmetic exception " + e.getMessage());
        }
    }
}
