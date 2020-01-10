package controller;

import controller.level.TestQuizLevelSelectController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import main.Main;

public class QuizSelectController {
    public Stage window;

    public Button returnButton;
    public Button learningButton;
    public Button testButton;

    @FXML
    public void initialize() {
        this.window = Main.window;
    }

    public void back() throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/MenuView.fxml"));
        window.setScene(new Scene(root));
        window.show();
    }

    public void learnQuizLevelSelect() throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/LearnQuiz/LearnQuizLevelSelectView.fxml"));
        window.setScene(new Scene(root));
        window.show();
    }

    public void testQuizLevelSelect() throws Exception {
        new TestQuizLevelSelectController();
    }
}
