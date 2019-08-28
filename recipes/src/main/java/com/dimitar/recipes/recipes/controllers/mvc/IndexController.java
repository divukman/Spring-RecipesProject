package com.dimitar.recipes.recipes.controllers.mvc;

import com.dimitar.recipes.recipes.entities.Category;
import com.dimitar.recipes.recipes.entities.UnitOfMeasure;
import com.dimitar.recipes.recipes.repositories.CategoryRepository;
import com.dimitar.recipes.recipes.repositories.UnitOfMeasureRepository;
import com.dimitar.recipes.recipes.services.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Optional;

@Controller
public class IndexController {

    private final CategoryRepository categoryRepository;
    private final UnitOfMeasureRepository unitOfMeasureRepository;
    private final RecipeService recipeService;

    @Autowired
    public IndexController(final CategoryRepository categoryRepository,
                           final UnitOfMeasureRepository unitOfMeasureRepository,
                           RecipeService recipeService) {
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
        this.recipeService = recipeService;
    }

    @GetMapping({"", "/", "/index"})
    public String getIndexPage(Model model) {

        Optional<Category> categoryOptional = categoryRepository.findByDescription("American");
        Optional<UnitOfMeasure> unitOfMeasureOptional = unitOfMeasureRepository.findByDescription("Teaspoon");

        System.out.println("Cat id is:" + categoryOptional.get().getId());
        System.out.println("UOM id is: " + unitOfMeasureOptional.get().getId());

        model.addAttribute("recipes", recipeService.findAll());


        return "index";
    }

}
