package org.nsu.oop.task2.main;

import org.nsu.oop.task2.calculator.Calculator;
import org.nsu.oop.task2.error.ConfigException;
import org.nsu.oop.task2.utility.ArgumentParser;
import org.nsu.oop.task2.utility.StreamContainer;

public class Main {
    public static void main(String[] args) {
        ArgumentParser parser = new ArgumentParser(args);
        if (!parser.getValid()){
            System.out.println(parser.getError());
        }

        StreamContainer streamContainer = new StreamContainer(parser.getFilename());
        try {
            streamContainer.initializeStream();
        }
        catch (Throwable e){
            streamContainer.LOGGER.error("Error occurred: " + e.getMessage());
            return;
        }

        Calculator calculator = new Calculator(streamContainer.getCommandStream());
        try{
            calculator.start();
        } catch (ConfigException e){
            calculator.LOGGER.error("Unable to start calculations: " + e.getMessage());
        }

    }
}
