package Controllers.TestQuiz;

import MainPackage.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import models.Dictionary;

import java.io.IOException;
import java.util.Random;
import java.util.Set;

import static Controllers.TestQuiz.TestQuizLevelSelectController.*;

public class OpenedQuestionQuizController {
    public Stage window;
    private Dictionary dictionary;
    private String question;

    @FXML
    public TextField answerTextField;
    public Text questionText;

    public OpenedQuestionQuizController(Dictionary dictionary) throws IOException {
        this.dictionary = dictionary;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/TestQuiz/OpenedQuestionQuizView.fxml"));
        loader.setController(this);

        this.window = Main.window;
        this.window.setScene(new Scene(loader.load()));
        this.window.setTitle("Test otwarty");
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
                if (!questionsSet.add(question)) item++;
                questionText.setText(question);
            }
            i++;
        }
    }

    public void next() throws Exception {
        if (answerTextField.getText().equals(dictionary.getWordList().get(question))) {
            score++;
        }
        if (count == 9) {
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/TestQuiz/EndTestQuizView.fxml"));
            window.setScene(new Scene(root));
            window.show();
        } else {
            count++;
            int type = new Random().nextInt(2);
            if (type == 0) {
                ClosedQuestionQuizController closedQuestionQuizController = new ClosedQuestionQuizController(this.dictionary);
            } else if (type == 1) {
                OpenedQuestionQuizController openedQuestionQuizController = new OpenedQuestionQuizController(this.dictionary);
            }
        }
    }

    public void back() throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/QuizSelectView.fxml"));
        window.setScene(new Scene(root));
        window.show();
    }
}
