package com.receipes.Receipes.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long ingred_id;
    private String quantity;
    private String name;

    public Ingredient(){
    }

    public Ingredient (String quantity, String name){
        this.quantity = quantity;
        this.name = name;
    }

    public String getQuantity(){
        return quantity;
    }
    
    public String getName(){
        return name;
    }
}
