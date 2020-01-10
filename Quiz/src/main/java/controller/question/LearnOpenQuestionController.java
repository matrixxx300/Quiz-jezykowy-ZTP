package controller.question;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import main.Main;
import model.quiz.Quiz;

import java.io.IOException;

public class LearnOpenQuestionController extends QuestionController {

    @FXML
    public TextField answerTextField;
    public Label respondLabel;

    public LearnOpenQuestionController(Quiz quiz) throws IOException {
        this.quiz = quiz;

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/LearnQuiz/OpenedQuestionQuizView.fxml"));
        loader.setController(this);
        this.window = Main.window;
        this.window.setScene(new Scene(loader.load()));
        this.window.setTitle("Nauka słówek - pytania otwarte");
        this.window.show();
    }

    public void back() throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/QuizSelectView.fxml"));
        window.setScene(new Scene(root));
        window.show();
    }

    public void check() {
        if (answerTextField.getText().equals(quiz.getQuestion().getCorrectAnswer())) {
            respondLabel.setText("Dobrze!");
        } else respondLabel.setText("Źle!");
    }
}
