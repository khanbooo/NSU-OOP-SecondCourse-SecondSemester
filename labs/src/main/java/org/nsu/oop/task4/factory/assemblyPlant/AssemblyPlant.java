package org.nsu.oop.task4.factory.assemblyPlant;

import org.nsu.oop.task4.factory.parts.*;
import org.nsu.oop.task4.factory.storage.Storage;
import org.nsu.oop.task4.threadPool.ThreadPool;

public class AssemblyPlant extends ThreadPool {
    private static final int period = 10;
    private final Storage<Car> car_storage;
    private final Storage<Part> engine_storage;
    private final Storage<Part> body_storage;
    private final Storage<Part> accessory_storage;

    public AssemblyPlant(
            int size,
            Storage<Part> body_storage,
            Storage<Part> engine_storage,
            Storage<Part> accessory_storage,
            Storage<Car> car_storage
    ) {
        super(size);
        this.body_storage = body_storage;
        this.engine_storage = engine_storage;
        this.accessory_storage = accessory_storage;
        this.car_storage = car_storage;
    }

    public void assemble() {
        addJobToQueue(() -> {
            try {
                Engine engine = (Engine) engine_storage.unload();
                Body body = (Body) body_storage.unload();
                Accessory accessory = (Accessory) accessory_storage.unload();

                Thread.sleep(period);
                Car car = new Car(engine, body, accessory);

                car_storage.load(car);
            } catch (InterruptedException ignored) {}
        });
    }
}
