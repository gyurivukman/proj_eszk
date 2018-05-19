package elte.projeszk.projeszk_receptek.controller;

import elte.projeszk.projeszk_receptek.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/recipe")
public class RecipeController {

    private RecipeService recipeService;

    @Autowired
    public void setRecipeService(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping(value = "/{id}/picture", method = RequestMethod.GET)
    public ResponseEntity<byte[]> getPicture(@PathVariable Integer id) {
        byte[] picture = recipeService.getPicture(id);
        if (picture != null)
            return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(picture);
        else
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
    }
}
