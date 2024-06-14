package org.nsu.oop.task4.factory;

import org.nsu.oop.task4.factory.assemblyPlant.AssemblyPlant;
import org.nsu.oop.task4.factory.parts.Car;
import org.nsu.oop.task4.factory.storage.Storage;

public class FactoryController extends Thread {
    private final AssemblyPlant assembly_plant;
    private final Storage<Car> car_storage;

    public FactoryController(AssemblyPlant assembly_plant, Storage<Car> car_storage) {
        this.assembly_plant = assembly_plant;
        this.car_storage = car_storage;
    }

    @Override
    public void run(){
        while (true){
            if (car_storage.getSize() < car_storage.getCapacity() / 2
                    && assembly_plant.getQueueSize() < 100) {
                for (int i = 0; i < assembly_plant.getNumber_of_workers(); i++) {
                    assembly_plant.assemble();
                }
            }

            synchronized (car_storage) {
                try {
                    car_storage.wait();
                } catch (InterruptedException e) {
                    break;
                }
            }
        }
    }
}
