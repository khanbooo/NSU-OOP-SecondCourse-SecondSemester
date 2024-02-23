package org.nsu.oop.task1.user;

import org.nsu.oop.task1.checker.Checker;
import org.nsu.oop.task1.game.Game;

import java.util.Scanner;

public class User {

    public String guess(Game game){
        Scanner sc = new Scanner(System.in);
        String s = null;
        Checker checker = new Checker();
        do {
            if (s != null) {
                System.out.printf("Bad input. Enter %d-digit number without repeating digits\n", game.getNumberLength());
            }
            s = sc.nextLine();
        }
        while (!checker.validCheck(s, game));
        return s;
    }
}
