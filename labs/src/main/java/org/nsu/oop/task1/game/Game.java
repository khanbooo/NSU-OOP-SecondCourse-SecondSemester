package org.nsu.oop.task1.game;

import org.nsu.oop.task1.answer.Answer;
import org.nsu.oop.task1.opponent.Opponent;
import org.nsu.oop.task1.user.User;

public class Game {
    private int numberLength;

    public void setNumberLength(int numberLength) {
        this.numberLength = numberLength;
    }

    public int getNumberLength() {
        return numberLength;
    }

    public void start(){
        Opponent opponent = new Opponent(this);
        User user = new User();


        while (true){
            String guess = user.guess(this);
            Answer answer = opponent.answer(guess);
            if (answer.getBulls() == numberLength && answer.getCows() == 0){
                break;
            }
        }
    }
}
