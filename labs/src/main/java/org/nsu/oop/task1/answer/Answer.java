package org.nsu.oop.task1.answer;

public class Answer {
    private Integer bulls;
    private Integer cows;

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

    public void setBulls(Integer bulls) {
        this.bulls = bulls;
    }

    public void setCows(Integer cows) {
        this.cows = cows;
    }
}
