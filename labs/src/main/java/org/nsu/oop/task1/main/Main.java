package org.nsu.oop.task1.main;

import org.nsu.oop.task1.game.Game;

public class Main {
    public static void main(String[] args) {
        Game bullsAndCows = new Game();
        bullsAndCows.start(args);
    }
}
