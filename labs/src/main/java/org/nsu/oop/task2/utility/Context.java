package org.nsu.oop.task2.utility;

import org.nsu.oop.task2.error.ContextStackOperationException;

import java.util.EmptyStackException;
import java.util.HashMap;
import java.util.Stack;

public class Context {
    private final Stack<Double> stack = new Stack<>();
    private final HashMap<String, Double> variables = new HashMap<>();

    public Context() {}

    public void addVariable(String name, double value) {
        this.variables.put(name, value);
    }

    public boolean containsVariable(String name) {
        return variables.containsKey(name);
    }

    public double getVariable(String name) {
        return this.variables.get(name);
    }

    public void push(double number) {
        this.stack.push(number);
    }

    public double pop() throws ContextStackOperationException {
        try {
            return this.stack.pop();
        } catch (EmptyStackException e) {
            throw new ContextStackOperationException("Could not pop because stack is already empty.");
        }
    }

    public double peek() throws ContextStackOperationException {
        try {
            return this.stack.peek();
        } catch (EmptyStackException e) {
            throw new ContextStackOperationException("Could not peek because stack is empty.");
        }
    }
}
