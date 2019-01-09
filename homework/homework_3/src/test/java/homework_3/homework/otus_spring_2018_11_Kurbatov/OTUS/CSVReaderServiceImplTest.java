package homework_3.homework.otus_spring_2018_11_Kurbatov.OTUS;

import homework_3.homework.otus_spring_2018_11_Kurbatov.OTUS.services.impl.CSVReaderServiceImpl;
import org.junit.Before;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class CSVReaderServiceImplTest {

    private Properties properties;
    private CSVReaderServiceImpl impl;
    private String testQuestion;
    private String testCorrectAnswer;
    private int recordsAmount;


    @Before
    public void setUp() throws IOException {
        properties = new Properties();
        properties.load(new FileInputStream(ClassLoader.getSystemClassLoader().getResource(
                "application.properties").getPath()));
        impl = new CSVReaderServiceImpl(properties.getProperty("file.name"));
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