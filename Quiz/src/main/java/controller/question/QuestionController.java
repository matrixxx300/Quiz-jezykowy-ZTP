package controller.question;

import javafx.fxml.FXML;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.question.ClosedQuestion;
import model.question.OpenedQuestion;
import model.quiz.LearnQuiz;
import model.quiz.Quiz;
import model.quiz.TestQuiz;

public class QuestionController {
    public Stage window;
    public Text questionText;

    protected Quiz quiz;

    public void next() throws Exception {
        quiz.generateQuestion();
        if (quiz instanceof LearnQuiz && quiz.getQuestion() instanceof ClosedQuestion)
            new LearnClosedQuestionController(quiz);
        else if (quiz instanceof LearnQuiz && quiz.getQuestion() instanceof OpenedQuestion)
            new LearnOpenQuestionController(quiz);
        else if (quiz instanceof TestQuiz && quiz.getQuestion() instanceof ClosedQuestion)
            new TestClosedQestionController(quiz);
        else if (quiz instanceof TestQuiz && quiz.getQuestion() instanceof OpenedQuestion)
            new TestOpenQuestionController(quiz);
    }

    @FXML
    public void initialize() {
        questionText.setText(this.quiz.getQuestion().getQuestionText());
    }
}
