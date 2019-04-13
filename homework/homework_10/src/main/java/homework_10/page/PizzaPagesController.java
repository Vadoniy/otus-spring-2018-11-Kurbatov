package homework_10.page;

import homework_10.domain.manufacture.IngRate;
import homework_10.repository.IngRateRepository;
import homework_10.repository.IngredientRepository;
import homework_10.repository.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class PizzaPagesController {

    private PizzaRepository pizzaRepository;
    private IngredientRepository ingredientRepository;
    private IngRateRepository ingRateRepository;

    @Autowired
    public PizzaPagesController(PizzaRepository pizzaRepository, IngredientRepository ingredientRepository, IngRateRepository ingRateRepository) {
        this.pizzaRepository = pizzaRepository;
        this.ingredientRepository = ingredientRepository;
        this.ingRateRepository = ingRateRepository;
    }

    @GetMapping("/pizzas")
    public String pagePizzas(Model model){
        model.addAttribute("keywords", "Pizzeria menu");
        return "pizzas";
    }

    @GetMapping("/recipe")
    public String getIngredientsByPizzaId(@RequestParam long id, Model model) {
        List<IngRate> ingRates = ingRateRepository.findByPizzaId(id);
        String pizzaName = ingRates.size()>0 ? ingRates.get(0).getPizza().getName() : "";
        model.addAttribute("ingRates", ingRates);
        model.addAttribute("pizzaName", pizzaName);
        return "ingRate";
    }
}