package homework_2.homework.otus_spring_2018_11_Kurbatov.OTUS.domain;

import homework_2.homework.otus_spring_2018_11_Kurbatov.OTUS.services.impl.CSVReaderServiceImpl;
import homework_2.homework.otus_spring_2018_11_Kurbatov.OTUS.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class Exam {

    private CSVReaderServiceImpl csvReaderImpl = null;
    private StringBuffer result = new StringBuffer(Constants.RESULT_TEMPLATE);
    private int correctCounter;

    public Exam(){}

    @Autowired
    public Exam(CSVReaderServiceImpl csvReaderService) throws IOException {
        this.csvReaderImpl = csvReaderService;
    }

    public String takeQuestion(int questionCount){

        return csvReaderImpl.readQuestion(questionCount);
    }

    public void setAnswer(String answer, int questionCount){
        if (csvReaderImpl.checkAnswer(answer,questionCount)){
            result.append("1 ");
            correctCounter++;
        } else {
            result.append("0 ");
        }
    }

    public String getResult(String name, String last_name, int questionCount){
        result.append(")");
        result.toString();
        return String.format(result.toString(), name, last_name, correctCounter, questionCount);
    }
}
