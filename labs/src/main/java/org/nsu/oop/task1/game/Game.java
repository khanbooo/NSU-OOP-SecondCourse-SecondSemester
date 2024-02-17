package org.nsu.oop.task1.game;

import org.nsu.oop.task1.opponent.Opponent;
import org.nsu.oop.task1.turn.Turn;

public class Game {
    private static int LENGTH;

    public static void setLENGTH(int LENGTH) {
        Game.LENGTH = LENGTH;
    }

    public static int getLENGTH() {
        return LENGTH;
    }

    public static void main(String[] args){
         LENGTH = Integer.parseInt(args[1]);
         Opponent computer = new Opponent();
         do {
            Turn.nextTurn(computer);
         }
         while (!Turn.getIsLast());
    }
}
