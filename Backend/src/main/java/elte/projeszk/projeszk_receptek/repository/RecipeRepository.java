package elte.projeszk.projeszk_receptek.repository;

import elte.projeszk.projeszk_receptek.model.Recipe;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface RecipeRepository extends CrudRepository<Recipe, Integer> {

    Optional<Recipe> findByIdNative(@Param("param") Integer id);

}
