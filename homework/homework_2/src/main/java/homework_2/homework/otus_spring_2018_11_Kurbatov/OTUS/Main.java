package homework_2.homework.otus_spring_2018_11_Kurbatov.OTUS;

import homework_2.homework.otus_spring_2018_11_Kurbatov.OTUS.services.ExamService;
import homework_2.homework.otus_spring_2018_11_Kurbatov.OTUS.services.impl.ExamServiceImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

@EnableAspectJAutoProxy
@Configuration
@ComponentScan
@PropertySource("classpath:application.properties")
public class Main {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Main.class);

        ExamService examService = context.getBean(ExamServiceImpl.class);
        examService.run();
    }

    @Bean
    public MessageSource messageSource(@Value("${bundle.baseName}") String name, @Value("${encoding.set}") String encoding){
        ReloadableResourceBundleMessageSource ms
                = new ReloadableResourceBundleMessageSource();
        ms.setBasename(name);
        ms.setDefaultEncoding(encoding);
        return ms;
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfigDev(){
        return new PropertySourcesPlaceholderConfigurer();
    }
}
