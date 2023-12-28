package com.receipes.Receipes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.receipes.Receipes.model.Ingredient;
import com.receipes.Receipes.repository.IngredientRepository;

public class IngredientService {

    @Autowired
    IngredientRepository ingredientRepository;

    public List<Ingredient> getIngredientsByReceipeId(long receipeId){
        List<Ingredient> ingredientEntities = ingredientRepository.findAllByReceipeId(receipeId);
        return ingredientEntities;
    }
    
}
