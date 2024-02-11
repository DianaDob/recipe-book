package com.receipes.Receipes.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Receipe {
    
    @Id
    @SequenceGenerator(name = "seq_recipe", sequenceName = "seq_recipe", allocationSize=1)
    @GeneratedValue(generator = "seq_recipe", strategy = GenerationType.SEQUENCE)
    @Column(name="receipe_id")
    private long receipeId;
    private String name;
    private String preparation;

    
    public Receipe() {
    }

    public Receipe(String name, String preparation) {
        this.name = name;
        this.preparation = preparation;
    }

    public long getReceipeId(){
        return receipeId;
    }

    public String getName() {
        return name;
    }

    public String getPreparation() {
        return preparation;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setPreparation(String preparation){
        this.preparation = preparation;
    }

    @Override
    public String toString() {
        return "Receipe [receipe_id=" + receipeId + ", name=" + name + ", preparation=" + preparation
                + "]";
    }
    

    
    // standard constructors / setters / getters / toString
}
