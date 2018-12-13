package homework_2.homework.otus_spring_2018_11_Kurbatov.OTUS;

import homework_2.homework.otus_spring_2018_11_Kurbatov.OTUS.services.impl.ExamServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.*;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

//@EnableAspectJAutoProxy
@Configuration
@ComponentScan
public class Main {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Main.class);

        ExamServiceImpl examService = context.getBean(ExamServiceImpl.class);
        examService.run();
    }

    @Bean
    public MessageSource messageSource(){
        ReloadableResourceBundleMessageSource ms
                = new ReloadableResourceBundleMessageSource();
        ms.setBasename("/i18n/bundle");
        ms.setDefaultEncoding("UTF-8");
        return ms;
    }
}
