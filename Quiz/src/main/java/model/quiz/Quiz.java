package model.quiz;

import model.Dictionary;
import model.question.Question;

import java.util.LinkedList;

public abstract class Quiz {
    protected LinkedList<Question> questions;
    protected Dictionary dictionary;
    protected int currentQuestionNumber;

    public Quiz(Dictionary dictionary) {
        this.dictionary = dictionary;
        currentQuestionNumber = 0;
    }

    public int getCurrentQuestionNumber() {
        return currentQuestionNumber;
    }

    public LinkedList<Question> getQuestions() {
        return questions;
    }

    public Dictionary getDictionary() {
        return dictionary;
    }

    public Question getCurrentQuestion() {
        return questions.get(currentQuestionNumber);
    }

    public void nextQuestion() {
        currentQuestionNumber++;
    }
}
