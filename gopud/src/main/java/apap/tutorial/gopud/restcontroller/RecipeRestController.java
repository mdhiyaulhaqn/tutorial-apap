package apap.tutorial.gopud.restcontroller;

import apap.tutorial.gopud.service.RecipeRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/recipe")
public class RecipeRestController {
    @Autowired
    RecipeRestService recipeRestService;

    @GetMapping("/excludeIngredients={namaBahan}")
    public Mono<String> getStatus(@PathVariable String namaBahan) {
        return recipeRestService.getRecipeInGerman(namaBahan);
    }
}
