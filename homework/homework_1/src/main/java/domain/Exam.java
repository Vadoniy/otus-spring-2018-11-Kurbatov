package domain;

import services.CSVReaderServiceImpl;
import utils.Constants;

import java.io.IOException;

public class Exam {
    private CSVReaderServiceImpl csvReaderImpl = null;
    private StringBuffer result = new StringBuffer("%s %s's result: %s/%s ( ");
    int correctCounter;

    public Exam(CSVReaderServiceImpl csvReaderService) throws IOException {
        this.csvReaderImpl = csvReaderService;
    }

    public void takeQuestion(int questionCount){
        System.out.println(csvReaderImpl.readQuestion(questionCount));
    }

    public void setAnswer(String answer, int questionCount){
        if (csvReaderImpl.checkAnswer(answer,questionCount)){
            result.append("1 ");
            correctCounter++;
        } else {
            result.append("0 ");
        }
    }

    public void getResult(String name, String last_name, int questionCount){
        result.append(" )");
        result.toString();
        System.out.println(String.format(result.toString(), name, last_name, correctCounter, questionCount));
    }
}
