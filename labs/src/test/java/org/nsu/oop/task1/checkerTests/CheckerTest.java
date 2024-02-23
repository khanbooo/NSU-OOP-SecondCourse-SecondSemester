package org.nsu.oop.task1.checkerTests;

import org.junit.Assert;
import org.junit.Test;
import org.nsu.oop.task1.checker.Checker;
import org.nsu.oop.task1.game.Game;

public class CheckerTest {
    @Test
    public void test(){
        Game exampleGame = new Game();
        exampleGame.setNumberLength(4);
        Checker checker = new Checker();
        Assert.assertTrue(checker.validCheck("1234", exampleGame));
        Assert.assertFalse(checker.validCheck("12345", exampleGame));
        Assert.assertFalse(checker.validCheck("1102", exampleGame));
        Assert.assertFalse(checker.validCheck("1111", exampleGame));
        Assert.assertFalse(checker.validCheck("aSd1", exampleGame));
    }
}
