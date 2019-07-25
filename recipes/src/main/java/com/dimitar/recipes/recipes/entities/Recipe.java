package com.dimitar.recipes.recipes.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public String description;
    private Integer prepTime;
    private Integer cookTime;
    private Integer servings;
    private String source;
    private String url;
    private String directions;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "recipe")
    private Set<Ingredient> ingredients;

    //@todo: add
    //private Difficulty difficulty;

    @Lob
    private Byte[] image;

    //@OneToOne(cascade = CascadeType.ALL, mappedBy = "recipe")
    @OneToOne(cascade = CascadeType.ALL) // keeping same as in course, 2 FKs will be present, one in each table
    private Notes notes;
}
