package com.receipes.Receipes.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.receipes.Receipes.model.Ingredient;

@Repository
public interface IngredientRepository extends CrudRepository<Ingredient, Long>{
    
}
