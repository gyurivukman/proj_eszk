package elte.projeszk.projeszk_receptek.controller;

import elte.projeszk.projeszk_receptek.exception.DataNotValidException;
import elte.projeszk.projeszk_receptek.exception.DuplicatedDataException;
import elte.projeszk.projeszk_receptek.exception.MissingDataException;
import elte.projeszk.projeszk_receptek.model.Ingredient;
import elte.projeszk.projeszk_receptek.service.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ingredients")

public class IngredientController implements ControllerInterface<Ingredient> {

    @Autowired
    private IngredientService ingredientService;

    @Override
    @PutMapping("/update")
    public void update(@RequestBody Ingredient ingredient) {

        try {
            ingredientService.update(ingredient);
        } catch (DataNotValidException e) {

        }
    }

    @Override
    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Integer id) {
        try {
            ingredientService.deleteById(id);
        } catch (DataNotValidException | MissingDataException e) {

        }
    }

    @Override
    @DeleteMapping("/delete")
    public void delete(Ingredient ingredient) {
        try {
            ingredientService.delete(ingredient);
        } catch (DataNotValidException e) {

        }
    }

    @Override
    @PostMapping("/create")
    public void create(@RequestBody Ingredient ingredient) {
        try {
            ingredientService.create(ingredient);
        } catch (DuplicatedDataException e) {

        }
    }

    @GetMapping("/{id}")
    public Ingredient get(@PathVariable Integer id) {
        return ingredientService.get(id);
    }


    @GetMapping("/getall")
    public List<Ingredient> getAll() {
        return ingredientService.getAll();
    }
}

