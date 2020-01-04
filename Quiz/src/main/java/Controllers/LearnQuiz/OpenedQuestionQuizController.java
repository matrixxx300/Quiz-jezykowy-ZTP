package Controllers.LearnQuiz;

import MainPackage.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.Random;
import java.util.Set;

import static Controllers.CRUD.DictionaryController.oldDict;

public class OpenedQuestionQuizController {
    public Stage window;

    public Button returnButton;
    public Button nextButton;
    public Button checkButton;
    public TextField answerTextField;
    public Label respondLabel;
    public Text questionText;

    public String question;

    @FXML
    public void initialize() {
        this.window = Main.window;
        Set<String> map = oldDict.keySet();
        int size = map.size();
        int item = new Random().nextInt(size);
        int i=0;
        for(String string : map){
            if(i == item) {
                question = string;
                questionText.setText(question);
            }
            i++;
        }
    }

    public void next(ActionEvent actionEvent) throws Exception {
        int type = new Random().nextInt(2);
        if(type == 0) {
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/LearnQuiz/ClosedQuestionQuizView.fxml"));
            window.setScene(new Scene(root));
            window.show();
        }else if(type == 1){
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/LearnQuiz/OpenedQuestionQuizView.fxml"));
            window.setScene(new Scene(root));
            window.show();
        }
    }

    public void back(ActionEvent actionEvent) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/QuizSelectView.fxml"));
        window.setScene(new Scene(root));
        window.show();
    }

    public void check(ActionEvent actionEvent) {
        if(answerTextField.getText().equals(oldDict.get(question))){
            respondLabel.setText("Dobrze!");
        } else respondLabel.setText("Źle!");
    }
}
