package com.receipes.Receipes.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Ingredient {
    @Id
    @SequenceGenerator(name = "seq_ingredient", sequenceName = "seq_ingredient")
    @GeneratedValue(generator = "seq_ingredient", strategy = GenerationType.SEQUENCE)
    @Column(name="ingred_id")
    private long ingredId;
    private String quantity;
    private String name;
    private long receipeId;

    public Ingredient(){
    }

    /*public Ingredient (long ingredId, String quantity, String name, long receipeId){
        this.ingredId = ingredId;
        this.quantity = quantity;
        this.name = name;
        this.receipeId = receipeId;
    }*/

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
        return ingredId;
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
