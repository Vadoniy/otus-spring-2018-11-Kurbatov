package homework_2.homework.otus_spring_2018_11_Kurbatov.OTUS.services.impl;

import homework_2.homework.otus_spring_2018_11_Kurbatov.OTUS.domain.Exam;
import homework_2.homework.otus_spring_2018_11_Kurbatov.OTUS.services.CSVReaderService;
import homework_2.homework.otus_spring_2018_11_Kurbatov.OTUS.services.ExamService;
import homework_2.homework.otus_spring_2018_11_Kurbatov.OTUS.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.Locale;
import java.util.Scanner;

@Service
public class ExamServiceImpl implements ExamService {
    private CSVReaderService csvReaderService;
    private Exam ex;
    private String answer;
    private MessageSource ms;

    public ExamServiceImpl(){};

    @Autowired
    public ExamServiceImpl(CSVReaderService csvReaderService, Exam exam, MessageSource ms){
        this.csvReaderService = csvReaderService;
        this.ex = exam;
        this.ms = ms;
    }

    @Override
    public void run() {
        try(Scanner sc = new Scanner(System.in)){
//            System.out.println(Constants.GREETINGS);
            System.out.println(ms.getMessage("greetings", null, Locale.ENGLISH));
            String name = sc.nextLine();
            String last_name = sc.nextLine();

            for (int i = 0; i < csvReaderService.getRecordsAmount(); i++){
                System.out.println(ex.takeQuestion(i));
                answer = sc.nextLine();
                ex.setAnswer(answer, i);
            }

            System.out.println(ex.getResult(name, last_name, csvReaderService.getRecordsAmount()));
        }
    }
}
