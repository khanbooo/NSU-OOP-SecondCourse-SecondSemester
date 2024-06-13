package org.nsu.oop.task4.controller;

public class StockChangeEvent extends FactoryEvent{
    private final Class<?> partClass;
    private final int current_amount;
    private final int total_amount;

    public StockChangeEvent(Class<?> partClass, int current_amount, int total_amount){
        this.partClass = partClass;
        this.current_amount = current_amount;
        this.total_amount = total_amount;
    }

    public Class<?> getPartClass() {
        return partClass;
    }

    public int getCurrent_amount() {
        return current_amount;
    }

    public int getTotal_amount() {
        return total_amount;
    }
}
