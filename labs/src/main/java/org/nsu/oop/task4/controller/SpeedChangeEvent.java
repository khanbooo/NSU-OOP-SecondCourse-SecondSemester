package org.nsu.oop.task4.controller;

public class SpeedChangeEvent extends FactoryEvent{
    private final int speed;
    private final Class<?> partClass;

    public SpeedChangeEvent(int speed, Class<?> partClass){
        this.speed = speed;
        this.partClass = partClass;
    }

    public int getSpeed() {
        return speed;
    }

    public Class<?> getPartClass() {
        return partClass;
    }
}
