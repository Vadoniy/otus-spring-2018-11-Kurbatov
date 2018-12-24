package homework_3.homework.otus_spring_2018_11_Kurbatov.OTUS;

import homework_3.homework.otus_spring_2018_11_Kurbatov.OTUS.configs.YamlProperies;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

@EnableAspectJAutoProxy
@SpringBootApplication
@EnableConfigurationProperties(YamlProperies.class)
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class);
    }

    @Bean
    public MessageSource messageSource(YamlProperies yml){
        ReloadableResourceBundleMessageSource ms
                = new ReloadableResourceBundleMessageSource();
        ms.setBasename(yml.getBaseName());
        ms.setDefaultEncoding(yml.getLocaleSet());
        return ms;
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfigDev(){
        return new PropertySourcesPlaceholderConfigurer();
    }
}