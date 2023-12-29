package com.receipes.Receipes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.receipes.Receipes.model.Ingredient;
import com.receipes.Receipes.repository.IngredientRepository;

@Service
public class IngredientService {

    @Autowired
    IngredientRepository ingredientRepository;

    public List<Ingredient> getIngredientsByReceipeId(long receipeId){
        List<Ingredient> ingredientEntities = ingredientRepository.findAllByReceipeId(receipeId);
        return ingredientEntities;
    }

    public void saveIngredsForReceipe(List<Ingredient> ingreds, long receipeId){
        for(Ingredient i : ingreds){
            i.setReceipeId(receipeId);
            ingredientRepository.save(i);
        }
    }
    
}
