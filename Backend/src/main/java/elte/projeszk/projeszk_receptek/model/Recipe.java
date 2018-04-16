package elte.projeszk.projeszk_receptek.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "recipes")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Recipe extends BaseEntity {

    @Column(nullable = false, unique = true)
    private String title;

    @Column(nullable = false, unique = true, length = 1000)
    private String description;

    @Lob
    @Column(nullable = true, length = 1536)
    private byte[] picture;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Min(1)@Max(5)
    @Column(nullable=false)
    private int rating=5;

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name="user_id", referencedColumnName="id")
    private User user;

    @ManyToMany
    @JoinTable(name="recipes_ingredients",
            joinColumns=@JoinColumn(name="ingredient_id"),
            inverseJoinColumns=@JoinColumn(name="recipe_id"))
    private List<Ingredient> ingredients;

    @OneToMany(targetEntity = RecipeStep.class, mappedBy="recipe")
    private List<RecipeStep> steps;

    @OneToMany(mappedBy="recipe", targetEntity = Comment.class, fetch = FetchType.LAZY)
    private List<Comment> comments;

}
