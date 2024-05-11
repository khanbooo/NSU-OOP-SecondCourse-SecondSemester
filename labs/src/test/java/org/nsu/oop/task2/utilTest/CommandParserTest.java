package org.nsu.oop.task2.utilTest;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.nsu.oop.task2.utility.CommandParser;

public class CommandParserTest {
    @Test
    void emptyStringTest(){
        CommandParser cp = new CommandParser(null);
        cp.parse();
        assertNull(cp.getCommandName());
        assertNull(cp.getArgs());
    }

    @Test
    void normalStringTest(){
        CommandParser cp = new CommandParser("Abc 12 45");
        cp.parse();
        assertEquals("Abc", cp.getCommandName());
        assertArrayEquals(new String[]{"12", "45"}, cp.getArgs());
    }
}
