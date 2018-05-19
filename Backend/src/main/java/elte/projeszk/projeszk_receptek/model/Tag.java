package elte.projeszk.projeszk_receptek.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tags")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Tag extends BaseEntity{

    private String name;

    @ManyToMany
    @JoinTable(name="recipes_tags",
            joinColumns=@JoinColumn(name="recipe_id"),
            inverseJoinColumns=@JoinColumn(name="tag_id ")
    )
    private List<Recipe> recipes;
}
