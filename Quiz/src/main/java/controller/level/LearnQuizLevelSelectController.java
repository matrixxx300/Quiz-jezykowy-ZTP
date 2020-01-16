package controller.level;

import controller.QuizSelectController;
import controller.question.LearnClosedQuestionController;
import controller.question.LearnOpenQuestionController;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import main.Main;
import model.Dictionary;
import model.Level;
import model.Progress;
import model.question.OpenedQuestion;
import model.quiz.LearnQuiz;

import java.io.IOException;

public class LearnQuizLevelSelectController {
    public Stage window;
    private String selectedLevel;
    private Dictionary dictionary;
    private Progress progress;

    public LearnQuizLevelSelectController() throws IOException {
        this.progress = Progress.getInstance();
        this.selectedLevel = null;

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/LearnQuiz/LearnQuizLevelSelectView.fxml"));
        loader.setController(this);
        window = Main.window;
        window.setScene(new Scene(loader.load()));
        window.setTitle("Wybór poziomu nauki");
        window.show();
    }

    public Dictionary getDictionary() {
        return dictionary;
    }

    public void startLearnQuiz(ActionEvent actionEvent) throws Exception {
        this.selectedLevel = ((Button) actionEvent.getSource()).getText();
        this.dictionary = new Dictionary(new Level(this.selectedLevel));

        LearnQuiz learnQuiz = new LearnQuiz(dictionary);
        if (learnQuiz.getQuestion() instanceof OpenedQuestion) {
            new LearnOpenQuestionController(learnQuiz, progress);
        } else {
            new LearnClosedQuestionController(learnQuiz, progress);
        }
    }

    public void back(ActionEvent actionEvent) throws Exception {
        new QuizSelectController();
    }
}
