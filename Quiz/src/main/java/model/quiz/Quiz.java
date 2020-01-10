package model.quiz;

import model.Dictionary;
import model.question.ClosedQuestion;
import model.question.OpenedQuestion;
import model.question.Question;

import java.util.ArrayList;
import java.util.Random;

public abstract class Quiz {
    protected ArrayList<Question> questions;

    public Dictionary getDictionary() {
        return dictionary;
    }

    protected Dictionary dictionary;
    protected Question question;

    public Quiz(Dictionary dictionary) {
        this.dictionary = dictionary;
        generateQuestion();
    }

    public Question getQuestion() {
        return question;
    }

    public void generateQuestion(){
        Random random = new Random();
        boolean englishOrPolish = random.nextBoolean();
        boolean openedOrClosed = random.nextBoolean();
        if (openedOrClosed) {
            question = new OpenedQuestion(dictionary.getRandomWord(), englishOrPolish);
        } else {
            question = new ClosedQuestion(dictionary.getRandomWord(), dictionary.getRandomWords(3), englishOrPolish);
        }
    }
}
