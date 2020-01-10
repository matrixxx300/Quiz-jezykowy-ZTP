package controller.test;

import controller.question.QuestionController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import main.Main;
import model.question.ClosedQuestion;
import model.quiz.Quiz;

import java.io.IOException;

import static controller.test.TestQuizLevelSelectController.count;
import static controller.test.TestQuizLevelSelectController.score;

public class ClosedQuestionQuizController extends QuestionController {

    @FXML
    public Button buttonA, buttonB, buttonC, buttonD;

    public ClosedQuestionQuizController(Quiz quiz) throws IOException {
        this.quiz = quiz;

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/TestQuiz/ClosedQuestionQuizView.fxml"));
        loader.setController(this);
        this.window = Main.window;
        this.window.setScene(new Scene(loader.load()));
        this.window.setTitle("Test zamknięty");
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

    @Override
    public void next() throws Exception {
        if (count == 9) {
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/TestQuiz/EndTestQuizView.fxml"));
            window.setScene(new Scene(root));
            window.show();
        } else {
            count++;
        }
        super.next();
    }

    public void checkA() throws Exception {
        if (buttonA.getText().equals(quiz.getQuestion().getCorrectAnswer())) {
            score++;
        }
        next();
    }

    public void checkB() throws Exception {
        if (buttonB.getText().equals(quiz.getQuestion().getCorrectAnswer())) {
            score++;
        }
        next();
    }

    public void checkC() throws Exception {
        if (buttonC.getText().equals(quiz.getQuestion().getCorrectAnswer())) {
            score++;
        }
        next();
    }

    public void checkD() throws Exception {
        if (buttonD.getText().equals(quiz.getQuestion().getCorrectAnswer())) {
            score++;
        }
        next();
    }
}
