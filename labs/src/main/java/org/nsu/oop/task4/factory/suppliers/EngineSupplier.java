package org.nsu.oop.task4.factory.suppliers;

import org.nsu.oop.task4.factory.parts.Engine;
import org.nsu.oop.task4.factory.parts.Part;
import org.nsu.oop.task4.factory.storage.Storage;

public class EngineSupplier extends Supplier{

    public EngineSupplier(Storage<Part> storage) {
        super(storage, 30);
    }

    @Override
    public Part produce() {
        return new Engine(id++);
    }
}
