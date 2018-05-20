package elte.projeszk.projeszk_receptek.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "featured_recipes",uniqueConstraints = @UniqueConstraint(columnNames = {"recipe_id"}))
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class FeaturedRecipe extends BaseEntity{

    @OneToOne(targetEntity=Recipe.class)
    @JoinColumn(name="recipe_id", referencedColumnName="id")
    private Recipe recipe;
}
