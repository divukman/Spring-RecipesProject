package com.dimitar.recipes.recipes.controllers.mvc;

import com.dimitar.recipes.recipes.entities.Recipe;
import com.dimitar.recipes.recipes.repositories.CategoryRepository;
import com.dimitar.recipes.recipes.repositories.RecipeRepository;
import com.dimitar.recipes.recipes.repositories.UnitOfMeasureRepository;
import com.dimitar.recipes.recipes.services.RecipeService;
import com.dimitar.recipes.recipes.services.RecipeServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

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

        final Recipe recipe2 = new Recipe();
        recipe2.setDescription("desc2");
        recipe2.setId(2L);

        recipeSet.add(recipe);
        recipeSet.add(recipe2);

        ArgumentCaptor<Set<Recipe>> argumentCaptor = ArgumentCaptor.forClass(Set.class);

        when(recipeRepository.findAll()).thenReturn(recipeSet);
        final String result = indexController.getIndexPage(model);

        assertEquals(result, "index");
        Mockito.verify(recipeRepository, Mockito.times(1)).findAll();
        Mockito.verify(model, Mockito.times(1)).addAttribute(eq("recipes"), argumentCaptor.capture());

        Set<Recipe> setInController = argumentCaptor.getValue();
        assertEquals(2, setInController.size());
        assertEquals(setInController, recipeSet);
    }

    @Test
    public void testMockMVC() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(indexController).build();

        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("index"));
    }
}