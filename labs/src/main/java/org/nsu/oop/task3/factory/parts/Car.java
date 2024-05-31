package org.nsu.oop.task3.factory.parts;

public class Car{
    private final int accessory_id;
    private final int body_id;
    private final int engine_id;

    public Car(int accessory_id, int body_id, int engine_id){
        this.accessory_id = accessory_id;
        this.body_id = body_id;
        this.engine_id = engine_id;
    }

    @Override
    public String toString(){
        //not sure whether it works or not
        return "Car (accessory: " + accessory_id + " body: " + body_id + " engine: " + engine_id + "\n";
    }
}
