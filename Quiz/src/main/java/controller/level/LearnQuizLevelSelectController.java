package controller.level;

import controller.question.LearnClosedQuestionController;
import controller.question.LearnOpenQuestionController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import main.Main;
import model.Dictionary;
import model.Level;
import model.question.OpenedQuestion;
import model.quiz.LearnQuiz;

public class LearnQuizLevelSelectController {
    public Stage window;
    private String selectedLevel;
    private Dictionary dictionary;

    @FXML
    public void initialize() {
        this.window = Main.window;
        this.selectedLevel = null;
    }

    public Dictionary getDictionary() {
        return dictionary;
    }

    public void startLearnQuiz(ActionEvent actionEvent) throws Exception {
        this.selectedLevel = ((Button) actionEvent.getSource()).getText();
        this.dictionary = new Dictionary(new Level(this.selectedLevel));

        LearnQuiz learnQuiz = new LearnQuiz(dictionary);
        if (learnQuiz.getQuestion() instanceof OpenedQuestion) {
            new LearnOpenQuestionController(learnQuiz);
        } else {
            new LearnClosedQuestionController(learnQuiz);
        }
    }

    public void back(ActionEvent actionEvent) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/QuizSelectView.fxml"));
        window.setScene(new Scene(root));
        window.show();
    }
}
