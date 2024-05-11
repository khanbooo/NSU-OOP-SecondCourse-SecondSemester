package org.nsu.oop.task2.command;

import org.nsu.oop.task2.error.CastException;
import org.nsu.oop.task2.error.CommandExecutionException;
import org.nsu.oop.task2.error.InvalidArgumentException;
import org.nsu.oop.task2.utility.Context;

public class CommandDefine extends Command{
    String name;
    double var;
    public CommandDefine() {
        super("DEFINE", 2);
    }

    @Override
    public void execute(Context context, String[] args) throws InvalidArgumentException,
                        CommandExecutionException {
        super.execute(context, args);
        this.name = args[0];

        try{
            this.var = getValue(context, args[1]);
        } catch (CastException e) {
            throw new InvalidArgumentException("Could not parse get value: " + e.getMessage());
        }

        if (Double.isNaN(this.var)){
            throw new CommandExecutionException(this.command_name + " tried to push NaN on stack");
        }

        context.addVariable(name, var);
    }
}
