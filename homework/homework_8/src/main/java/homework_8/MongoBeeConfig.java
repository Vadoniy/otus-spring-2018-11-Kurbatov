package homework_8;

import com.github.mongobee.Mongobee;
import com.mongodb.MongoClient;
import homework_8.changelog.DatabaseChangelog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class MongoBeeConfig {

    @Autowired
    private MongoClient mongo;

    @Bean
    public Mongobee mongobee(Environment environment){
        Mongobee runner = new Mongobee(mongo);
        runner.setDbName("homework");
        runner.setChangeLogsScanPackage(DatabaseChangelog.class.getPackage().getName());
        runner.setSpringEnvironment(environment);
        return runner;
    }
}
