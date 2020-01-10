package controller.learn;

import controller.question.QuestionController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import main.Main;
import model.question.ClosedQuestion;
import model.quiz.Quiz;

import java.io.IOException;

public class ClosedQuestionQuizController extends QuestionController {

    @FXML
    public Button buttonA, buttonB, buttonC, buttonD;
    public Label respondLabel;

    public ClosedQuestionQuizController(Quiz quiz) throws IOException {
        this.quiz = quiz;

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/LearnQuiz/ClosedQuestionQuizView.fxml"));
        loader.setController(this);
        this.window = Main.window;
        this.window.setScene(new Scene(loader.load()));
        this.window.setTitle("Nauka słówek - pytania zamknięte");
        this.window.show();
    }

    @FXML
    @Override
    public void initialize() {
        String[] answerArray = ((ClosedQuestion) this.quiz.getQuestion()).toAnswerArray();

        buttonA.setText(answerArray[0]);
        buttonB.setText(answerArray[1]);
        buttonC.setText(answerArray[2]);
        buttonD.setText(answerArray[3]);
    }



    public void checkA(ActionEvent actionEvent) {
        if (buttonA.getText().equals(quiz.getQuestion().getCorrectAnswer())) {
            respondLabel.setText("Dobrze!");
        } else respondLabel.setText("Źle!");
    }

    public void checkB(ActionEvent actionEvent) {
        if (buttonB.getText().equals(quiz.getQuestion().getCorrectAnswer())) {
            respondLabel.setText("Dobrze!");
        } else respondLabel.setText("Źle!");
    }

    public void checkC(ActionEvent actionEvent) {
        if (buttonC.getText().equals(quiz.getQuestion().getCorrectAnswer())) {
            respondLabel.setText("Dobrze!");
        } else respondLabel.setText("Źle!");
    }

    public void checkD(ActionEvent actionEvent) {
        if (buttonD.getText().equals(quiz.getQuestion().getCorrectAnswer())) {
            respondLabel.setText("Dobrze!");
        } else respondLabel.setText("Źle!");
    }

    public void back(ActionEvent actionEvent) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/QuizSelectView.fxml"));
        window.setScene(new Scene(root));
        window.show();
    }
}
