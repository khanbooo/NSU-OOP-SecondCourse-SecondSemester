package org.nsu.oop.task1.opponent;

import org.nsu.oop.task1.game.Game;

import java.util.*;

public class Opponent {
    private String s;
    private final HashMap<Character, Boolean> map;

    public Opponent(){
        map = new HashMap<>();
        generate();
    }

//    public Opponent(String S){
//
//    }


    private void generate(){
        Random rand = new Random(System.nanoTime());
        LinkedList<Character> drum = new LinkedList<>();
        for (char i = '0'; i <= '9'; i++){
            drum.add(i);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Game.getLENGTH(); i++){
            char chosenChar = drum.remove(rand.nextInt(drum.size()));
            sb.append(chosenChar);
            map.put(chosenChar, true);
        }
        s = sb.toString();
    }

    private byte[] compare(String s){
        byte bulls = 0;
        byte cows = 0;
        for (byte i = 0; i < s.length(); i++){
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
        return new byte[]{bulls, cows};
    }

    public byte[] answer(String s){
        byte[] answer = compare(s);
        System.out.printf("%d bulls, %d cows\n", answer[0], answer[1]);
        return answer;
    }
}
