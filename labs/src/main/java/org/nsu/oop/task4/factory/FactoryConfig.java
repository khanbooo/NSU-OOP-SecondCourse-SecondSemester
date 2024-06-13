package org.nsu.oop.task4.factory;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.Properties;

public class FactoryConfig {
    public int accessory_storage_size = 1000;
    public int body_storage_size = 1000;
    public int engine_storage_size = 1000;
    public int car_storage_size = 1000;
    public int number_of_workers = 5;
    public int number_of_accessory_suppliers = 10;
    public int number_of_dealers = 5;
    public boolean is_logger_on = false;

    public FactoryConfig(String name){
        InputStream configFile = getClass().getResourceAsStream(name);
        Properties properties = new Properties();

        try {
            properties.load(configFile);
        } catch (IOException e) {
            System.err.println("configFileError");
        }

        for (Field field: getClass().getFields()){
            String field_name = field.getName();

            if (properties.containsKey(field_name)){
                Object value;

                if (field_name.equals("is_logger_on")){
                    value = Boolean.parseBoolean(properties.getProperty(field_name));
                }
                else{
                    value = Integer.parseInt(properties.getProperty(field_name));
                }

                try{
                    field.set(this, value);
                }
                catch(IllegalAccessException e){
                    throw new RuntimeException("Illegal configuration: " + e.getMessage() + "\n");
                }
            }
        }
    }

    public FactoryConfig(){
        this("/factory.cfg");
    }
}
