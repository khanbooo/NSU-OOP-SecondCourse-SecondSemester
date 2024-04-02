package org.nsu.oop.task1.answer;

public class Answer {
    private final Integer bulls;
    private final Integer cows;

    public Answer(Integer bulls, Integer cows){
        this.bulls = bulls;
        this.cows = cows;
    }
    public Integer getCows() {
        return cows;
    }

    public Integer getBulls() {
        return bulls;
    }
}
