package elte.projeszk.projeszk_receptek.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.List;

@Entity
@Table(name = "users",uniqueConstraints={@UniqueConstraint(columnNames={"username","email"})})
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class User extends BaseEntity {

    @Column(nullable=false, unique=true, length=18)
    private String username;

    @Column(nullable=false)
    private String foreName;

    @Column(nullable=false)
    private String surName;

    @Column(nullable=false,unique=true,length=100)
    @Email
    private String email;

    //proposal: use a one-way algorithm like PBKDF2 + salt it with some unique hash.
    @Column(nullable=false)
    private String password;

    @OneToMany(mappedBy="user", targetEntity = Recipe.class, fetch = FetchType.LAZY)
    private List<Recipe> recipes;

    @OneToMany(targetEntity=Comment.class, mappedBy="user", fetch = FetchType.LAZY)
    private List<Comment> comments;

    @Lob
    @Column(nullable = true, length = 1536)
    private byte[] avatar;

}
