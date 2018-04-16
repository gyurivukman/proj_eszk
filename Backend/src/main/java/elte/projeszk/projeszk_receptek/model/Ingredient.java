package elte.projeszk.projeszk_receptek.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "ingredients")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Ingredient extends BaseEntity{

    @Column(unique=true,nullable=false)
    private String name;

    @ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(name="recipes_ingredients",
            joinColumns=@JoinColumn(name="recipe_id"),
            inverseJoinColumns=@JoinColumn(name="ingredient_id ")
    )
    private List<Recipe> recipes;

}
