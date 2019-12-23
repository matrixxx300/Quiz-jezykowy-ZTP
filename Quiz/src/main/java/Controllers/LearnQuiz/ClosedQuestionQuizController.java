package Controllers.LearnQuiz;

import MainPackage.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.Random;
import java.util.Set;

import static Controllers.CRUD.DictionaryController.dictionary;

public class ClosedQuestionQuizController {
    public Stage window;

    public Button returnButton;
    public Button nextButton;
    public Button buttonA;
    public Button buttonB;
    public Button buttonC;
    public Button buttonD;
    public Label respondLabel;
    public Text questionText;

    public String question;

    @FXML
    public void initialize() {
        this.window = Main.window;
        question = getRandomStringFromDictionary();
        questionText.setText(question);
        int item = new Random().nextInt(4);
        //TODO BRAKUJE SPRAWDZENIA CZY NIE MA WIELU TAKICH SAMYCH ODPOWIEDZI
        switch (item){
            case 0:
                buttonA.setText(dictionary.get(question));
                buttonB.setText(getRandomStringFromDictionary());
                buttonC.setText(getRandomStringFromDictionary());
                buttonD.setText(getRandomStringFromDictionary());
                break;
            case 1:
                buttonA.setText(getRandomStringFromDictionary());
                buttonB.setText(dictionary.get(question));
                buttonC.setText(getRandomStringFromDictionary());
                buttonD.setText(getRandomStringFromDictionary());
                break;
            case 2:
                buttonA.setText(getRandomStringFromDictionary());
                buttonB.setText(getRandomStringFromDictionary());
                buttonC.setText(dictionary.get(question));
                buttonD.setText(getRandomStringFromDictionary());
                break;
            case 3:
                buttonA.setText(getRandomStringFromDictionary());
                buttonB.setText(getRandomStringFromDictionary());
                buttonC.setText(getRandomStringFromDictionary());
                buttonD.setText(dictionary.get(question));
                break;

        }
    }

    private String getRandomStringFromDictionary() {
        Set<String> map = dictionary.keySet();
        int size = map.size();
        int item = new Random().nextInt(size);
        int i=0;
        for(String string : map){
            if(i == item) return string;
            i++;
        }
        return null;
    }

    public void next(ActionEvent actionEvent) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/LearnQuiz/ClosedQuestionQuizView.fxml"));
        window.setScene(new Scene(root));
        window.show();
    }

    public void checkA(ActionEvent actionEvent){
        if(buttonA.getText().equals(dictionary.get(question))){
            respondLabel.setText("Dobrze!");
        } else respondLabel.setText("Źle!");
    }

    public void checkB(ActionEvent actionEvent){
        if(buttonB.getText().equals(dictionary.get(question))){
            respondLabel.setText("Dobrze!");
        } else respondLabel.setText("Źle!");
    }

    public void checkC(ActionEvent actionEvent){
        if(buttonC.getText().equals(dictionary.get(question))){
            respondLabel.setText("Dobrze!");
        } else respondLabel.setText("Źle!");
    }

    public void checkD(ActionEvent actionEvent){
        if(buttonD.getText().equals(dictionary.get(question))){
            respondLabel.setText("Dobrze!");
        } else respondLabel.setText("Źle!");
    }

    public void back(ActionEvent actionEvent) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/QuizSelectView.fxml"));
        window.setScene(new Scene(root));
        window.show();
    }
}
