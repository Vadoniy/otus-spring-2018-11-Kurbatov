package homework_3.homework.otus_spring_2018_11_Kurbatov.OTUS;

import homework_3.homework.otus_spring_2018_11_Kurbatov.OTUS.configs.YamlProperties;
import homework_3.homework.otus_spring_2018_11_Kurbatov.OTUS.services.ExamService;
import homework_3.homework.otus_spring_2018_11_Kurbatov.OTUS.services.impl.ExamServiceImpl;
import javafx.application.Application;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

@EnableAspectJAutoProxy
@SpringBootApplication
@EnableConfigurationProperties(YamlProperties.class)
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class);
    }
}