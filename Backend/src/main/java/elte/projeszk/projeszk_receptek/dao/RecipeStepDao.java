package elte.projeszk.projeszk_receptek.dao;

import elte.projeszk.projeszk_receptek.model.RecipeStep;
import org.hibernate.SessionFactory;

import java.util.List;

public class RecipeStepDao extends GenericDaoImpl<RecipeStep> {
    public RecipeStepDao(Class<RecipeStep> recipeStepClass, SessionFactory sessionFactory) {

        super(recipeStepClass, sessionFactory);
    }

    public List<RecipeStep> getAllRecipeStepToRecipe(Integer recipeId) {
        return null;
    }
}
