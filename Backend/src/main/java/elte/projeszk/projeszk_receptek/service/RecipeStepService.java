package elte.projeszk.projeszk_receptek.service;

import elte.projeszk.projeszk_receptek.dao.RecipeStepDao;
import elte.projeszk.projeszk_receptek.model.RecipeStep;
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
public class RecipeStepService extends AbstractService<RecipeStep> {
    @Autowired
    RecipeStepDao recipeStepDao;

    public List<RecipeStep> getAllRecipeStepToRecipe(Integer userId) {
        return recipeStepDao.getAllRecipeStepToRecipe(userId);
    }
}
