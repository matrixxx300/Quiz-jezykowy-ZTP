package Controllers.LearnQuiz;

import MainPackage.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import models.Dictionary;

import java.io.IOException;
import java.util.Random;
import java.util.Set;

public class OpenedQuestionQuizController {
    public Stage window;
    public String question;
    private Dictionary dictionary;

    @FXML
    public TextField answerTextField;
    public Label respondLabel;
    public Text questionText;

    public OpenedQuestionQuizController(Dictionary dictionary) throws IOException {
        this.dictionary = dictionary;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/LearnQuiz/OpenedQuestionQuizView.fxml"));
        loader.setController(this);

        this.window = Main.window;
        this.window.setScene(new Scene(loader.load()));
        this.window.setTitle("Nauka słówek - pytania otwarte");
        this.window.show();
    }

    @FXML
    public void initialize() {
        Set<String> map = dictionary.getWordList().keySet();
        int size = map.size();
        int item = new Random().nextInt(size);
        int i = 0;
        for (String string : map) {
            if (i == item) {
                question = string;
                questionText.setText(question);
            }
            i++;
        }
    }

    public void next(ActionEvent actionEvent) throws Exception {
        int type = new Random().nextInt(2);
        if (type == 0) {
            ClosedQuestionQuizController closedQuestionQuizController = new ClosedQuestionQuizController(this.dictionary);
        } else if (type == 1) {
            OpenedQuestionQuizController openedQuestionQuizController = new OpenedQuestionQuizController(this.dictionary);
        }
    }

    public void back(ActionEvent actionEvent) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/QuizSelectView.fxml"));
        window.setScene(new Scene(root));
        window.show();
    }

    public void check(ActionEvent actionEvent) {
        if (answerTextField.getText().equals(dictionary.getWordList().get(question))) {
            respondLabel.setText("Dobrze!");
        } else respondLabel.setText("Źle!");
    }
}
