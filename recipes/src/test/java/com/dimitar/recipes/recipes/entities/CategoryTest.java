package com.dimitar.recipes.recipes.entities;

import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class CategoryTest {

    Category category;

    @Before
    public void setUp() {
        category = new Category();

    }

    @Test
    public void getId() {
        final Long idValue = Long.valueOf(4);
        category.setId(idValue);
        assertEquals(idValue, category.getId());
    }

    @Test
    public void getDescription() {
        final String desc = "This is a description";
        category.setDescription(desc);
        assertEquals(desc, category.getDescription());
    }

    @Test
    public void getRecipes() {
        final Recipe recipe1 = new Recipe();
        recipe1.setId(1L);
        recipe1.setDescription("Recipe 1");

        final Set<Recipe> recipes = new HashSet<>();
        recipes.add(recipe1);

        category.setRecipes(recipes);

        assertNotNull(category.getRecipes());
    }
}