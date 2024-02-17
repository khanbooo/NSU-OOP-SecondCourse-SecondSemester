package org.nsu.oop.task1.user;

import org.nsu.oop.task1.checker.Checker;
import org.nsu.oop.task1.game.Game;

import java.util.Scanner;

public class User {
    public static String guess(){
        Scanner sc = new Scanner(System.in);
        String s = null;
        do {
            if (s != null) {
                System.out.printf("Bad input. Enter %d-digit number without repeating digits\n", Game.getLENGTH());
            }
            s = sc.nextLine();
        }
        while (!Checker.validCheck(s));
        return s;
    }
}
