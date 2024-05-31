package org.nsu.oop.task3.pubSub;

public interface Subscriber <T>{
    void onEvent(T event);
}
