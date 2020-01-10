package controller.test;

import controller.question.QuestionController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import main.Main;
import model.quiz.Quiz;

import java.io.IOException;

import static controller.test.TestQuizLevelSelectController.count;
import static controller.test.TestQuizLevelSelectController.score;

public class OpenedQuestionQuizController extends QuestionController {

    @FXML
    public TextField answerTextField;

    public OpenedQuestionQuizController(Quiz quiz) throws IOException {
        this.quiz = quiz;

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/TestQuiz/OpenedQuestionQuizView.fxml"));
        loader.setController(this);
        this.window = Main.window;
        this.window.setScene(new Scene(loader.load()));
        this.window.setTitle("Test otwarty");
        this.window.show();
    }

    @Override
    public void next() throws Exception {
        if (answerTextField.getText().equals(quiz.getQuestion().getCorrectAnswer())) {
            score++;
        }
        if (count == 9) {
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/TestQuiz/EndTestQuizView.fxml"));
            window.setScene(new Scene(root));
            window.show();
        } else {
            count++;
        }
        super.next();
    }

    public void back() throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/QuizSelectView.fxml"));
        window.setScene(new Scene(root));
        window.show();
    }
}
