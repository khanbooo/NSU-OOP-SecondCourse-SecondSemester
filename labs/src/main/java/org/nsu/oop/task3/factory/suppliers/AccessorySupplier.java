package org.nsu.oop.task3.factory.suppliers;

import org.nsu.oop.task3.factory.parts.Accessory;
import org.nsu.oop.task3.factory.parts.Part;
import org.nsu.oop.task3.factory.storage.Storage;

public class AccessorySupplier extends Supplier{
    public AccessorySupplier(Storage<Part> storage) {
        super(storage, 30);
    }

    @Override
    public Part produce() {
        return new Accessory(id++);
    }
}
