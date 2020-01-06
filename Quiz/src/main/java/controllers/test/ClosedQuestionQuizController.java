package controllers.test;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import main.Main;
import models.Dictionary;
import models.question.ClosedQuestion;

import java.io.IOException;
import java.util.Random;

import static controllers.test.TestQuizLevelSelectController.count;
import static controllers.test.TestQuizLevelSelectController.score;

public class ClosedQuestionQuizController {
    public Stage window;

    //TODO Do modelu
    private Dictionary dictionary;
    private ClosedQuestion question;
    // ------------------------------

    @FXML
    public Button buttonA, buttonB, buttonC, buttonD;
    public Text questionText;

    public ClosedQuestionQuizController(Dictionary dictionary) throws IOException {
        //TODO Do modelu
        this.dictionary = dictionary;
        Random random = new Random();
        boolean englishOrPolish = random.nextBoolean();
        question = new ClosedQuestion(dictionary.getRandomWord(), dictionary.getRandomWords(3), englishOrPolish);
        // ------------------------------

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/TestQuiz/ClosedQuestionQuizView.fxml"));
        loader.setController(this);
        this.window = Main.window;
        this.window.setScene(new Scene(loader.load()));
        this.window.setTitle("Test zamknięty");
        this.window.show();
    }

    @FXML
    public void initialize() {
        questionText.setText(question.getQuestionText());
        String[] answerArray = question.toAnswerArray();

        buttonA.setText(answerArray[0]);
        buttonB.setText(answerArray[1]);
        buttonC.setText(answerArray[2]);
        buttonD.setText(answerArray[3]);
    }

    public void next() throws Exception {
        if (count == 9) {
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/TestQuiz/EndTestQuizView.fxml"));
            window.setScene(new Scene(root));
            window.show();
        } else {
            count++;
            int type = new Random().nextInt(2);
            if (type == 0) {
                ClosedQuestionQuizController closedQuestionQuizController = new ClosedQuestionQuizController(this.dictionary);
            } else if (type == 1) {
                OpenedQuestionQuizController openedQuestionQuizController = new OpenedQuestionQuizController(this.dictionary);
            }
        }
    }

    public void checkA() throws Exception {
        if (buttonA.getText().equals(question.getCorrectAnswer())) {
            score++;
        }
        next();
    }

    public void checkB() throws Exception {
        if (buttonB.getText().equals(question.getCorrectAnswer())) {
            score++;
        }
        next();
    }

    public void checkC() throws Exception {
        if (buttonC.getText().equals(question.getCorrectAnswer())) {
            score++;
        }
        next();
    }

    public void checkD() throws Exception {
        if (buttonD.getText().equals(question.getCorrectAnswer())) {
            score++;
        }
        next();
    }
}
