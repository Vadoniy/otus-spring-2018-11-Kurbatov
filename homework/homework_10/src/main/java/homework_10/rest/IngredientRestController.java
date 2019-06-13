package homework_10.rest;

import homework_10.domain.manufacture.IngRate;
import homework_10.domain.manufacture.Ingredient;
import homework_10.domain.manufacture.Pizza;
import homework_10.repository.IngRateRepository;
import homework_10.repository.IngredientRepository;
import homework_10.repository.PizzaRepository;
import homework_10.rest.dto.IngRateDto;
import homework_10.rest.dto.IngredientDto;
import homework_10.rest.dto.IngredientSuperDto;
import homework_10.rest.dto.PizzaDto;
import homework_10.utils.exception.DeleteException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class IngredientRestController {

    private IngredientRepository ingredientRepository;
    private IngRateRepository ingRateRepository;
    private PizzaRepository pizzaRepository;

    @Autowired
    public IngredientRestController(IngredientRepository ingredientRepository, IngRateRepository ingRateRepository, PizzaRepository pizzaRepository) {
        this.ingredientRepository = ingredientRepository;
        this.ingRateRepository = ingRateRepository;
        this.pizzaRepository = pizzaRepository;
    }

    @GetMapping("/ingredient")
    public IngredientDto getClient(@RequestParam long id, Model model){
        return ingredientRepository.findById(id).map(IngredientDto::toDto).get();
    }

    @GetMapping("/ingredient/list")
    public List<IngredientDto> pagePizzas(){
        return ingredientRepository.findAll().stream().map(IngredientDto::toDto)
                .collect(Collectors.toList());
    }

    @DeleteMapping("/ingredient/delete")
    public List<IngredientDto> deleteIngredient(@RequestParam long ingredient_id, Model model, HttpServletResponse response) throws DeleteException {
        try{
            ingredientRepository.delete(ingredientRepository.findById(ingredient_id).get());
        } catch (DataIntegrityViolationException e){
            StringBuffer result = new StringBuffer("This ingredient is used in next products: ");
            List<IngRate> ingRates = ingRateRepository.findByIngredientId(ingredient_id);
            ingRates.forEach(ingRate -> {
                result.append(ingRate.getPizza().getName());
                result.append("; ");
            });
            throw new DeleteException(result.toString());
        }
        return ingredientRepository.findAll().stream().map(IngredientDto::toDto)
                .collect(Collectors.toList());
    }

    @PutMapping(value = "/ingredient/update", consumes = "application/json")
    public String deleteIngredient(@RequestBody IngredientSuperDto ingredientSuperDto) {
        IngredientDto ingredientDto = ingredientSuperDto.getIngredientDto();
        Ingredient cacheIngredient = ingredientRepository.findById(ingredientDto.getId()).get();
        cacheIngredient.setDescription(ingredientDto.getDescription());
        cacheIngredient.setMeasure(ingredientDto.getMeasure());
        cacheIngredient.setName(ingredientDto.getName());
        cacheIngredient.setQuantity(ingredientDto.getQuantity());
        cacheIngredient.setType(ingredientDto.getType());
        ingredientRepository.save(cacheIngredient);
        return "{}";
    }

    @PostMapping(value = "/ingredient/add", consumes = "application/json")
    public String createIngredient(@RequestBody IngredientSuperDto ingredientSuperDto) {
        IngredientDto ingredientDto = ingredientSuperDto.getIngredientDto();
        Ingredient cacheIngredient = new Ingredient();
        cacheIngredient.setName(ingredientDto.getName());
        cacheIngredient.setDescription(ingredientDto.getDescription());
        cacheIngredient.setQuantity(ingredientDto.getQuantity());
        cacheIngredient.setMeasure(ingredientDto.getMeasure());
        cacheIngredient.setType(ingredientDto.getType());
        ingredientRepository.save(cacheIngredient);
        return "{}";
    }

    @GetMapping("/pizza/recipe")
    public List<IngRateDto> getRecipe(@RequestParam long id){
        return ingRateRepository.findByPizzaId(id).stream().map(IngRateDto::toDto).collect(Collectors.toList());
    }
}
