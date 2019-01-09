package homework_4.homework.otus_spring_2018_11_Kurbatov.OTUS.services.impl;

import homework_4.homework.otus_spring_2018_11_Kurbatov.OTUS.configs.YamlProperties;
import homework_4.homework.otus_spring_2018_11_Kurbatov.OTUS.domain.Exam;
import homework_4.homework.otus_spring_2018_11_Kurbatov.OTUS.services.CSVReaderService;
import homework_4.homework.otus_spring_2018_11_Kurbatov.OTUS.services.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Locale;
import java.util.Scanner;

@Service
public class ExamServiceImpl implements ExamService {
    private CSVReaderService csvReaderService;
    private Exam ex;
    private String answer;
    private MessageResourceImpl ms;
    private Locale locale;
    private String studentName;
    private String studentLastName;

    public ExamServiceImpl(){};

    @Autowired
    public ExamServiceImpl(CSVReaderService csvReaderService, Exam exam, MessageResourceImpl ms, YamlProperties yml){
        this.csvReaderService = csvReaderService;
        this.ex = exam;
        this.ms = ms;
        this.locale = Locale.forLanguageTag(yml.getLocaleSet());
    }

    @Override
    public void setNameAndSurname(String name, String last_name){
        this.studentName = name;
        this.studentLastName = last_name;
    }

    @Override
    public String getResult() {
        return ex.getResult(studentName, studentLastName, csvReaderService.getRecordsAmount());
    }

    @Override
    public void finish() {
        System.exit(0);
    }

    @Override
    public void run() {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < csvReaderService.getRecordsAmount(); i++){
            System.out.println(ex.takeQuestion(i));
            answer = sc.nextLine();
            ex.setAnswer(answer, i);
        }
    }
}