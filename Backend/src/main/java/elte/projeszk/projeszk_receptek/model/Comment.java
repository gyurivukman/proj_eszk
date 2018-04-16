package elte.projeszk.projeszk_receptek.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "comments")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Comment extends BaseEntity{

    @Column(nullable=false,length=1000)
    private String text;

    @ManyToOne(targetEntity = Recipe.class)
    @JoinColumn(name="recipe_id",referencedColumnName="id")
    private Recipe recipe;

    @ManyToOne(targetEntity = User.class)
    private User user;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
}
