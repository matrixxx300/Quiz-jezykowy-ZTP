package model.builder;

import model.Dictionary;
import model.progress.Progress;
import model.question.Question;

import java.util.LinkedList;

abstract class QuizBuilder {
    protected LinkedList<Question> questions;
    protected Dictionary dictionary;
    protected Progress progress;

    public QuizBuilder(Dictionary dictionary) {
        this.questions = new LinkedList<>();
        this.dictionary = dictionary;
        this.progress = Progress.getInstance();
    }

    public abstract void createQuestions();

    public abstract void createQuestion();

    public LinkedList<Question> getQuestions() {
        return this.questions;
    }
}
