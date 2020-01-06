package controllers.learn;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import main.Main;
import models.Dictionary;
import models.question.ClosedQuestion;

import java.io.IOException;
import java.util.Random;

public class ClosedQuestionQuizController {
    public Stage window;

    //TODO Do modelu
    private Dictionary dictionary;
    private ClosedQuestion question;
    // ------------------------------

    @FXML
    public Button buttonA, buttonB, buttonC, buttonD;
    public Label respondLabel;
    public Text questionText;

    public ClosedQuestionQuizController(Dictionary dictionary) throws IOException {
        //TODO Do modelu
        this.dictionary = dictionary;
        Random random = new Random();
        boolean englishOrPolish = random.nextBoolean();
        question = new ClosedQuestion(dictionary.getRandomWord(), dictionary.getRandomWords(3), englishOrPolish);
        // ------------------------------

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/LearnQuiz/ClosedQuestionQuizView.fxml"));
        loader.setController(this);
        this.window = Main.window;
        this.window.setScene(new Scene(loader.load()));
        this.window.setTitle("Nauka słówek - pytania zamknięte");
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

    public void next(ActionEvent actionEvent) throws Exception {
        int type = new Random().nextInt(2);
        if (type == 0) {
            ClosedQuestionQuizController closedQuestionQuizController = new ClosedQuestionQuizController(dictionary);
        } else if (type == 1) {
            OpenedQuestionQuizController openedQuestionQuizController = new OpenedQuestionQuizController(dictionary);
        }
    }

    public void checkA(ActionEvent actionEvent) {
        if (buttonA.getText().equals(question.getCorrectAnswer())) {
            respondLabel.setText("Dobrze!");
        } else respondLabel.setText("Źle!");
    }

    public void checkB(ActionEvent actionEvent) {
        if (buttonB.getText().equals(question.getCorrectAnswer())) {
            respondLabel.setText("Dobrze!");
        } else respondLabel.setText("Źle!");
    }

    public void checkC(ActionEvent actionEvent) {
        if (buttonC.getText().equals(question.getCorrectAnswer())) {
            respondLabel.setText("Dobrze!");
        } else respondLabel.setText("Źle!");
    }

    public void checkD(ActionEvent actionEvent) {
        if (buttonD.getText().equals(question.getCorrectAnswer())) {
            respondLabel.setText("Dobrze!");
        } else respondLabel.setText("Źle!");
    }

    public void back(ActionEvent actionEvent) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/QuizSelectView.fxml"));
        window.setScene(new Scene(root));
        window.show();
    }
}
