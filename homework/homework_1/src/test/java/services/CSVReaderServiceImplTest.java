package services;

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
        impl = new CSVReaderServiceImpl();
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
    public void getRecordsAmount() throws Exception {
        assertEquals(recordsAmount, impl.getRecordsAmount());
    }

}