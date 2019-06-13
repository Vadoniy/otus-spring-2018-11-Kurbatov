package homework_10.rest;

import homework_10.repository.IngRateRepository;
import homework_10.repository.IngredientRepository;
import homework_10.repository.PizzaRepository;
import homework_10.rest.dto.PizzaDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class PizzaRestController {

    private PizzaRepository pizzaRepository;
    private IngredientRepository ingredientRepository;
    private IngRateRepository ingRateRepository;

    @Autowired
    public PizzaRestController(PizzaRepository pizzaRepository, IngredientRepository ingredientRepository, IngRateRepository ingRateRepository) {
        this.pizzaRepository = pizzaRepository;
        this.ingredientRepository = ingredientRepository;
        this.ingRateRepository = ingRateRepository;
    }

    @GetMapping("/pizzas/list")
    public List<PizzaDto> pagePizzas(Model model){
        return pizzaRepository.findAll().stream().map(PizzaDto::toDto)
                .collect(Collectors.toList());
    }

    @DeleteMapping("/pizza/delete")
    public List<PizzaDto> deletePizza(@RequestParam long pizza_id, Model model) throws IOException {
        ingRateRepository.findByPizzaId(pizza_id).forEach(ingRate -> ingRateRepository.delete(ingRate));
        pizzaRepository.delete(pizzaRepository.findById(pizza_id).get());
        return pizzaRepository.findAll().stream().map(PizzaDto::toDto)
                .collect(Collectors.toList());
    }
}
