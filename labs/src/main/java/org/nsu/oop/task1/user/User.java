package org.nsu.oop.task1.user;

import org.nsu.oop.task1.checker.Checker;

import java.util.Scanner;

public class User {

    public String guess(int numberLength){
        Scanner sc = new Scanner(System.in);
        Checker checker = new Checker();
        while (true){
            String s = sc.nextLine();
            if (!checker.validCheck(s, numberLength)){
                System.out.printf("Bad input. Enter %d-digit number without repeating digits\n", numberLength);
                continue;
            }
            return s;
        }
    }
}
