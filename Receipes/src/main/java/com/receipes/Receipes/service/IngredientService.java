package com.receipes.Receipes.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.receipes.Receipes.dto.IngredientDTO;
import com.receipes.Receipes.model.Ingredient;
import com.receipes.Receipes.repository.IngredientRepository;

@Service
public class IngredientService {

    @Autowired
    IngredientRepository ingredientRepository;

    public List<IngredientDTO> getIngredientsByReceipeId(long receipeId){
        List<Ingredient> ingredientEntities = ingredientRepository.findAllByReceipeId(receipeId);
        return createDTOsFromEntites(ingredientEntities);
    }

    public void deleteByReceipeId(long receipeId){
        List<Ingredient> ingredientsToDelete = ingredientRepository.findAllByReceipeId(receipeId);
        ingredientRepository.deleteAll(ingredientsToDelete);
    }

    public void saveIngredsForReceipe(List<IngredientDTO> ingreds, long receipeId){
        List<Ingredient> oldIngredients = ingredientRepository.findAllByReceipeId(receipeId);
        List<Long> newIngredIds = ingreds.stream().map(IngredientDTO::getIngredId).collect(Collectors.toList());
        List<Long>oldIngredIds = oldIngredients.stream().map(Ingredient::getIngredId).collect(Collectors.toList());
        for(long id : oldIngredIds){
            if(!newIngredIds.contains(id)){
                ingredientRepository.deleteById(id);
            }
        }
        for(IngredientDTO i : ingreds){
            ingredientRepository.save(createEntityFromDTO(i, receipeId));          
        }
    }

    private List<IngredientDTO> createDTOsFromEntites(List<Ingredient> entities){
        List<IngredientDTO> dtos = new ArrayList<>();
        for(Ingredient entity: entities){
            IngredientDTO dto = new IngredientDTO();
            dto.setIngredId(entity.getIngredId());
            dto.setReceipeId(entity.getReceipeId());
            dto.setName(entity.getName());
            dto.setQuantity(entity.getQuantity());
            dtos.add(dto);
        }
        return dtos;
    }

    private Ingredient createEntityFromDTO(IngredientDTO dto, long receipeId){
        Ingredient entity = new Ingredient();
        entity.setIngredId(dto.getIngredId());
        entity.setName(dto.getName());
        entity.setQuantity(dto.getQuantity());
        entity.setReceipeId(receipeId);
        return entity;
    }
    
}
