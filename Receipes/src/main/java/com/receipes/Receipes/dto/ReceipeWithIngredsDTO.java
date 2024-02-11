package com.receipes.Receipes.dto;

import java.io.Serializable;
import java.util.List;

import com.receipes.Receipes.dto.IngredientDTO;

public class ReceipeWithIngredsDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private long receipeId;
    private String name;
    private String preparation;
    private List<IngredientDTO> ingredients;
    
    public long getReceipeId(){
        return receipeId;
    }

    public String getName(){
        return name;
    }

    public String getPreparation(){
        return preparation;
    }

    public List<IngredientDTO> getIngredients(){
        return ingredients;
    }

    public void setReceipeId(long receipeId){
        this.receipeId = receipeId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPreparation(String preparation){
        this.preparation = preparation;
    }

    public void setIngredients(List<IngredientDTO> ingredients){
        this.ingredients = ingredients;
    }

}
