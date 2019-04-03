package homework_9.rest;

import homework_9.domain.manufacture.Ingredient;
import homework_9.repository.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class IngredientController {

    private IngredientRepository ingredientRepository;

    @Autowired
    public IngredientController(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    @GetMapping("/ingredients")
    public String getIngredients(Model model) {
        model.addAttribute("ingredients", ingredientRepository.findAll());
        return "ingredients";
    }

    @GetMapping("/newIngredient")
    public String pageNewIngredient(){
        return "newIngredient";
    }

    @PostMapping("/ingredient/create")
    public void createIngredient(HttpServletResponse response,
                             @ModelAttribute(value = "ingredient") Ingredient ingredient) throws IOException {
        Ingredient cacheIngredient = new Ingredient(ingredient.getName()
                , ingredient.getQuantity()
                , ingredient.getMeasure()
                , ingredient.getType());
        if (ingredient.getDescription() != null
                && ingredient.getDescription().length() >0){
            cacheIngredient.setDescription(ingredient.getDescription());
        }
        ingredientRepository.save(cacheIngredient);
        response.sendRedirect("/ingredients");
    }

    @GetMapping("/ingredient/update")
    public String updateIngredientPage(@RequestParam long id, Model model){
        Ingredient cacheIngredient = ingredientRepository.findById(id).get();
        model.addAttribute("ingredient", cacheIngredient);
        model.addAttribute("id", id);
        return "updateIngredient";
    }

    @PutMapping("/ingredient/update")
    public void updateIngredient(HttpServletResponse response,
                                 @ModelAttribute(value = "ingredient") Ingredient ingredient) throws IOException {
        Ingredient cacheIngredient = ingredientRepository.findById(ingredient.getId()).get();
        cacheIngredient.setName(ingredient.getName());
        cacheIngredient.setDescription(ingredient.getDescription());
        cacheIngredient.setQuantity(ingredient.getQuantity());
        cacheIngredient.setMeasure(ingredient.getMeasure());
        cacheIngredient.setName(ingredient.getType());
        ingredientRepository.save(cacheIngredient);
        response.sendRedirect("/ingredients");
    }

    @GetMapping("/ingredient/delete")
    public void deleteIngredient(HttpServletResponse response, @RequestParam long id) throws IOException {
        ingredientRepository.delete(ingredientRepository.findById(id).get());
        response.sendRedirect("/ingredients");
    }
}
