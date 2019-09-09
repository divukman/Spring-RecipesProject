package com.dimitar.recipes.recipes.controllers.mvc;

import com.dimitar.recipes.recipes.services.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class RecipeController {

    private final RecipeService recipeService;

    @Autowired
    public RecipeController(final RecipeService recipeService) {
        this.recipeService = recipeService;
    }


    @GetMapping("/recipe/show/{id}")
    public String show(@PathVariable String id, Model model) {
        model.addAttribute("recipe", recipeService.findById(Long.valueOf(id)).get());

        return "recipe/show";
    }
}
