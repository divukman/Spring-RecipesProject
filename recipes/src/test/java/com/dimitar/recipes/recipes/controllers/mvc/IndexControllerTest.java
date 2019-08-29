package com.dimitar.recipes.recipes.controllers.mvc;

import com.dimitar.recipes.recipes.entities.Recipe;
import com.dimitar.recipes.recipes.repositories.CategoryRepository;
import com.dimitar.recipes.recipes.repositories.RecipeRepository;
import com.dimitar.recipes.recipes.repositories.UnitOfMeasureRepository;
import com.dimitar.recipes.recipes.services.RecipeService;
import com.dimitar.recipes.recipes.services.RecipeServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class IndexControllerTest {

    @Mock
    CategoryRepository categoryRepository;

    @Mock
    UnitOfMeasureRepository unitOfMeasureRepository;

    @Mock
    RecipeRepository recipeRepository;

    @Mock
    Model model;

    RecipeService recipeService;
    IndexController indexController;


    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        recipeService = new RecipeServiceImpl(recipeRepository);
        indexController = new IndexController(categoryRepository, unitOfMeasureRepository, recipeService);
    }


    @Test
    public void getIndexPage() {
        final Set<Recipe> recipeSet = new HashSet<>();
        final Recipe recipe = new Recipe();
        recipe.setDescription("desc");
        recipe.setId(1L);
        recipeSet.add(recipe);

        Mockito.when(recipeRepository.findAll()).thenReturn(recipeSet);
        final String result = indexController.getIndexPage(model);
        assertEquals(result, "index");
        Mockito.verify(recipeRepository, Mockito.times(1)).findAll();
    }
}