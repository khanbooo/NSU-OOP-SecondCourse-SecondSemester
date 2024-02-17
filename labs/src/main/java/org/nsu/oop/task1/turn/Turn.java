package org.nsu.oop.task1.turn;

import org.nsu.oop.task1.user.User;
import org.nsu.oop.task1.game.Game;
import org.nsu.oop.task1.opponent.Opponent;

public class Turn {
    private static boolean isLast = false;

    public static boolean getIsLast(){
        return isLast;
    }

    public static void nextTurn(Opponent opponent){
        String guess = User.guess();
        byte[] bullsAndCows = opponent.answer(guess);
        if (bullsAndCows[0] == Game.getLENGTH() && bullsAndCows[1] == 0){
            isLast = true;
        }
    }
}
