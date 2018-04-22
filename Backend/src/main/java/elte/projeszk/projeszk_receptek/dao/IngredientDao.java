package elte.projeszk.projeszk_receptek.dao;

import elte.projeszk.projeszk_receptek.model.Comment;
import elte.projeszk.projeszk_receptek.model.Ingredient;
import org.hibernate.SessionFactory;

public class IngredientDao extends GenericDaoImpl<Ingredient> {
    public IngredientDao(Class<Ingredient> ingredientClass, SessionFactory sessionFactory) {

        super(ingredientClass, sessionFactory);
    }
}
