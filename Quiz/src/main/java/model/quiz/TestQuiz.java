package model.quiz;

import main.MainLauncher;
import model.Dictionary;
import model.builder.TestQuizBuilder;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Objects;
import java.util.Scanner;

public class TestQuiz extends Quiz {
    private int score;

    public TestQuiz(Dictionary dictionary, int questionsCount) {
        super(dictionary);
        score = 0;
        TestQuizBuilder testQuizBuilder = new TestQuizBuilder(this.dictionary);
        for (int i = 0; i < questionsCount; i++) {
            testQuizBuilder.createQuestion();
        }
        this.questions = testQuizBuilder.getQuestions();
    }

    public void updateScore() throws FileNotFoundException {
        File plik = new File(Objects.requireNonNull(MainLauncher.class.getClassLoader().getResource("ranking")).getFile());
        Scanner odczyt = new Scanner(plik);

        String[] rankingLevel = new String[6];
        String[] rankingScore = new String[6];

        String helpLevel;
        String helpScore;

        for(int i=0; i<6;i++){
            if(odczyt.hasNextLine()) {
                helpLevel = odczyt.nextLine();
                helpScore = odczyt.nextLine();
                if (helpLevel.equals(dictionary.getLevel().getName()) && Integer.parseInt(helpScore)<score) {
                    helpLevel = dictionary.getLevel().getName();
                    helpScore = Integer.toString(score);
                }
                rankingLevel[i] = helpLevel;
                rankingScore[i] = helpScore;
            }
        }
        odczyt.close();

        PrintWriter zapis = new PrintWriter(plik);

        for(int i=0;i<6;i++){
            zapis.println(rankingLevel[i]);
            zapis.println(rankingScore[i]);
        }
        zapis.close();

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
