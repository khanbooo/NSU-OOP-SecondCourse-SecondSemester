package org.nsu.oop.task1.opponentTests;

import org.junit.Assert;
import org.junit.Test;
import org.nsu.oop.task1.answer.Answer;
import org.nsu.oop.task1.checker.Checker;
import org.nsu.oop.task1.opponent.Opponent;
import org.nsu.oop.task1.game.Game;

public class OpponentTests {
    @Test
    public void validGenerationTest(){
        Game exampleGame = new Game();
        exampleGame.setNumberLength(4);
        Opponent exampleOpponent = new Opponent(exampleGame.getNumberLength());
        Checker checker = new Checker();
        Assert.assertTrue(checker.validCheck(exampleOpponent.getS(), exampleGame.getNumberLength()));
    }

    @Test
    public void validBullsAndCowsCounter(){
        Opponent opp = new Opponent(4, "1234");
        Answer answer = opp.answer("1234");
        Answer correctAnswer = new Answer(4, 0);
        Assert.assertArrayEquals(new Integer[]{answer.getBulls(), answer.getCows()},
                new Integer[]{correctAnswer.getBulls(), correctAnswer.getCows()});


        answer = opp.answer("4321");
        correctAnswer = new Answer(0, 4);
        Assert.assertArrayEquals(new Integer[]{answer.getBulls(), answer.getCows()},
                new Integer[]{correctAnswer.getBulls(), correctAnswer.getCows()});


        answer = opp.answer("5678");
        correctAnswer = new Answer(0, 0);
        Assert.assertArrayEquals(new Integer[]{answer.getBulls(), answer.getCows()},
                new Integer[]{correctAnswer.getBulls(), correctAnswer.getCows()});


        answer = opp.answer("1243");
        correctAnswer = new Answer(2, 2);
        Assert.assertArrayEquals(new Integer[]{answer.getBulls(), answer.getCows()},
                new Integer[]{correctAnswer.getBulls(), correctAnswer.getCows()});


        answer = opp.answer("5631");
        correctAnswer = new Answer(1, 1);
        Assert.assertArrayEquals(new Integer[]{answer.getBulls(), answer.getCows()},
                new Integer[]{correctAnswer.getBulls(), correctAnswer.getCows()});
    }
}
