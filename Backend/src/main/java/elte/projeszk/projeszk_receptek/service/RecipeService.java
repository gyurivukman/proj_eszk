package elte.projeszk.projeszk_receptek.service;

import elte.projeszk.projeszk_receptek.model.*;
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

    public Map<String, Object> getRecipe(Integer id) {
        Map<String, Object> response = new HashMap<>();
        Optional<Recipe> optional = recipeRepository.findById(id);

        if (optional.isPresent()) {
            Recipe recipe = optional.get();
            response.put("id", recipe.getId());
            response.put("title", recipe.getTitle());
            response.put("description", recipe.getDescription());
            response.put("createdAt", recipe.getCreatedAt());
            response.put("user", userToMap(recipe.getUser()));
            response.put("ingredients", ingradientsToMap(recipe.getIngredients()));
            response.put("steps", stepsToMap(recipe.getSteps()));
            response.put("comments", commentsToMap(recipe.getComments()));
            float rating = 0;
            if (recipe.getUpvotes() != null && recipe.getDownvotes() != null)
                rating = recipe.getUpvotes() / (recipe.getUpvotes() + recipe.getDownvotes()) * 10;
            response.put("rating", rating);
        }
        return response;
    }

    private Map<String, Object> userToMap(User user) {
        if (user != null) {
            Map<String, Object> map = new HashMap<>();
            map.put("id", user.getId());
            map.put("username", user.getUsername());
            map.put("foreName", user.getForeName());
            map.put("surName", user.getSurName());
            return map;
        }
        return null;
    }

    private List<Map<String, Object>> ingradientsToMap(List<Ingredient> ingredients) {
        if (ingredients != null) {
            List<Map<String, Object>> listOfMap = new ArrayList<>();

            ingredients.forEach(ingredient -> {
                Map<String, Object> map = new HashMap<>();
                map.put("id", ingredient.getId());
                map.put("name", ingredient.getIngredient_name().getName());
                map.put("quantity", ingredient.getValue());
                listOfMap.add(map);
            });
            return listOfMap;
        }
        return null;
    }

    private List<Map<String, Object>> stepsToMap(List<RecipeStep> steps) {
        if (steps != null) {
            List<Map<String, Object>> listOfMap = new ArrayList<>();

            steps.forEach(step -> {
                Map<String, Object> map = new HashMap<>();
                map.put("id", step.getId());
                map.put("stepOrder", step.getStepOrder());
                map.put("text", step.getText());
                listOfMap.add(map);
            });
            return listOfMap;
        }
        return null;
    }

    private List<Map<String, Object>> commentsToMap(List<Comment> comments) {
        if (comments != null) {
            List<Map<String, Object>> listOfMap = new ArrayList<>();

            comments.forEach(comment -> {
                Map<String, Object> map = new HashMap<>();
                map.put("id", comment.getId());
                map.put("text", comment.getText());
                map.put("createdAt", comment.getCreatedAt());
                if (comment.getUser() != null) {
                    map.put("userId", comment.getUser().getId());
                    map.put("username", comment.getUser().getUsername());
                }
                listOfMap.add(map);
            });

            return listOfMap;
        }
        return null;
    }

    public List<Map<String, Object>> getPictures(Integer id) {

        List<Map<String, Object>> response = new ArrayList<>();
        Optional<Recipe> optional = recipeRepository.findByIdNative(id);

        for (int i = 0; i < 8 && optional.isPresent(); ++i) {
            Recipe recipe = optional.get();
            response.add(loadMap(recipe));
            optional = recipeRepository.findByIdNative(recipe.getId());
        }
        return response;
    }

    public List<Map<String, Object>> searchByText(String search) {
        List<Map<String, Object>> response = new ArrayList<>();
        List<Recipe> recipes = recipeRepository.findBySearch(search);

        if (!recipes.isEmpty())
            recipes.forEach(recipe -> response.add(loadMap(recipe)));
        return response;
    }

    public List<Map<String, Object>> searchByTag(String tag) {
        List<Map<String, Object>> response = new ArrayList<>();
        List<Recipe> recipes = recipeRepository.findByTag(tag);

        if (!recipes.isEmpty())
            recipes.forEach(recipe -> response.add(loadMap(recipe)));
        return response;
    }

    private Map<String, Object> loadMap(Recipe recipe) {
        Map<String, Object> map = new HashMap<>();
        map.put("id", recipe.getId());
        map.put("title", recipe.getTitle());
        String description = recipe.getDescription();
        if (description.length() > 100)
            map.put("description", recipe.getDescription().substring(0, 100));
        else
            map.put("description", recipe.getDescription());
        map.put("picture", recipe.getPicture());
        return map;
    }
}
