package org.nsu.oop.task1.game;

import org.nsu.oop.task1.opponent.Opponent;
import org.nsu.oop.task1.turn.Turn;
import org.nsu.oop.task1.user.User;

public class Game {
    private int numberLength;

    public void setNumberLength(int numberLength) {
        this.numberLength = numberLength;
    }

    public int getNumberLength() {
        return numberLength;
    }

    public void start(String[] args){
         numberLength = Integer.parseInt(args[1]);
         Opponent computer = new Opponent(this);
         Turn turn = new Turn();
         User user = new User();
         do {
            turn.nextTurn(this, computer, user);
         }
         while (!turn.getIsLast());
    }
}
