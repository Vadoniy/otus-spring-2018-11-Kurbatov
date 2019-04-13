package homework_10.page;

import homework_10.domain.manufacture.Ingredient;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class IngredientPagesController {

    @GetMapping("/ingredients")
    public String getIngredients(Model model) {
        model.addAttribute("keywords", "Ingredients on the stock");
        return "ingredients";
    }

    @GetMapping("/ingredient/update")
    public String updateIngredientPage(@RequestParam long id, Model model){
        model.addAttribute("id", id);
        return "updateIngredient";
    }
}
