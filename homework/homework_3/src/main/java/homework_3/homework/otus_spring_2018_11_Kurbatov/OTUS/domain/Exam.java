package homework_3.homework.otus_spring_2018_11_Kurbatov.OTUS.domain;

import homework_3.homework.otus_spring_2018_11_Kurbatov.OTUS.configs.YamlProperties;
import homework_3.homework.otus_spring_2018_11_Kurbatov.OTUS.services.CSVReaderService;
import homework_3.homework.otus_spring_2018_11_Kurbatov.OTUS.services.impl.MessageResourceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class Exam {

    private CSVReaderService csvReaderService = null;
    private StringBuffer result = null;
    private int correctCounter;

    public Exam(){}

    @Autowired
    public Exam(CSVReaderService csvReaderService, MessageResourceImpl ms, YamlProperties yml) throws IOException {
        this.csvReaderService = csvReaderService;
        result = new StringBuffer(ms.getI18nString("result"));
    }

    public String takeQuestion(int questionCount){

        return csvReaderService.readQuestion(questionCount);
    }

    public void setAnswer(String answer, int questionCount){
        if (csvReaderService.checkAnswer(answer,questionCount)){
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