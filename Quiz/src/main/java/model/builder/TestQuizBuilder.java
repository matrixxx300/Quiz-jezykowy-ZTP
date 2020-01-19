package model.builder;

import model.Dictionary;
import model.question.ClosedQuestion;
import model.question.OpenedQuestion;
import model.question.Question;

import java.util.Random;

public class TestQuizBuilder extends QuizBuilder {

    public TestQuizBuilder(Dictionary dictionary) {
        super(dictionary);
    }

    @Override
    public void createQuestions() {
        int questionCount = 10;
        for (int i = 0; i < questionCount; i++) {
            createQuestion();
        }
    }

    @Override
    public void createQuestion() {
        Question question;
        Random random = new Random();
        boolean englishOrPolish = random.nextBoolean();
        boolean openedOrClosed = random.nextBoolean();
        if (openedOrClosed) {
            question = new OpenedQuestion(dictionary.getRandomWord(), englishOrPolish);
        } else {
            question = new ClosedQuestion(dictionary.getRandomWord(), dictionary.getRandomWords(3), englishOrPolish);
        }
        questions.add(question);
    }

}
