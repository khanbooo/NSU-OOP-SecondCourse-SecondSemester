package org.nsu.oop.task4.controller;

public class StockChangeEvent extends FactoryEvent{
    private final Class<?> part_class;
    private final int current_amount;
    private final int total_amount;

    public StockChangeEvent(Class<?> part_class, int current_amount, int total_amount){
        this.part_class = part_class;
        this.current_amount = current_amount;
        this.total_amount = total_amount;
    }

    public Class<?> getPartClass() {
        return part_class;
    }

    public int getCurrent_amount() {
        return current_amount;
    }

    public int getTotal_amount() {
        return total_amount;
    }
}
