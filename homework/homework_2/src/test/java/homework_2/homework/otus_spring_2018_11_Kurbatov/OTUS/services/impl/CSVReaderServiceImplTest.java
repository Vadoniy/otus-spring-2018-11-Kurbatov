package homework_2.homework.otus_spring_2018_11_Kurbatov.OTUS.services.impl;

import homework_2.homework.otus_spring_2018_11_Kurbatov.OTUS.utils.Constants;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class CSVReaderServiceImplTest {

    private CSVReaderServiceImpl impl;
    private String testQuestion;
    private String testCorrectAnswer;
    private int recordsAmount;

    @Before
    public void setUp() throws IOException {
        impl = new CSVReaderServiceImpl(Constants.FILE_TEST_PATH);
        testQuestion = "Do you like java?";
        testCorrectAnswer = "d";
        recordsAmount = 5;
    }

    @Test
    public void readQuestion() throws Exception {
        assertEquals(testQuestion,impl.readQuestion(0).split("\n")[0]);
    }

    @Test
    public void getCorrectAnswer() throws Exception {
        assertEquals(testCorrectAnswer, impl.getCorrectAnswer(0));
    }

    @Test
    public void checkAnswer() throws Exception {
        assertEquals(true, impl.checkAnswer(testCorrectAnswer, 0));
        assertNotEquals(true, impl.checkAnswer(testCorrectAnswer, 1));
    }

    @Test
    public void getRecordsAmount() throws Exception {
        assertEquals(recordsAmount, impl.getRecordsAmount());
    }

}