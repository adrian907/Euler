package quiz;

import utils.MemoryTools;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by onifent
 */

public class QuizHelper {

    private static MemoryTools tools = new MemoryTools();
    private static final String utf = "utf-8";

    public ArrayList<Question> buildQuestionsArray(final File folder) {
        ArrayList<Question> questions = new ArrayList<Question>();
        String error = null;
        if (!folder.exists()) {
            error = "Папка пуста";
            throw new RuntimeException(error);
        }

        for (File fileEntry : folder.listFiles()) {
            Question question = new Question();
            try (BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(fileEntry), utf))) {
                if (fileEntry.length() == 0) {
                    error = "Пустой файл";
                    throw new RuntimeException(error);
                }
                try {
                    question.setQuestion(in.readLine());
                    in.skip(1);
                    question.setAnswer(in.readLine());
                } finally {
                    in.close();
                }

            } catch (IOException e) {
                error = "Невозможно прочесть файл";
                throw new RuntimeException(error);
            }
            questions.add(question);
        }
        return questions;
    }

    public String getUserInput() {
        String inputLine = null;
        try {
            System.out.print("Введите ответ: ");
            BufferedReader is = new BufferedReader(new InputStreamReader(System.in));
            inputLine = is.readLine();
            if (inputLine.length() == 0) return null;
        } catch (IOException e) {
            System.out.println("IOException" + e);
        }
        return inputLine.toLowerCase();
    }
}