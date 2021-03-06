package elte.projeszk.projeszk_receptek.controller;

import elte.projeszk.projeszk_receptek.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/recipe")
public class RecipeController {

    private RecipeService recipeService;

    @Autowired
    public void setRecipeService(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getRecipe(@PathVariable Integer id) {
        Map<String, Object> response = recipeService.getRecipe(id);

        if (response.isEmpty())
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        else
            return ResponseEntity.ok(response);
    }

    @RequestMapping(value = "/{id}/picture", method = RequestMethod.GET)
    public ResponseEntity<byte[]> getPicture(@PathVariable Integer id) {
        byte[] picture = recipeService.getPicture(id);
        if (picture != null)
            return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(picture);
        else
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> getPictures(@RequestParam("id") Integer id) {
        List<Map<String, Object>> response = recipeService.getPictures(id);

        if (response.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        else
            return ResponseEntity.ok(response);
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public ResponseEntity<?> searchByText(@RequestParam("search") String search) {
        List<Map<String, Object>> response = recipeService.searchByText(search);

        if (response.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        else
            return ResponseEntity.ok(response);
    }

    @RequestMapping(value = "/tag", method = RequestMethod.POST)
    public ResponseEntity<?> searchByTag(@RequestParam("tag") String tag) {
        List<Map<String, Object>> response = recipeService.searchByTag(tag);

        if (response.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        else
            return ResponseEntity.ok(response);
    }
}
