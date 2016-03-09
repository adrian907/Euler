package quiz;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;

/**
 * Created by onifent
 */

public class QuestionEngineSelectQuestionTest {
    QuizEngine engine = new QuizEngine();
    ArrayList<Question> questions = new ArrayList<>();

    @Test
    public void checkQuestionSelecter(){
        Question question1 = new Question();
        question1.setQuestion("Вопрос 1");
        question1.setAnswer("Ответ 1");
        questions.add(question1);
        Question selectedQuestion = engine.selectQuestion(questions, 1);
        Assert.assertEquals(selectedQuestion.getQuestion(),"Вопрос 1");
        Assert.assertEquals(selectedQuestion.getAnswer(),"Ответ 1");
    }
}
