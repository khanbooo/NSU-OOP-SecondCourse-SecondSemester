package org.nsu.oop.task1.opponentTests;

import org.junit.Assert;
import org.junit.Test;
import org.nsu.oop.task1.checker.Checker;
import org.nsu.oop.task1.opponent.Opponent;
import org.nsu.oop.task1.game.Game;

public class OpponentTests {
    @Test
    public void test(){
        Game exampleGame = new Game();
        exampleGame.setNumberLength(4);
        Opponent exampleOpponent = new Opponent(exampleGame);
        Checker checker = new Checker();
        Assert.assertTrue(checker.validCheck(exampleOpponent.getS(), exampleGame));
    }
}
