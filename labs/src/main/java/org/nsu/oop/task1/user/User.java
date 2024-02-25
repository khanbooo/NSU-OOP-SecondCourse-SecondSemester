package org.nsu.oop.task1.user;

import org.nsu.oop.task1.checker.Checker;
import org.nsu.oop.task1.game.Game;

import java.util.Scanner;

public class User {

    public String guess(Game game){
        Scanner sc = new Scanner(System.in);
        Checker checker = new Checker();
        while (true){
            String s = sc.nextLine();
            if (!checker.validCheck(s, game)){
                System.out.printf("Bad input. Enter %d-digit number without repeating digits\n", game.getNumberLength());
                continue;
            }
            return s;
        }
    }
}
