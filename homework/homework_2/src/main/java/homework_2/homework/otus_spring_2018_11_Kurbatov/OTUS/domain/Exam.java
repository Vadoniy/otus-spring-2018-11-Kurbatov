package homework_2.homework.otus_spring_2018_11_Kurbatov.OTUS.domain;

import homework_2.homework.otus_spring_2018_11_Kurbatov.OTUS.services.CSVReaderService;
import homework_2.homework.otus_spring_2018_11_Kurbatov.OTUS.services.impl.CSVReaderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Locale;

@Service
public class Exam {

    private CSVReaderService csvReaderService = null;
    private StringBuffer result = null;
    private int correctCounter;
    private Locale locale;

    public Exam(){}

    @Autowired
    public Exam(CSVReaderService csvReaderService, MessageSource ms, @Value("${locale.set}") String locale) throws IOException {
        this.csvReaderService = csvReaderService;
        this.locale = Locale.forLanguageTag(locale);
        result = new StringBuffer(ms.getMessage("result", null, this.locale));
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
