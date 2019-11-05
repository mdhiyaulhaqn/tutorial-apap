package apap.tutorial.gopud.service;

import apap.tutorial.gopud.rest.Setting;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import javax.transaction.Transactional;

@Service
@Transactional
public class RecipeRestServiceImpl implements RecipeRestService{
    private final WebClient webClient;
    private final String apiKey = "fb84bfe9080541b992d2d9a6f3ca8dbd";

    public RecipeRestServiceImpl(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl(Setting.recipesurl).build();
    }


    @Override
    public Mono<String> getRecipeInGerman(String excludeIngredient) {
        return this.webClient.get().uri("/recipes/search?cuisine=German&excludeIngredients=" + excludeIngredient + "&apiKey=" + apiKey)
                .retrieve().bodyToMono(String.class);
    }
}
