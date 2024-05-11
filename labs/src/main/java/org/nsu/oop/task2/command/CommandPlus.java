package org.nsu.oop.task2.command;

import org.nsu.oop.task2.error.CommandExecutionException;
import org.nsu.oop.task2.error.InvalidArgumentException;
import org.nsu.oop.task2.utility.Context;

public class CommandPlus extends CommandBinary{
    public CommandPlus() {
        super("PLUS");
    }

    @Override
    public void execute(Context context, String[] args) throws InvalidArgumentException,
                        CommandExecutionException {
        super.execute(context, args);
        try{
            context.push(first_operand + second_operand);
        }
        catch (ArithmeticException e){
            context.push(first_operand);
            context.push(second_operand);
            throw new CommandExecutionException(this.command_name + " executed with arithmetic exception " + e.getMessage());
        }
    }
}
