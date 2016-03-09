package quiz;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class QuizEngineScoreCounterTest {
    QuizEngine q = new QuizEngine();


    @DataProvider(name = "scoreCounterDP")
    public Object[][] scoreCounterDP() {
        return new Object[][]{
                {4, 0},
                {3, 10},
                {2, 6},
                {1, 3},
                {0, 0}
        };
    }

    @Test(dataProvider = "scoreCounterDP")
    public void scroeCounterAttempts3(int attempts, int expectedResult) {
        int score;
        score = q.scroeCounter(attempts);
        Assert.assertEquals(score, expectedResult);
    }
}