package org.nsu.oop.task1.checker;

import org.nsu.oop.task1.game.Game;

public class Checker {
    public static boolean validCheck(String s){
        if (s.length() != Game.getLENGTH()){
            return false;
        }
        boolean[] used = new boolean[10];
        for (int i = 0; i < Game.getLENGTH(); i++){
            if (!Character.isDigit(s.charAt(i))){
                return false;
            }
            int digit = Character.getNumericValue(s.charAt(i));
            if (used[digit]){
                return false;
            }
            used[digit] = true;
        }
        return true;
    }
}
