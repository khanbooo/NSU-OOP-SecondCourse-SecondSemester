package org.nsu.oop.task2.factory;

import org.nsu.oop.task2.command.Command;
import org.nsu.oop.task2.error.CommandCreationException;
import org.nsu.oop.task2.error.ConfigException;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Properties;

public class CommandFactory {
    private final HashMap<String, Class<Command>> commands;
    public CommandFactory(){
        this.commands = new HashMap<>();
    }

    public void init() throws ConfigException {
        String configFilename = "/config.txt";
        InputStream stream = CommandFactory.class.getResourceAsStream(configFilename);
        if (stream == null){
            throw new ConfigException("Unable to open config");
        }

        try {
            Properties properties = new Properties();
            properties.load(stream);
            for (Object name : properties.keySet()){
                String command_name = (String) name;
                System.out.println(command_name + " " + properties.getProperty(command_name));
                commands.put(command_name, (Class<Command>) Class.forName(properties.getProperty(command_name)));
            }
        } catch(ClassNotFoundException e){
            throw new ConfigException("Class does not exist: " + e.getMessage());
        } catch(ClassCastException e){
            throw new ConfigException("Unable to cast class: " + e.getMessage());
        } catch (IOException e) {
            throw new ConfigException(e.getMessage());
        }
    }

    public Command createCommandInstanceByItsName(String command_name) throws CommandCreationException {
        try{
            if (command_name == null || command_name.isEmpty() || !commands.containsKey(command_name)){
                throw new CommandCreationException("Unable to create command");
            }
            return commands.get(command_name).getDeclaredConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            throw new CommandCreationException("Unable to create command: " + e.getMessage());
        }
    }
}
