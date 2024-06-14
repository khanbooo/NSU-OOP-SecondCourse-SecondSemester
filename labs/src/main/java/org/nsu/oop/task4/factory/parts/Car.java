package org.nsu.oop.task4.factory.parts;

public class Car{
    private final Engine engine;
    private final Body body;
    private final Accessory accessory;

    public Car(Engine engine, Body body, Accessory accessory) {
        this.engine = engine;
        this.body = body;
        this.accessory = accessory;
    }

    @Override
    public String toString(){
        return "Car (Car: accessory: " + accessory.getId() + " body: " + body.getId() + " engine: " + engine.getId() + "\n";
    }
}
