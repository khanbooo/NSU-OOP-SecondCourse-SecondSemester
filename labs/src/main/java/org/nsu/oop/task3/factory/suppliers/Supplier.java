package org.nsu.oop.task3.factory.suppliers;

import org.nsu.oop.task3.factory.parts.Part;
import org.nsu.oop.task3.factory.storage.Storage;

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
                //закинуть на склад
            }
            catch(InterruptedException e){
                break;
            }
        }
    }

    public void setPeriod(int period){
        this.period = period;
    }

    public abstract Part produce();
}
