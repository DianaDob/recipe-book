package com.receipes.Receipes.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.receipes.Receipes.model.Ingredient;

@Repository
public interface IngredientRepository extends CrudRepository<Ingredient, Long>{

    List<Ingredient> findAllByReceipeId(long receipeId);
    
}
