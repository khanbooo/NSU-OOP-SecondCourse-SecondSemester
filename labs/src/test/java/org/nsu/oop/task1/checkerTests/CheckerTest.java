package org.nsu.oop.task1.checkerTests;

import org.junit.Assert;
import org.junit.Test;
import org.nsu.oop.task1.checker.Checker;
import org.nsu.oop.task1.game.Game;

public class CheckerTest {
    @Test
    public void normalTest(){
        Game exampleGame = new Game();
        exampleGame.setNumberLength(4);
        Checker checker = new Checker();
        Assert.assertTrue(checker.validCheck("1234", exampleGame.getNumberLength()));

    }

    @Test
    public void tooLong(){
        Game exampleGame = new Game();
        exampleGame.setNumberLength(4);
        Checker checker = new Checker();
        Assert.assertFalse(checker.validCheck("12345", exampleGame.getNumberLength()));

    }

    @Test
    public void tooShort(){
        Game exampleGame = new Game();
        exampleGame.setNumberLength(4);
        Checker checker = new Checker();
        Assert.assertFalse(checker.validCheck("123", exampleGame.getNumberLength()));
    }

    @Test
    public void someSameDigits(){
        Game exampleGame = new Game();
        exampleGame.setNumberLength(4);
        Checker checker = new Checker();
        Assert.assertFalse(checker.validCheck("1102", exampleGame.getNumberLength()));
    }

    @Test
    public void allSameDigits(){
        Game exampleGame = new Game();
        exampleGame.setNumberLength(4);
        Checker checker = new Checker();
        Assert.assertFalse(checker.validCheck("1111", exampleGame.getNumberLength()));
    }

    @Test
    public void containsNonDigitSymbols(){
        Game exampleGame = new Game();
        exampleGame.setNumberLength(4);
        Checker checker = new Checker();
        Assert.assertFalse(checker.validCheck("aSd1", exampleGame.getNumberLength()));
    }
}
