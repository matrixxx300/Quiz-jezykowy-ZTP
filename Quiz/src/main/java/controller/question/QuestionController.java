package controller.question;

import controller.learn.ClosedQuestionQuizController;
import javafx.fxml.FXML;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.question.ClosedQuestion;
import model.quiz.Quiz;

public class QuestionController {
    public Stage window;
    public Text questionText;

    protected Quiz quiz;

    public void next() throws Exception {
        // todo WSZYSTKO FAJNIE, TYLKO TESTQUIZ NIE LICZY PUNKTÓW XD
        quiz.generateQuestion();
        if (quiz.getQuestion() instanceof ClosedQuestion) {
            if (this instanceof ClosedQuestionQuizController)
                new controller.learn.ClosedQuestionQuizController(quiz);
            else
                new controller.test.ClosedQuestionQuizController(quiz);
        } else {
            if (this instanceof ClosedQuestionQuizController)
                new controller.learn.OpenedQuestionQuizController(quiz);
            else
                new controller.test.OpenedQuestionQuizController(quiz);
        }
    }

    @FXML
    public void initialize() {
        questionText.setText(this.quiz.getQuestion().getQuestionText());
    }
}
