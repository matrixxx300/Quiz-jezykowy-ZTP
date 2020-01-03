package Controllers.TestQuiz;

import MainPackage.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.util.HashSet;
import java.util.Set;

import static Controllers.CRUD.DictionaryController.loadDictionary;

public class TestQuizLevelSelectController {
    public Stage window;

    public Button returnButton;

    static int count, score;
    static Set<String> questionsSet;
    public Button testA1;
    public Button testA2;
    public Button testB1;
    public Button testB2;
    public Button testC1;
    public Button testC2;
    private String selectedLevel;

    @FXML
    public void initialize() {
        this.window = Main.window;
        count = 0;
        score = 0;
        questionsSet = new HashSet<>();
        selectedLevel = null;
    }

    public void closedQuestionLearnQuiz(ActionEvent actionEvent) throws Exception {
        this.selectedLevel = ((Button) actionEvent.getSource()).getText();
        loadDictionary(this.selectedLevel);

        Parent root = FXMLLoader.load(getClass().getResource("/fxml/TestQuiz/ClosedQuestionQuizView.fxml"));
        window.setScene(new Scene(root));
        window.show();
    }

    public void openedQuestionLearnQuiz(ActionEvent actionEvent) throws Exception {
        this.selectedLevel = ((Button) actionEvent.getSource()).getText();
        loadDictionary(this.selectedLevel);

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
