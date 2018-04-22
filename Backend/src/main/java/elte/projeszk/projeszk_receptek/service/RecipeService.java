package elte.projeszk.projeszk_receptek.service;

import elte.projeszk.projeszk_receptek.dao.RecipeDao;
import elte.projeszk.projeszk_receptek.model.Comment;
import elte.projeszk.projeszk_receptek.model.Recipe;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Service
@SessionScope
@Data
public class RecipeService extends AbstractService<Recipe> {
    @Autowired
    RecipeDao recipeDao;

    public List<Recipe> getAllRecipeToUser(Integer userId) {
        return recipeDao.getAllRecipeToUser(userId);
    }
}
