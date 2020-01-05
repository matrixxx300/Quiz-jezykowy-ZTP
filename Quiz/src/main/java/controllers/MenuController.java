package controllers;

import MainPackage.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class MenuController {
    public Stage window;

    public Button quizSelectButton;
    public Button rankingButton;
    public Button dictionaryButton;
    public Button exitButton;

    @FXML
    public void initialize() {
        this.window = Main.window;
    }

    public void quizSelect(ActionEvent actionEvent) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/QuizSelectView.fxml"));
        window.setScene(new Scene(root));
        window.show();
    }

    public void ranking(ActionEvent actionEvent) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/RankingView.fxml"));
        window.setScene(new Scene(root));
        window.show();
    }

    public void dictionary(ActionEvent actionEvent) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/CRUD/DictionaryView.fxml"));
        window.setScene(new Scene(root));
        window.show();
    }

    public void developerTools(ActionEvent actionEvent) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/DeveloperView.fxml"));
        window.setScene(new Scene(root));
        window.show();
    }

    public void exit(ActionEvent actionEvent) {
        System.exit(1);
    }

}
