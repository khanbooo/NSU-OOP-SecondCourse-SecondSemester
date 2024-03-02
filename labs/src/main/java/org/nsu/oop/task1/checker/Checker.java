package org.nsu.oop.task1.checker;

public class Checker {
    public boolean validCheck(String s, int numberLength){
        if (s.length() != numberLength){
            return false;
        }
        boolean[] used = new boolean[10];
        for (int i = 0; i < numberLength; i++){
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
