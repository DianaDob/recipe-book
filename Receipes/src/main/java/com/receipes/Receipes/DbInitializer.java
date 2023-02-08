package com.receipes.Receipes;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.receipes.Receipes.model.Receipe;
import com.receipes.Receipes.model.Ingredient;
import com.receipes.Receipes.repository.ReceipeRepository;

@Component
public class DbInitializer {

    @Autowired
    ReceipeRepository receipeRepository;
    
    @PostConstruct
    public void init() {
        List<Ingredient> kaposztaIngreds = new ArrayList<Ingredient>();
        Ingredient kaposzta = new Ingredient("1 fej", "káposzta");
        Ingredient teszta = new Ingredient("20 dkg", "tészta");
        kaposztaIngreds.add(kaposzta);
        kaposztaIngreds.add(teszta);

        List<Ingredient> salataIngreds = new ArrayList<Ingredient>();
        salataIngreds.add(new Ingredient("2 db", "paradicsom"));
        salataIngreds.add(new Ingredient("1 db", "uborka"));
        salataIngreds.add(new Ingredient("1 marék", "olajbogyó"));
        salataIngreds.add(new Ingredient("10 dkg", "fetasajt"));

		Receipe receipe1 = new Receipe("káposztás tészta", 
								kaposztaIngreds, 
								"Főzd meg a tésztát és keverd össze a dinsztelt káposztával.");						
								
		Receipe receipe2 = new Receipe("görög saláta", 
								salataIngreds, 
								"Vágd fel a zöldségeket és a fetasajtot kockákra. Keverd össze az olajbogyóval.");
        receipeRepository.save(receipe1);
		receipeRepository.save(receipe2);

        receipeRepository.findAll().forEach(System.out::println);
    }
}
