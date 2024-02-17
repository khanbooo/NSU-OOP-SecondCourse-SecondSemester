package org.nsu.oop.task1.checkerTests;
//import junit.framework.Assert;
import org.junit.Assert;
import org.junit.Test;
import org.nsu.oop.task1.checker.Checker;
import org.nsu.oop.task1.game.Game;

public class CheckerTest {
    @Test
    public void test(){
        Game.setLENGTH(4);
        Assert.assertTrue(Checker.validCheck("1234"));
        Assert.assertFalse(Checker.validCheck("12345"));
        Assert.assertFalse(Checker.validCheck("1102"));
        Assert.assertFalse(Checker.validCheck("1111"));
        Assert.assertFalse(Checker.validCheck("aSd1"));
    }
}
