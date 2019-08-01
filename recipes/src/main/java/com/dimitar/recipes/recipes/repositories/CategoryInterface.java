package com.dimitar.recipes.recipes.repositories;

import com.dimitar.recipes.recipes.entities.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryInterface extends CrudRepository<Category, Long> {
}
