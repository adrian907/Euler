package quiz;


import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileNotFoundException;

/**
 * Created by onifent
 */

public class QuizHelperTest {
    QuizHelper q = new QuizHelper();

    @Test
    public void emptyFolder() throws FileNotFoundException {
        File folder = new File("questionstest/test1");
        try {
            q.buildQuestionsArray(folder);
        } catch (RuntimeException e) {
            String error = e.getMessage();
            Assert.assertEquals(error, "Папка пуста");
        }
    }

    @Test
    public void emptyFile() throws FileNotFoundException {
        File folder = new File("questionstest/test2");
        try {
            q.buildQuestionsArray(folder);
        } catch (RuntimeException e) {
            String error = e.getMessage();
            Assert.assertEquals(error, "Пустой файл");
        }
    }

    @Test
    public void oneStringFile() throws FileNotFoundException {
        File folder = new File("questionstest/test4");
        q.buildQuestionsArray(folder);
    }

    @Test
    public void threeStringFile() throws FileNotFoundException {
        File folder = new File("questionstest/test5");
        q.buildQuestionsArray(folder);
    }

    @Test
    public void threeCorrectFiles() throws FileNotFoundException {
        File folder = new File("questionstest/test6");
        q.buildQuestionsArray(folder);
    }

}
