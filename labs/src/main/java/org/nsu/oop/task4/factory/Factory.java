package org.nsu.oop.task4.factory;

import org.nsu.oop.task4.controller.FactoryEvent;
import org.nsu.oop.task4.factory.assemblyPlant.AssemblyPlant;
import org.nsu.oop.task4.factory.dealer.Dealer;
import org.nsu.oop.task4.factory.parts.*;
import org.nsu.oop.task4.factory.storage.Storage;
import org.nsu.oop.task4.factory.suppliers.AccessorySupplier;
import org.nsu.oop.task4.factory.suppliers.BodySupplier;
import org.nsu.oop.task4.factory.suppliers.EngineSupplier;
import org.nsu.oop.task4.pubSub.Subscriber;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;

public class Factory {
    private final Storage<Part> accessory_storage;
    private final Storage<Part> body_storage;
    private final Storage<Part> engine_storage;
    private final Storage<Car> car_storage;

    private final AccessorySupplier[] accessory_suppliers;
    private final BodySupplier body_supplier;
    private final EngineSupplier engine_supplier;
    private final Dealer[] car_dealers;

    private final AssemblyPlant assembly_plant;

    private final FactoryController factory_controller;

    public Factory(FactoryConfig config){
        engine_storage = new Storage<>(config.engine_storage_size, Engine.class);
        body_storage = new Storage<>(config.body_storage_size, Body.class);
        accessory_storage = new Storage<>(config.accessory_storage_size, Accessory.class);
        car_storage = new Storage<>(config.car_storage_size, Car.class);

        engine_supplier = new EngineSupplier(engine_storage);
        body_supplier = new BodySupplier(body_storage);

        accessory_suppliers = new AccessorySupplier[config.number_of_accessory_suppliers];
        for (int i = 0; i < config.number_of_accessory_suppliers; i++) {
            accessory_suppliers[i] = new AccessorySupplier(accessory_storage);
        }

        assembly_plant = new AssemblyPlant(config.number_of_workers, body_storage, engine_storage, accessory_storage, car_storage);

        Logger logger = null;
        if (config.is_logger_on) {
            logger = Logger.getLogger("Logger");

            try {
                FileHandler fh = new FileHandler("sales.log");
                logger.addHandler(fh);
            } catch (IOException e) {
                throw new RuntimeException("error while opening log file: " + e.getMessage());
            }
        }

        car_dealers = new Dealer[config.number_of_dealers];
        for (int i = 0; i < config.number_of_dealers; i++) {
            car_dealers[i] = new Dealer(car_storage, 10, i + 1, logger);
        }

        factory_controller = new FactoryController(assembly_plant, car_storage);
    }

    public void addSubscriber(Subscriber<FactoryEvent> subscriber) {
        engine_storage.addSubscriber(subscriber);
        body_storage.addSubscriber(subscriber);
        accessory_storage.addSubscriber(subscriber);
        car_storage.addSubscriber(subscriber);
    }

    public void launch() {
        engine_supplier.start();
        body_supplier.start();

        for (AccessorySupplier producer : accessory_suppliers) {
            producer.start();
        }

        for (Dealer dealer : car_dealers) {
            dealer.start();
        }

        factory_controller.start();
    }

    public void setEngineSpeed(int period) {
        engine_supplier.setPeriod(period);
    }

    public void setBodySpeed(int period) {
        body_supplier.setPeriod(period);
    }

    public void setAccessorySpeed(int period) {
        for (AccessorySupplier producer : accessory_suppliers) {
            producer.setPeriod(period);
        }
    }
}
