package org.nsu.oop.task4.factory.suppliers;

import org.nsu.oop.task4.factory.parts.Part;
import org.nsu.oop.task4.factory.storage.Storage;

public abstract class Supplier extends Thread{
    private int period;
    private final Storage<Part> storage;
    protected int id = 0;

    public Supplier(Storage<Part> storage, int period){
        this.storage = storage;
        this.period = period;
    }

    @Override
    public void run(){
        while (true){
            Part part;
            try{
                Thread.sleep(period);
                part = produce();
                storage.load(part);
            }
            catch(InterruptedException e){
                break;
            }
        }
    }

    public void setPeriod(int period){
        this.period = period;
    }

    public int getPeriod() {
        return period;
    }

    public abstract Part produce();
}
