package homework_10.rest;

import homework_10.repository.IngredientRepository;
import homework_10.rest.dto.IngredientDto;
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
public class IngredientRestController {

    private IngredientRepository ingredientRepository;

    @Autowired
    public IngredientRestController(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    @GetMapping("/ingredient/list")
    public List<IngredientDto> pagePizzas(){
        return ingredientRepository.findAll().stream().map(IngredientDto::toDto)
                .collect(Collectors.toList());
    }

    @DeleteMapping("/ingredient/delete")
    public List<IngredientDto> deleteIngredient(@RequestParam long ingredient_id, Model model) {
        ingredientRepository.delete(ingredientRepository.findById(ingredient_id).get());
        return ingredientRepository.findAll().stream().map(IngredientDto::toDto)
                .collect(Collectors.toList());
    }
}
