package elte.projeszk.projeszk_receptek.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "votes",uniqueConstraints={@UniqueConstraint(columnNames={"recipe_id","user_id"})})
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Vote extends BaseEntity{

    @Column(nullable=false)
    private boolean hasLiked;

    @ManyToOne(targetEntity = Recipe.class)
    @JoinColumn(name="recipe_id", referencedColumnName="id")
    private Recipe recipe;

    @ManyToOne(targetEntity=User.class)
    @JoinColumn(name="user_id",referencedColumnName="id")
    private User user;

}
