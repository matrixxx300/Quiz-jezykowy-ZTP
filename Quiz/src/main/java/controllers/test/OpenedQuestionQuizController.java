package controllers.test;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import main.Main;
import models.Dictionary;
import models.question.OpenedQuestion;

import java.io.IOException;
import java.util.Random;

import static controllers.test.TestQuizLevelSelectController.count;
import static controllers.test.TestQuizLevelSelectController.score;

public class OpenedQuestionQuizController {
    public Stage window;

    //TODO Do modelu
    private Dictionary dictionary;
    public OpenedQuestion question;
    // ------------------------------

    @FXML
    public TextField answerTextField;
    public Text questionText;

    public OpenedQuestionQuizController(Dictionary dictionary) throws IOException {

        //TODO Do modelu
        this.dictionary = dictionary;
        Random random = new Random();
        boolean englishOrPolish = random.nextBoolean();
        question = new OpenedQuestion(dictionary.getRandomWord(), englishOrPolish);
        // ------------------------------

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/TestQuiz/OpenedQuestionQuizView.fxml"));
        loader.setController(this);
        this.window = Main.window;
        this.window.setScene(new Scene(loader.load()));
        this.window.setTitle("Test otwarty");
        this.window.show();
    }

    @FXML
    public void initialize() {
        questionText.setText(question.getQuestionText());
    }

    public void next() throws Exception {
        if (answerTextField.getText().equals(question.getCorrectAnswer())) {
            score++;
        }
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

    public void back() throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/QuizSelectView.fxml"));
        window.setScene(new Scene(root));
        window.show();
    }
}
