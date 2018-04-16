package elte.projeszk.projeszk_receptek.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "steps")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class RecipeStep extends BaseEntity{
    // needs a unique constraint to ensure the cooking step order is unique for a given recipe.
    @Column(nullable=false)
    private int stepOrder;

    @Column(nullable = false, length = 1000)
    private String text;

    @ManyToOne(targetEntity = Recipe.class)
    @JoinColumn(name="recipe_id",referencedColumnName="id")
    private Recipe recipe;

}
