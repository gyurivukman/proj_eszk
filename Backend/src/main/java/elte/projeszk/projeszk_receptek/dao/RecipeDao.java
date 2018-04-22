package elte.projeszk.projeszk_receptek.dao;

import elte.projeszk.projeszk_receptek.model.Recipe;
import org.hibernate.SessionFactory;

import java.util.List;

public class RecipeDao extends GenericDaoImpl<Recipe> {
    public RecipeDao(Class<Recipe> recipeClass, SessionFactory sessionFactory) {

        super(recipeClass, sessionFactory);
    }

    public List<Recipe> getAllRecipeToUser(Integer recipeId) {
        return null;
    }
}
