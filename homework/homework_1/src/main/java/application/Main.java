package application;

import domain.Exam;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import services.CSVReaderService;
import services.ExamService;

public class Main {

    public static void main(String[] args){
        ApplicationContext context = new ClassPathXmlApplicationContext("/spring-context.xml");
        CSVReaderService csvReaderService = context.getBean(CSVReaderService.class);
        ExamService examService = context.getBean(ExamService.class);
        Exam exam = context.getBean(Exam.class);
        examService.run();
    }
}
