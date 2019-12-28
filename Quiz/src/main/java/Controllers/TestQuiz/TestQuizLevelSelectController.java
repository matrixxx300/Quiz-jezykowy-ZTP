package Controllers.TestQuiz;

import MainPackage.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class TestQuizLevelSelectController {
    public Stage window;

    public Button returnButton;

    static int count, score;
    static Set<String> questionsSet;

    @FXML
    public void initialize(){
        this.window = Main.window;
        count = 0;
        score = 0;
        questionsSet = new HashSet<>();
    }

    public void closedQuestionLearnQuiz() throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/TestQuiz/ClosedQuestionQuizView.fxml"));
        window.setScene(new Scene(root));
        window.show();
    }

    public void openedQuestionLearnQuiz() throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/TestQuiz/OpenedQuestionQuizView.fxml"));
        window.setScene(new Scene(root));
        window.show();
    }

    public void back() throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/QuizSelectView.fxml"));
        window.setScene(new Scene(root));
        window.show();
    }
}
