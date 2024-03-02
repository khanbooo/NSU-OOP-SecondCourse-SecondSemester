package org.nsu.oop.task1.opponent;

import org.nsu.oop.task1.answer.Answer;
import org.nsu.oop.task1.game.Game;

import java.util.*;

public class Opponent {
    private String s;
    private final HashMap<Character, Boolean> map;

    public Opponent(Game game){
        map = new HashMap<>();
        generate(game);
    }

    public Opponent(Integer length, String s){
        setS(length, s);
        map = new HashMap<>();
        fillTheMap(length, s);
    };

    public String getS() {
        return s;
    }

    public void setS(Integer length, String s) {
        this.s = s;
    }

    private void fillTheMap(Integer length, String s){
        for (int i = 0; i < length; i++){
            map.put(s.charAt(i), true);
        }
    }

    private void generate(Game game){
        Random rand = new Random(System.nanoTime());
        LinkedList<Character> drum = new LinkedList<>();
        for (char i = '0'; i <= '9'; i++){
            drum.add(i);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < game.getNumberLength(); i++){
            char chosenChar = drum.remove(rand.nextInt(drum.size()));
            sb.append(chosenChar);
        }
        s = sb.toString();
        fillTheMap(game.getNumberLength(), s);
    }

    private Answer compare(String s){
        Integer bulls = 0;
        Integer cows = 0;
        for (int i = 0; i < s.length(); i++){
            char firstStringAtI = s.charAt(i);
            char secondStringAtI = (this.s).charAt(i);
            if (firstStringAtI == secondStringAtI){
                bulls++;
            }
            else{
                if (map.get(firstStringAtI) != null){
                    cows++;
                }
            }
        }
        return new Answer(bulls, cows);
    }

    public Answer answer(String s){
        Answer answer = compare(s);
        System.out.printf("%d bulls, %d cows\n", answer.getBulls(), answer.getCows());
        return answer;
    }
}
