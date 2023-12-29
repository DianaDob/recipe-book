package com.receipes.Receipes.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Ingredient {
    @Id
    @SequenceGenerator(name = "seq_ingredient", sequenceName = "\"seq_ingredient\"")
    @GeneratedValue(generator = "seq_ingredient", strategy = GenerationType.SEQUENCE)
    private long ingred_id;
    private String quantity;
    private String name;
    private long receipeId;

    public Ingredient(){
    }

    public Ingredient (String quantity, String name, long receipeId){
        this.quantity = quantity;
        this.name = name;
        this.receipeId = receipeId;
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

    public void setReceipeId(long receipeId) {
        this.receipeId = receipeId;
    }
}
