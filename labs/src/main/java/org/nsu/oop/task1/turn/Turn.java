package org.nsu.oop.task1.turn;

import org.nsu.oop.task1.user.User;
import org.nsu.oop.task1.game.Game;
import org.nsu.oop.task1.opponent.Opponent;

public class Turn {
    private boolean isLast = false;

    public boolean getIsLast(){
        return isLast;
    }

    public void nextTurn(Game game, Opponent opponent, User user){
        String guess = user.guess(game);
        byte[] bullsAndCows = opponent.answer(guess);
        if (bullsAndCows[0] == game.getNumberLength() && bullsAndCows[1] == 0){
            isLast = true;
        }
    }
}
