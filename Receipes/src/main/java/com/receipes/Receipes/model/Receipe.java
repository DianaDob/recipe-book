package com.receipes.Receipes.model;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Receipe {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="receipe_id")
    private long receipeId;
    private String name;
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Ingredient> ingredients;
    private String preparation;

    
    public Receipe() {
    }

    public Receipe(String name, List<Ingredient> ingredients, String preparation) {
        this.name = name;
        this.ingredients = ingredients;
        this.preparation = preparation;
    }

    public long getReceipeId(){
        return receipeId;
    }

    public String getName() {
        return name;
    }
    public List<Ingredient> getIngredients() {
        return ingredients;
    }
    public String getPreparation() {
        return preparation;
    }

    @Override
    public String toString() {
        return "Receipe [receipe_id=" + receipeId + ", name=" + name + ", ingredients=" + ingredients + ", preparation=" + preparation
                + "]";
    }
    

    
    // standard constructors / setters / getters / toString
}
