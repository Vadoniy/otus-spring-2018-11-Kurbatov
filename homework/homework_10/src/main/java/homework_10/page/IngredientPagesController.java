package homework_10.page;

import homework_10.domain.manufacture.Ingredient;
import homework_10.repository.IngredientRepository;
import homework_10.rest.dto.IngredientDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class IngredientPagesController {

    private IngredientRepository ingredientRepository;

    @Autowired
    public IngredientPagesController(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    @GetMapping("/ingredients")
    public String getIngredients(Model model) {
        model.addAttribute("keywords", "Ingredients on the stock");
        return "ingredients";
    }

    @GetMapping("/updateIngredient")
    public String updateIngredientPage(@RequestParam long id, Model model){
        Ingredient cacheIngredient = ingredientRepository.findById(id).get();
        model.addAttribute("ingredient", cacheIngredient);
        model.addAttribute("id", id);
        return "updateIngredient";
    }

    @GetMapping("/createIngredient")
    public String createIngredientPage(){
        return "createIngredient";
    }
}
