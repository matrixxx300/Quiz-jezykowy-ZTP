package Controllers.LearnQuiz;

import MainPackage.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class LearnQuizLevelSelectController {
    public Stage window;

    public Button returnButton;

    @FXML
    public void initialize(){
        this.window = Main.window;
    }

    public void closedQuestionLearnQuiz(ActionEvent actionEvent) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/LearnQuiz/ClosedQuestionQuizView.fxml"));
        window.setScene(new Scene(root));
        window.show();
    }

    public void openedQuestionLearnQuiz(ActionEvent actionEvent) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/LearnQuiz/OpenedQuestionQuizView.fxml"));
        window.setScene(new Scene(root));
        window.show();
    }

    public void back(ActionEvent actionEvent) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/QuizSelectView.fxml"));
        window.setScene(new Scene(root));
        window.show();
    }
}
