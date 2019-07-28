package com.dimitar.recipes.recipes.entities;

import com.dimitar.recipes.recipes.entities.enums.Difficulty;
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

    @Enumerated(value = EnumType.STRING) //ordinal simply seems bad idea, what if you add more enums in the middle!?!
    private Difficulty difficulty;

    @Lob
    private Byte[] image;

    //@OneToOne(cascade = CascadeType.ALL, mappedBy = "recipe")
    @OneToOne(cascade = CascadeType.ALL) // keeping same as in course, 2 FKs will be present, one in each table
    private Notes notes;
}
