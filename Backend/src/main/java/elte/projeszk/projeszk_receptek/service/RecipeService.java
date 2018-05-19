package elte.projeszk.projeszk_receptek.service;

import elte.projeszk.projeszk_receptek.model.Recipe;
import elte.projeszk.projeszk_receptek.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
