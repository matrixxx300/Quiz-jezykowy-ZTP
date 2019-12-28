package Controllers.TestQuiz;

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

import static Controllers.CRUD.DictionaryController.dictionary;
import static Controllers.TestQuiz.TestQuizLevelSelectController.*;

public class OpenedQuestionQuizController {
    public Stage window;

    public Button returnButton;
    public Button nextButton;
    public TextField answerTextField;
    public Text questionText;

    private String question;

    @FXML
    public void initialize() {
        this.window = Main.window;
        Set<String> map = dictionary.keySet();
        int size = map.size();
        int item = new Random().nextInt(size);
        int i=0;
        for(String string : map){
            if(i == item) {
                question = string;
                if (!questionsSet.add(question)) item++;
                questionText.setText(question);
            }
            i++;
        }
    }

    public void next() throws Exception {
        if(answerTextField.getText().equals(dictionary.get(question))){
            score++;
        }
        if(count == 9){
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/TestQuiz/EndTestQuizView.fxml"));
            window.setScene(new Scene(root));
            window.show();
        }else {
            count++;
            int type = new Random().nextInt(2);
            if (type == 0) {
                Parent root = FXMLLoader.load(getClass().getResource("/fxml/TestQuiz/ClosedQuestionQuizView.fxml"));
                window.setScene(new Scene(root));
                window.show();
            } else if (type == 1) {
                Parent root = FXMLLoader.load(getClass().getResource("/fxml/TestQuiz/OpenedQuestionQuizView.fxml"));
                window.setScene(new Scene(root));
                window.show();
            }
        }
    }

    public void back() throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/QuizSelectView.fxml"));
        window.setScene(new Scene(root));
        window.show();
    }
}
