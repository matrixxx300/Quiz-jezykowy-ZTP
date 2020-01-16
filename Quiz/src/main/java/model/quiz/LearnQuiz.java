package model.quiz;

import model.Dictionary;
import model.Word;

public class LearnQuiz extends Quiz {
    public LearnQuiz(Dictionary dictionary) {
        super(dictionary);
    }

    public Word getCorrectWord(){
        return question.getCorrectWord();
    }
}
