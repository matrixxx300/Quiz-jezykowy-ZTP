package model.builder;

import model.Dictionary;
import model.Word;
import model.progress.Progress;
import model.question.ClosedQuestion;
import model.question.OpenedQuestion;
import model.question.Question;

import java.util.Random;

public class LearnQuizBuilder extends QuizBuilder {
    boolean firstQuestion;

    public LearnQuizBuilder(Dictionary dictionary, Progress progress) {
        super(dictionary);
        firstQuestion = true;
    }

    @Override
    public void createQuestion() {
        Question question;
        Random random = new Random();
        boolean englishOrPolish = random.nextBoolean();
        boolean openedOrClosed = random.nextBoolean();
        Word weakestWord;

        do {
            weakestWord = progress.getWeakestWord(this.dictionary.getLevel(), firstQuestion);
            firstQuestion = false;
        } while (isWordInQuiestions(weakestWord));


        if (openedOrClosed) {
            question = new OpenedQuestion(weakestWord, englishOrPolish);
        } else {
            question = new ClosedQuestion(weakestWord, dictionary.getRandomWords(3), englishOrPolish);
        }
        questions.add(question);
    }

    private boolean isWordInQuiestions(Word word) {
        if (this.questions == null) return false;
        for (Question question : this.questions) {
            if (question.getCorrectWord() == word) return true;
        }
        return false;
    }
}
