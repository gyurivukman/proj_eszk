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

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name="user_id", referencedColumnName="id")
    private User user;

    @OneToMany(mappedBy="recipe", targetEntity = Ingredient.class,fetch = FetchType.LAZY)
    private List<Ingredient> ingredients;

    @OneToMany(targetEntity = RecipeStep.class, mappedBy="recipe")
    private List<RecipeStep> steps;

    @OneToMany(mappedBy="recipe", targetEntity = Comment.class, fetch = FetchType.LAZY)
    private List<Comment> comments;

    @Column(nullable=true)
    private int upvotes;

    @Column(nullable=true)
    private int downvotes;

    @ManyToMany
    @JoinTable(name="recipes_tags",
            joinColumns=@JoinColumn(name="tag_id"),
            inverseJoinColumns=@JoinColumn(name="recipe_id"))
    private List<Tag> tags;
}
