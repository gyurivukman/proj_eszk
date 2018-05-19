package elte.projeszk.projeszk_receptek.repository;

import elte.projeszk.projeszk_receptek.model.Recipe;
import org.springframework.data.repository.CrudRepository;

public interface RecipeRepository extends CrudRepository<Recipe, Integer> {
}
