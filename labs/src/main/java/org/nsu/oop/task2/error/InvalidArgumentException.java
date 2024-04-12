package org.nsu.oop.task2.error;

public class InvalidArgumentException extends Throwable{
    public InvalidArgumentException(String message){
        super(message);
    }
}
