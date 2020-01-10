package model.quiz;

import model.Dictionary;

public class TestQuiz extends Quiz {
    private int score;

    public TestQuiz(Dictionary dictionary) {
        super(dictionary);
        score = 0;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void incrementScore(int value) {
        score += value;
    }
}
