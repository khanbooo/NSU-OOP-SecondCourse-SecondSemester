package org.nsu.oop.task3.factory.dealer;

import org.nsu.oop.task3.factory.parts.Car;
import org.nsu.oop.task3.factory.parts.Part;
import org.nsu.oop.task3.factory.storage.Storage;
import java.util.logging.Logger;

public class Dealer extends Thread{
    private int period;
    private final Storage<Car> carStorage;
    protected final int id;

    private final Logger logger;

    public Dealer(Storage<Car> carStorage, int period, int id, Logger logger){
        this.carStorage = carStorage;
        this.period = period;
        this.id = id;
        this.logger = logger;
    }

    @Override
    public void run(){
        while (true){
            Part part;

            try{
                Thread.sleep(period);
                Car car; // = carStorage.get(), т.е. убрать со склада
                logger.info("Dealer " + id + " recieved: " + car.toString());
            }
            catch(InterruptedException e){
                break;
            }
        }
    }

    public void setPeriod(int period){
        this.period = period;
    }
}
