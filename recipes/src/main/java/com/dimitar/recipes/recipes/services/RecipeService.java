package com.dimitar.recipes.recipes.services;

import com.dimitar.recipes.recipes.entities.Recipe;

import java.util.Set;

public interface RecipeService {
    Recipe save(Recipe recipe);
    Set<Recipe> findAll();
}
