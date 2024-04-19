package org.nsu.oop.task2.utilTest;


import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.nsu.oop.task2.error.ContextStackOperationException;
import org.nsu.oop.task2.utility.Context;

public class ContextTest {
    @Test
    void OperationsTest(){
        Context context = new Context();
        context.addVariable("x", 2.1);
        context.push(2.1);
        // contains variable
        assertTrue(context.containsVariable("x"));
        assertFalse(context.containsVariable("y"));
        // get variable
        assertEquals(2.1, context.getVariable("x"));
        // peek success, pop success
        try{
            assertEquals(2.1, context.peek());
            assertEquals(2.1, context.pop());
        } catch (ContextStackOperationException e){
            fail(e.getMessage());
        }
        // peek fail
        try{
            context.peek();
            fail("Stack is empty, but peek executed with success.");
        } catch (ContextStackOperationException ignored){}
        // pop fail
        try{
            context.pop();
            fail("Stack is empty, but pop executed with success.");
        } catch (ContextStackOperationException ignored){}
    }
}
