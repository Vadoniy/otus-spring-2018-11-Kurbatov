package application;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import services.ExamService;
import utils.Constants;

public class Main {

    public static void main(String[] args){
        ApplicationContext context = new ClassPathXmlApplicationContext(Constants.SPRING_CONTEXT_PATH);
        ExamService examService = context.getBean(ExamService.class);
        examService.run();
    }
}
