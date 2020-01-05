package controllers.TestQuiz;

import MainPackage.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import models.Dictionary;

import java.io.IOException;
import java.util.Collection;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import static controllers.TestQuiz.TestQuizLevelSelectController.*;

public class ClosedQuestionQuizController {
    public Stage window;
    private Dictionary dictionary;
    private String question;
    private Set<String> answerSet = new HashSet<>();

    @FXML
    public Button buttonA, buttonB, buttonC, buttonD;
    public Text questionText;
    
    public ClosedQuestionQuizController(Dictionary dictionary) throws IOException {
        this.dictionary = dictionary;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/TestQuiz/ClosedQuestionQuizView.fxml"));
        loader.setController(this);

        this.window = Main.window;
        this.window.setScene(new Scene(loader.load()));
        this.window.setTitle("Test zamknięty");
        this.window.show();
    }

    @FXML
    public void initialize() {
        question = getRandomQuestion();
        while (!questionsSet.add(question)) question = getRandomQuestion();
        questionText.setText(question);

        answerSet.add(dictionary.getWordList().get(question));
        for (int i = 1; i < 4; i++) {
            String answer = getRandomAnswer();
            while (!answerSet.add(answer)) answer = getRandomAnswer();
        }
        String[] myArray = new String[answerSet.size()];
        answerSet.toArray(myArray);

        int item = new Random().nextInt(4);
        switch (item) {
            case 0:
                buttonA.setText(myArray[0]);
                buttonB.setText(myArray[1]);
                buttonC.setText(myArray[2]);
                buttonD.setText(myArray[3]);
                break;
            case 1:
                buttonA.setText(myArray[1]);
                buttonB.setText(myArray[0]);
                buttonC.setText(myArray[2]);
                buttonD.setText(myArray[3]);
                break;
            case 2:
                buttonA.setText(myArray[1]);
                buttonB.setText(myArray[2]);
                buttonC.setText(myArray[0]);
                buttonD.setText(myArray[3]);
                break;
            case 3:
                buttonA.setText(myArray[1]);
                buttonB.setText(myArray[2]);
                buttonC.setText(myArray[3]);
                buttonD.setText(myArray[0]);
                break;
        }
    }

    private String getRandomQuestion() {
        Set<String> map = dictionary.getWordList().keySet();
        int size = map.size();
        int item = new Random().nextInt(size);
        int i = 0;
        for (String string : map) {
            if (i == item) return string;
            i++;
        }
        return null;
    }

    private String getRandomAnswer() {
        Collection<String> map = dictionary.getWordList().values();
        int size = map.size();
        int item = new Random().nextInt(size);
        int i = 0;
        for (String string : map) {
            if (i == item) return string;
            i++;
        }
        return null;
    }

    public void next() throws Exception {
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

    public void checkA() throws Exception {
        if (buttonA.getText().equals(dictionary.getWordList().get(question))) {
            score++;
        }
        next();
    }

    public void checkB() throws Exception {
        if (buttonB.getText().equals(dictionary.getWordList().get(question))) {
            score++;
        }
        next();
    }

    public void checkC() throws Exception {
        if (buttonC.getText().equals(dictionary.getWordList().get(question))) {
            score++;
        }
        next();
    }

    public void checkD() throws Exception {
        if (buttonD.getText().equals(dictionary.getWordList().get(question))) {
            score++;
        }
        next();
    }
}
