package homework_9;

import homework_9.domain.manufacture.Ingredient;
import homework_9.repository.IngredientRepository;
import homework_9.utils.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class);
//        Person test = new Person("Person Test", 20, 1, 1990);
//        System.out.println(test.toString());
    }

    @Autowired
    private IngredientRepository ingRepo;

    @PostConstruct
    public void init(){
        Ingredient cheese = new Ingredient("Parmesan", 3.0, "kg", Type.FILLING.toString());
        cheese.setDescription("Topper for pizza");
        ingRepo.save(cheese);
    }
}
