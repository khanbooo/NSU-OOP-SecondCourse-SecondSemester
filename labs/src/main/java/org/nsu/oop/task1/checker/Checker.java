package org.nsu.oop.task1.checker;

import org.nsu.oop.task1.game.Game;

public class Checker {
    public boolean validCheck(String s, Game game){
        if (s.length() != game.getNumberLength()){
            return false;
        }
        boolean[] used = new boolean[10];
        for (int i = 0; i < game.getNumberLength(); i++){
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
