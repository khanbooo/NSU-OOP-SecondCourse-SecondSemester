package org.nsu.oop.task4.factory.suppliers;

import org.nsu.oop.task4.factory.parts.Body;
import org.nsu.oop.task4.factory.parts.Part;
import org.nsu.oop.task4.factory.storage.Storage;

public class BodySupplier extends Supplier{
    public BodySupplier(Storage<Part> storage) {
        super(storage, 30);
    }

    @Override
    public Part produce() {
        return new Body(id++);
    }
}
