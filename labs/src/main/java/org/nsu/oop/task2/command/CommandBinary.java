package org.nsu.oop.task2.command;

import org.nsu.oop.task2.error.CommandExecutionException;
import org.nsu.oop.task2.error.ContextStackOperationException;
import org.nsu.oop.task2.error.InvalidArgumentException;
import org.nsu.oop.task2.utility.Context;

import java.util.EmptyStackException;

public class CommandBinary extends Command{
    protected double first_operand;
    protected double second_operand;
    public CommandBinary(String command_name) {
        super(command_name, 0);
    }

    @Override
    //
    public void execute(Context context, String[] args) throws InvalidArgumentException,
                        ContextStackOperationException, CommandExecutionException {
        super.execute(context, args);
        try{
            second_operand = context.pop();
        }
        catch (ContextStackOperationException e){
            throw new ContextStackOperationException(this.command_name + " executed with exception: " + e.getMessage());
        }

        try{
            first_operand = context.pop();
        }
        catch (ContextStackOperationException e){
            context.push(second_operand);
            throw new ContextStackOperationException(this.command_name + " executed with exception: " + e.getMessage());
        }
    }
}
