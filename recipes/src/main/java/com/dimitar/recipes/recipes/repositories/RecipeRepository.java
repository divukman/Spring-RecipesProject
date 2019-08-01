package com.dimitar.recipes.recipes.repositories;

import com.dimitar.recipes.recipes.entities.Recipe;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeRepository extends CrudRepository<Recipe, Long> {
}
