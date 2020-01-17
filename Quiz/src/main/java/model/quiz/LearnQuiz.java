package model.quiz;

import model.Dictionary;
import model.builder.LearnQuizBuilder;
import model.progress.Progress;

public class LearnQuiz extends Quiz {
    public LearnQuiz(Dictionary dictionary, int questionsCount) {
        super(dictionary);
        LearnQuizBuilder learnQuizBuilder = new LearnQuizBuilder(this.dictionary, Progress.getInstance());
        for (int i = 0; i < questionsCount; i++) {
            learnQuizBuilder.createQuestion();
        }
        this.questions = learnQuizBuilder.getQuestions();
    }
}
