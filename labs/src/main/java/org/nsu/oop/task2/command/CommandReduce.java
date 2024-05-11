package org.nsu.oop.task2.command;

import org.nsu.oop.task2.error.CommandCreationException;
import org.nsu.oop.task2.error.CommandExecutionException;
import org.nsu.oop.task2.error.InvalidArgumentException;
import org.nsu.oop.task2.utility.Context;

import java.util.Objects;

public class CommandReduce extends Command{
    public CommandReduce() {
        super("REDUCE", 1);
    }

    @Override
    public void execute(Context context, String[] args) throws InvalidArgumentException,
            CommandExecutionException {
        if (Objects.equals(args[0], "DEFINE") || Objects.equals(args[0], "PRINT")
                || Objects.equals(args[0], "PUSH") || Objects.equals(args[0], "REDUCE")
                || Objects.equals(args[0], "SQRT")){
            throw new InvalidArgumentException(this.command_name + " cannot perform " + args[0] + " operation.");
        }
        int num_of_operations = context.getStackSize() - ((!Objects.equals(args[0], "POP")) ? 1 : 0);
        for (int i = 0; i < num_of_operations; i++) {
            try {
                Command command = commandFactory.createCommandInstanceByItsName(args[0]);
                command.execute(context, new String[]{});
            } catch (CommandCreationException | InvalidArgumentException e) {
                throw new InvalidArgumentException(e.getMessage());
            } catch (CommandExecutionException e){
                throw new CommandExecutionException(this.command_name + " executed with exception: " + e.getMessage());
            }
        }
    }

}
