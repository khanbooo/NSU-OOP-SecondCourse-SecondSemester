package org.nsu.oop.task4.factory.dealer;

import org.nsu.oop.task4.factory.parts.Car;
import org.nsu.oop.task4.factory.storage.Storage;
import java.util.logging.Logger;

public class Dealer extends Thread{
    private int period;
    private final Storage<Car> car_storage;
    protected final int id;
    private final Logger logger;

    public Dealer(Storage<Car> car_storage, int period, int id, Logger logger){
        this.car_storage = car_storage;
        this.period = period;
        this.id = id;
        this.logger = logger;
    }

    @Override
    public void run(){
        while (true){
            try{
                Thread.sleep(period);
                Car car = car_storage.unload();
                if (logger != null){
                    logger.info("Dealer " + id + " received: " + car.toString());
                }
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
