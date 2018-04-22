package elte.projeszk.projeszk_receptek.controller;

import elte.projeszk.projeszk_receptek.exception.DataNotValidException;
import elte.projeszk.projeszk_receptek.exception.DuplicatedDataException;
import elte.projeszk.projeszk_receptek.exception.MissingDataException;
import elte.projeszk.projeszk_receptek.model.Comment;
import elte.projeszk.projeszk_receptek.model.Recipe;
import elte.projeszk.projeszk_receptek.model.RecipeStep;
import elte.projeszk.projeszk_receptek.service.RecipeStepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recipeSteps")
public class RecipeStepController implements ControllerInterface<RecipeStep> {

    @Autowired
    private RecipeStepService recipeStepService;

    @Override
    @PutMapping("/update")
    public void update(@RequestBody RecipeStep recipeStep) {

        try {
            recipeStepService.update(recipeStep);
        } catch (DataNotValidException e) {

        }
    }

    @Override
    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Integer id) {
        try {
            recipeStepService.deleteById(id);
        } catch (DataNotValidException | MissingDataException e) {

        }
    }

    @Override
    @DeleteMapping("/delete")
    public void delete(RecipeStep recipeStep) {
        try {
            recipeStepService.delete(recipeStep);
        } catch (DataNotValidException e) {

        }
    }

    @Override
    @PostMapping("/create")
    public void create(@RequestBody RecipeStep recipeStep) {
        try {
            recipeStepService.create(recipeStep);
        } catch (DuplicatedDataException e) {

        }
    }

    @GetMapping("/{id}")
    public RecipeStep get(@PathVariable Integer id) {
        return recipeStepService.get(id);
    }

    @GetMapping("/getall")
    public List<RecipeStep> getAll() {
        return recipeStepService.getAll();
    }

    @GetMapping("/getAllToRecipe/{recipeId}")
    public List<RecipeStep> getAllToRecipe(@PathVariable Integer recipeId) {
        return recipeStepService.getAllRecipeStepToRecipe(recipeId);
    }
}
