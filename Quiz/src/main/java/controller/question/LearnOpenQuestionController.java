package controller.question;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import main.Main;
import model.Progress;
import model.quiz.Quiz;

import java.io.IOException;

public class LearnOpenQuestionController extends QuestionController {
    @FXML
    public TextField answerTextField;
    public Label respondLabel;

    public LearnOpenQuestionController(Quiz quiz, Progress progress) throws IOException {
        this.quiz = quiz;
        this.progress = progress;

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/LearnQuiz/OpenedQuestionQuizView.fxml"));
        loader.setController(this);
        this.window = Main.window;
        this.window.setScene(new Scene(loader.load()));
        this.window.setTitle("Nauka słówek " + quiz.getDictionary().getLevel().getName() + " - pytanie otwarte");
        this.window.show();
    }

    public void check() {
        if (answerTextField.getText().equals(quiz.getQuestion().getCorrectAnswer())) {
            respondLabel.setText("Poprawna odpowiedź");
            progress.updateProgressLevel(quiz.getDictionary().getLevel(), quiz.getQuestion().getCorrectWord(), +2);
        } else {
            respondLabel.setText("Błędna odpowiedź");
            progress.updateProgressLevel(quiz.getDictionary().getLevel(), quiz.getQuestion().getCorrectWord(), -1);
        }
    }
}
