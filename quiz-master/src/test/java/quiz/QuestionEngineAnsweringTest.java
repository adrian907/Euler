package quiz;

import org.testng.annotations.Test;

import java.util.ArrayList;

/**
 * Created by onifent
 */

public class QuestionEngineAnsweringTest {
    QuizEngine engine = new QuizEngine();

    @Test
    public void correctAnswer() { //TODO: Дописать тест
        ArrayList<Question> questions = new ArrayList<>();
        Question question1 = new Question();
        question1.setAnswer("Ответ 1");
        question1.setQuestion("Вопрос 1");
        questions.add(question1);
//        engine.answering(questions, question1, "asdsad");

    }
}
