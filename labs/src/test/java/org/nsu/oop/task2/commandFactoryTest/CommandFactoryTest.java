package org.nsu.oop.task2.commandFactoryTest;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.nsu.oop.task2.error.CommandCreationException;
import org.nsu.oop.task2.error.ConfigException;
import org.nsu.oop.task2.factory.CommandFactory;
import org.nsu.oop.task2.command.*;

public class CommandFactoryTest {

    @Test
    void commandCreationTest() {
        try{
            CommandFactory cf = new CommandFactory();
            cf.init();
            assertEquals(CommandDefine.class, cf.createCommandInstanceByItsName("DEFINE").getClass());
            assertEquals(CommandPop.class, cf.createCommandInstanceByItsName("POP").getClass());
            assertEquals(CommandPrint.class, cf.createCommandInstanceByItsName("PRINT").getClass());
            assertEquals(CommandPush.class, cf.createCommandInstanceByItsName("PUSH").getClass());
            assertEquals(CommandSqrt.class, cf.createCommandInstanceByItsName("SQRT").getClass());
            assertEquals(CommandDivide.class, cf.createCommandInstanceByItsName("/").getClass());
            assertEquals(CommandMinus.class, cf.createCommandInstanceByItsName("-").getClass());
            assertEquals(CommandMultiply.class, cf.createCommandInstanceByItsName("*").getClass());
            assertEquals(CommandPlus.class, cf.createCommandInstanceByItsName("+").getClass());
        } catch (CommandCreationException | ConfigException e){
            fail(e.getMessage());
        }
    }
}
