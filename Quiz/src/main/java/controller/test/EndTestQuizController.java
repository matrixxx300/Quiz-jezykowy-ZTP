package controller.test;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import main.Main;

import static controller.test.TestQuizLevelSelectController.count;
import static controller.test.TestQuizLevelSelectController.score;

public class EndTestQuizController {
    public Stage window;
    public Button returnButton;
    public Label scoreLabel;

    @FXML
    public void initialize() {
        this.window = Main.window;
        this.scoreLabel.setText(score + "/" + (count + 1));
    }

    public void back() throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/QuizSelectView.fxml"));
        window.setScene(new Scene(root));
        window.show();
    }
}
