package quiz;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by onifent
 */

public class QuizEngine {
    protected static final File folder = new File("questions");
    QuizHelper quizHelper = new QuizHelper();
    private int Score = 0;
    private int questionNumber = 1;

    public static void main(String[] args) {
        QuizHelper helper = new QuizHelper();
        QuizEngine engine = new QuizEngine();
        ArrayList<Question> questions = helper.buildQuestionsArray(folder);
        int questionsSize = questions.size();
        engine.startQuiz(questions);
        engine.finishQuiz(questionsSize);
    }

    protected void startQuiz(ArrayList<Question> questions) {
        while (!questions.isEmpty()) {
            int randomedQuestion = randomPicker(questions);
            Question selectedQuestion = selectQuestion(questions, randomedQuestion);
            setScore(getScore() + scroeCounter(answering(questions, selectedQuestion)));
        }
    }

    protected void finishQuiz(int questionsSize) {
        int score = getScore();
        int maxScore = questionsSize * 10;
        System.out.println("Вы набрали " + score + " очков из возможных " + maxScore);
    }

    protected int randomPicker(ArrayList<Question> questions) {
        return (int) (Math.random() * questions.size());
    }

    protected Question selectQuestion(ArrayList<Question> questions, int questionNumber) {
        Question selectedQuestion = questions.get(questionNumber);
        System.out.println("Вопрос №" + getQuestionNumber() + ": " + selectedQuestion.getQuestion());
        setQuestionNumber(getQuestionNumber() + 1);
        return selectedQuestion;
    }

    protected boolean isAnswerRight(Question question, String userInput) {
        String questionAnswer = question.getAnswer();
        return questionAnswer.equals(userInput);
    }

    protected int answering(ArrayList<Question> questions, Question question) {
        boolean isAnswerRight = false;
        int attempts;
        for (attempts = 3; attempts > 0; attempts--) {
            if (isAnswerRight(question, quizHelper.getUserInput())) {
                System.out.println("Правильный ответ!");
                isAnswerRight = true;
                questions.remove(question);
                return attempts;
            } else {
                if (attempts == 1) {
                    System.out.println("Неправильно! :(");
                    System.out.println("");
                    questions.remove(question);
                    break;
                }
                System.out.println("Неправильно. Осталось попыток " + (attempts - 1));
            }
        }
        return 0;
    }

    protected int scroeCounter(int attempts) {
        int score = 0;
        if (attempts == 3) {
            return score + 10;
        } else {
            if (attempts == 2) {
                return score + 6;
            } else {
                if (attempts == 1) {
                    return score + 3;
                } else {
                    return score;
                }
            }
        }
    }

    public int getQuestionNumber() {
        return questionNumber;
    }

    public void setQuestionNumber(int questionNumber) {
        this.questionNumber = questionNumber;
    }

    public int getScore() {
        return Score;
    }

    public void setScore(int score) {
        Score = score;
    }
}