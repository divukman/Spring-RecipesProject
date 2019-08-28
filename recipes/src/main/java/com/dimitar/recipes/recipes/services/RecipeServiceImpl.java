package com.dimitar.recipes.recipes.services;

import com.dimitar.recipes.recipes.entities.Recipe;
import com.dimitar.recipes.recipes.repositories.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class RecipeServiceImpl implements RecipeService{

    private final RecipeRepository recipeRepository;

    @Autowired
    public RecipeServiceImpl(final RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    public Recipe save(final Recipe recipe) {
        return recipeRepository.save(recipe);
    }


    @Override
    public Set<Recipe> findAll() {
        final HashSet<Recipe> set = new HashSet<>();
        recipeRepository.findAll().forEach(set::add);
        return set;
    }
}
