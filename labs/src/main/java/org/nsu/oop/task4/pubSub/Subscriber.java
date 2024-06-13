package org.nsu.oop.task4.pubSub;

public interface Subscriber <T>{
    void onEvent(T event);
}
