package elte.projeszk.projeszk_receptek.service;

import elte.projeszk.projeszk_receptek.model.Ingredient;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

@EqualsAndHashCode(callSuper = true)
@Service
@SessionScope
@Data
public class IngredientService extends AbstractService<Ingredient> {
}
