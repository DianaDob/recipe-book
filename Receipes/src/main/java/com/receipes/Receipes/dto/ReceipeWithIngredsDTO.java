package com.receipes.Receipes.dto;

import java.io.Serializable;
import java.util.List;

import com.receipes.Receipes.model.Ingredient;

public class ReceipeWithIngredsDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private long receipeId;
    private String name;
    private String preparation;
    private List<Ingredient> ingredients;
    
    public long getReceipeId(){
        return receipeId;
    }

    public String getName(){
        return name;
    }

    public String getPreparation(){
        return preparation;
    }

    public List<Ingredient> getIngredients(){
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

    public void setIngredients(List<Ingredient> ingredients){
        this.ingredients = ingredients;
    }

}
