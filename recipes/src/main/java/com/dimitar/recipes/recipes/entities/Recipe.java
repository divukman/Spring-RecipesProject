package com.dimitar.recipes.recipes.entities;

import com.dimitar.recipes.recipes.entities.enums.Difficulty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    public String description;

    private Integer prepTime;
    private Integer cookTime;
    private Integer servings;
    private String source;
    private String url;

    @Lob
    private String directions;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "recipe")
    private Set<Ingredient> ingredients = new HashSet<>();

    @Enumerated(value = EnumType.STRING) //ordinal simply seems bad idea, what if you add more enums in the middle!?!
    private Difficulty difficulty;

    @Lob
    private Byte[] image;

    //@OneToOne(cascade = CascadeType.ALL, mappedBy = "recipe")
    @OneToOne(cascade = CascadeType.ALL) // keeping same as in course, 2 FKs will be present, one in each table
    private Notes notes;

    @ManyToMany
    @JoinTable(name = "recipe_category",
            joinColumns = @JoinColumn(name = "recipe_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    private Set<Category> categories = new HashSet<>();
}
