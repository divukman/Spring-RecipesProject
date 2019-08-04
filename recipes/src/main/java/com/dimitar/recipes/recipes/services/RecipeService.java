package com.dimitar.recipes.recipes.services;

import com.dimitar.recipes.recipes.entities.Recipe;
import com.dimitar.recipes.recipes.repositories.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecipeService {

    private final RecipeRepository recipeRepository;

    @Autowired
    public RecipeService(final RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    public Recipe saveRecipe(final Recipe recipe) {
        return recipeRepository.save(recipe);
    }
}
