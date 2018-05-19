package elte.projeszk.projeszk_receptek.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "ingredients")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Ingredient extends BaseEntity{

    @ManyToOne(targetEntity = IngredientName.class)
    private IngredientName ingredient_name;

    @ManyToOne(targetEntity = Recipe.class)
    @JoinColumn(name="recipe_id", referencedColumnName="id")
    private Recipe recipe;

    @Column(nullable=false)
    private String value;

}
