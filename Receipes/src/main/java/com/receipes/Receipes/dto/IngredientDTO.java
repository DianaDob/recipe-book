package com.receipes.Receipes.dto;

import java.io.Serializable;

public class IngredientDTO implements Serializable{

    private static final long serialVersionUID = 1L;

    private long ingredId;
    private String quantity;
    private String name;
    private long receipeId;

    public IngredientDTO(){
    }

    public String getQuantity(){
        return quantity;
    }
    
    public String getName(){
        return name;
    }

    public long getReceipeId(){
        return receipeId;
    }

    public long getIngredId(){
        return this.ingredId;
    }

    public void setIngredId(long ingredId){
        this.ingredId = ingredId;
    }

    public void setQuantity(String quantity){
        this.quantity = quantity;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setReceipeId(long receipeId) {
        this.receipeId = receipeId;
    }
}
