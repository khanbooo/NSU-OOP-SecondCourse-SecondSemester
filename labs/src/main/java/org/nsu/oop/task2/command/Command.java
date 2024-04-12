package org.nsu.oop.task2.command;

import org.nsu.oop.task2.error.CommandExecutionException;
import org.nsu.oop.task2.error.ContextStackOperationException;
import org.nsu.oop.task2.error.InvalidArgumentException;
import org.nsu.oop.task2.utility.Context;

public abstract class Command {
    protected int num_of_args;
    protected String command_name;
    public Command(String command_name, int num_of_args){
        this.command_name = command_name;
        this.num_of_args = num_of_args;
    }

    public void execute(Context context, String[] args) throws InvalidArgumentException,
                        ContextStackOperationException, CommandExecutionException {
        if (args.length != this.num_of_args) {
            throw new InvalidArgumentException("Wrong amount of arguments");
        }
    }

    public Double getValue(Context context, String operand){
        if (context.containsVariable(operand)){
            return context.getVariable(operand);
        }

    }

    public String getCommand_name() {
        return command_name;
    }
}
