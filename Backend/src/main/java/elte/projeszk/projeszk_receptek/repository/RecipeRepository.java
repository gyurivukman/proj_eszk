package elte.projeszk.projeszk_receptek.repository;

import elte.projeszk.projeszk_receptek.model.Recipe;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface RecipeRepository extends CrudRepository<Recipe, Integer> {

    @Query(
            value = "SELECT * FROM proj_eszk.recipes WHERE id = (SELECT min(id) FROM proj_eszk.recipes WHERE id > :param)",
            nativeQuery = true
    )
    Optional<Recipe> findByIdNative(@Param("param") Integer id);

    @Query(
            value = "SELECT * FROM proj_eszk.recipes WHERE title like %:search% OR id IN " +
                    "(SELECT recipe_id FROM proj_eszk.ingredients INNER JOIN proj_eszk.ingredient_names ON ingredients.id = ingredient_names.id WHERE name like %:search%)",
            nativeQuery = true
    )
    List<Recipe> findBySearch(@Param("search") String search);

    @Query(
            value = "SELECT * FROM proj_eszk.recipes " +
                    "INNER JOIN \tproj_eszk.recipes_tags ON recipes.id = recipes_tags.recipe_id " +
                    "INNER JOIN proj_eszk.tags ON tags.id = recipes_tags.tag_id WHERE name like %:tag%",
            nativeQuery = true
    )
    List<Recipe> findByTag(@Param("tag") String tag);
}
