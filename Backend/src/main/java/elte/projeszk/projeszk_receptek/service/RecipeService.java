package elte.projeszk.projeszk_receptek.service;

import elte.projeszk.projeszk_receptek.model.Recipe;
import elte.projeszk.projeszk_receptek.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class RecipeService {

    private RecipeRepository recipeRepository;

    @Autowired
    public void setRecipeRepository(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    public byte[] getPicture(Integer id) {
        return recipeRepository.findById(id).map(Recipe::getPicture).orElse(null);
    }

    public List<Map<String, Object>> getPictures(Integer id) {

        List<Map<String, Object>> response = new ArrayList<>();
        Optional<Recipe> optional = recipeRepository.findByIdNative(id);

        for (int i = 0; i < 8 && optional.isPresent(); ++i) {
            Map<String, Object> map = new HashMap<>();
            Recipe recipe = optional.get();
            map.put("id", recipe.getId());
            map.put("title", recipe.getTitle());
            String description = recipe.getDescription();
            if (description.length() > 100)
                map.put("description", recipe.getDescription().substring(0, 100));
            else
                map.put("description", recipe.getDescription());
            map.put("picture", recipe.getPicture());
            response.add(map);
            optional = recipeRepository.findByIdNative(recipe.getId());
        }
        return response;
    }
}
