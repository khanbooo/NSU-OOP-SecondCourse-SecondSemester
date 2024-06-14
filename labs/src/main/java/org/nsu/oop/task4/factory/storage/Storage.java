package org.nsu.oop.task4.factory.storage;

import org.nsu.oop.task4.controller.FactoryEvent;
import org.nsu.oop.task4.controller.StockChangeEvent;
import org.nsu.oop.task4.pubSub.Publisher;
import org.nsu.oop.task4.pubSub.Subscriber;

import java.util.ArrayList;
import java.util.List;

public class Storage <T> implements Publisher<StockChangeEvent> {
    private final int capacity;
    private int counter = 0;
    private final Class<?> storage_type;
    private Subscriber<FactoryEvent> subscriber = null;
    private final List<T> parts;

    public Storage(int capacity, Class<?> storage_type){
        this.capacity = capacity;
        this.storage_type = storage_type;
        parts = new ArrayList<>();
    }

    public void addSubscriber(Subscriber<FactoryEvent> subscriber){
        this.subscriber = subscriber;
    }

    public synchronized void load(T part) throws InterruptedException {
        while (isFull()){
            wait();
        }

        parts.add(part);
        counter++;

        if (subscriber != null) {
            publishChange();
        }
        notifyAll();
    }

    public synchronized T unload() throws InterruptedException {
        while (isEmpty()){
            wait();
        }

        T part = parts.remove(0);

        if (subscriber != null) {
            publishChange();
        }
        notifyAll();
        return part;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getCounter() {
        return counter;
    }

    public int getSize(){
        return parts.size();
    }

    boolean isFull(){
        return parts.size() == capacity;
    }

    boolean isEmpty(){
        return parts.isEmpty();
    }

    public Class<?> getStorage_type() {
        return storage_type;
    }

    @Override
    public void publish(StockChangeEvent event) {
        subscriber.onEvent(event);
    }

    private synchronized void publishChange() {
        publish(new StockChangeEvent(storage_type, getSize(), getCounter()));
    }
}
