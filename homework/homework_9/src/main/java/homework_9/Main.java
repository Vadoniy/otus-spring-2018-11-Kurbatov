package homework_9;

import homework_9.repository.IngRateRepository;
import homework_9.repository.IngredientRepository;
import homework_9.repository.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {

    @Autowired
    private IngRateRepository ingRateRepository;
    @Autowired
    private IngredientRepository ingredientRepository;
    @Autowired
    private PizzaRepository pizzaRepository;

    public static void main(String[] args) {
        SpringApplication.run(Main.class);
    }

//    @PostConstruct
//    public void init(){
//        List<IngRate> ingRates = ingRateRepository.findByPizzaId(2);
//        ingRates.forEach(ingRate -> System.out.println(ingRate.getIngredient().getName()));
//    }
}
