package Controllers;

import MainPackage.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.FileNotFoundException;

import static Controllers.CRUD.DictionaryController.loadDictionary;

public class QuizSelectController {
    public Stage window;

    public Button returnButton;
    public Button learningButton;
    public Button testButton;

    @FXML
    public void initialize() throws FileNotFoundException {
        this.window = Main.window;
        loadDictionary();
    }

    public void back(ActionEvent actionEvent) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/MenuView.fxml"));
        window.setScene(new Scene(root));
        window.show();
    }

    public void learnQuizLevelSelect(ActionEvent actionEvent) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/LearnQuiz/LearnQuizLevelSelectView.fxml"));
        window.setScene(new Scene(root));
        window.show();
    }

    public void testQuizLevelSelect(ActionEvent actionEvent) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/TestQuizLevelSelectView.fxml"));
        window.setScene(new Scene(root));
        window.show();
    }
}
