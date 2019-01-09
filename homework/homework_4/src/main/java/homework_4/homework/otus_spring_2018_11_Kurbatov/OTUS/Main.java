package homework_4.homework.otus_spring_2018_11_Kurbatov.OTUS;

import homework_4.homework.otus_spring_2018_11_Kurbatov.OTUS.configs.YamlProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy
@SpringBootApplication
@EnableConfigurationProperties(YamlProperties.class)
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class);
    }
}