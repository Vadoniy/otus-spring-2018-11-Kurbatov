package homework_9.rest;

import homework_9.domain.manufacture.IngRate;
import homework_9.repository.IngRateRepository;
import homework_9.repository.IngredientRepository;
import homework_9.repository.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
public class PizzaController {

    private PizzaRepository pizzaRepository;
    private IngredientRepository ingredientRepository;
    private IngRateRepository ingRateRepository;

    @Autowired
    public PizzaController(PizzaRepository pizzaRepository, IngredientRepository ingredientRepository, IngRateRepository ingRateRepository) {
        this.pizzaRepository = pizzaRepository;
        this.ingredientRepository = ingredientRepository;
        this.ingRateRepository = ingRateRepository;
    }

    @GetMapping("/pizzas")
    public String pagePizzas(Model model){
        model.addAttribute("pizzas", pizzaRepository.findAll());
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

//    @GetMapping("/recipe")
//    public String getIngredientsByPizzaId(@RequestParam long pizza_id, Model model) {
//        model.addAttribute("ingredients", ingRateRepository.findByPizzaId(pizza_id));
//        return "ingredients";
//    }

    @GetMapping("/pizza/delete")
    public void deletePizza(HttpServletResponse response, @RequestParam long id) throws IOException {

        ingRateRepository.findByPizzaId(id).forEach(ingRate -> ingRateRepository.delete(ingRate));
        pizzaRepository.delete(pizzaRepository.findById(id).get());
        response.sendRedirect("/pizzas");
    }
}
