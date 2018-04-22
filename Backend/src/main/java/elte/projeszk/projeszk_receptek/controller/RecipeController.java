package elte.projeszk.projeszk_receptek.controller;

import elte.projeszk.projeszk_receptek.exception.DataNotValidException;
import elte.projeszk.projeszk_receptek.exception.DuplicatedDataException;
import elte.projeszk.projeszk_receptek.exception.MissingDataException;
import elte.projeszk.projeszk_receptek.model.Comment;
import elte.projeszk.projeszk_receptek.model.Recipe;
import elte.projeszk.projeszk_receptek.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recipes")
public class RecipeController implements ControllerInterface<Recipe> {

    @Autowired
    private RecipeService recipeService;

    @Override
    @PutMapping("/update")
    public void update(@RequestBody Recipe recipe) {

        try {
            recipeService.update(recipe);
        } catch (DataNotValidException e) {

        }
    }

    @Override
    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Integer id) {
        try {
            recipeService.deleteById(id);
        } catch (DataNotValidException | MissingDataException e) {

        }
    }

    @Override
    @DeleteMapping("/delete")
    public void delete(Recipe recipe) {
        try {
            recipeService.delete(recipe);
        } catch (DataNotValidException e) {

        }
    }

    @Override
    @PostMapping("/create")
    public void create(@RequestBody Recipe recipe) {
        try {
            recipeService.create(recipe);
        } catch (DuplicatedDataException e) {

        }
    }

    @GetMapping("/{id}")
    public Recipe get(@PathVariable Integer id) {
        return recipeService.get(id);
    }

    @GetMapping("/getall")
    public List<Recipe> getAll() {
        return recipeService.getAll();
    }

    @GetMapping("/getAllToUser/{userId}")
    public List<Recipe> getAllToUser(@PathVariable Integer userId) {

        return recipeService.getAllRecipeToUser(userId);
    }
}
