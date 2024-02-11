package com.receipes.Receipes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.receipes.Receipes.dto.ReceipeWithIngredsDTO;
import com.receipes.Receipes.model.Receipe;
import com.receipes.Receipes.repository.IngredientRepository;
import com.receipes.Receipes.repository.ReceipeRepository;
import com.receipes.Receipes.service.ReceipeService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class ReceipeController {

    // standard constructors
    @Autowired
    ReceipeRepository receipeRepository;
    @Autowired
    IngredientRepository ingredientRepository;
    @Autowired
    ReceipeService receipeService;
    private static final Logger logger = LoggerFactory.getLogger(ReceipeController.class);

    @GetMapping("/receipes")
    @CrossOrigin
    public List<ReceipeWithIngredsDTO> getReceipes() {
        List<ReceipeWithIngredsDTO> allReceipes = receipeService.findAll();
        return allReceipes;
    }

    @GetMapping("/receipe/{receipeId}")
    @CrossOrigin
    public ReceipeWithIngredsDTO getReceipe(@PathVariable long receipeId) {
        ReceipeWithIngredsDTO receipe = receipeService.findReceipeByReceipeId(receipeId);
        logger.info("Got recipe: {}: {}", receipeId, receipe);
        return receipe;
    }

    @PostMapping("/add_receipe")
    @CrossOrigin
    public void addUpdateReceipe(@RequestBody ReceipeWithIngredsDTO receipe) {
        logger.info("Saving recipe: {}", receipe);
        try{
            receipeService.save(receipe);
            //ingredientRepository.
            
        }
        catch(Exception e){
            logger.error("Error while saving recipe: ", e);
        }
    }

    /* @PutMapping("/update/receipe")
    @CrossOrigin
    public void updateReceipe(@RequestBody Receipe receipe){
        logger.info("Updating recipe: {}", receipe);
        try{
            receipeRepository.save(receipe);
        }
        catch(Exception e){
            logger.error("Error while updating recipe: ", e);
        }
    } */

    @DeleteMapping("/delete/receipe/{receipeId}")
    @CrossOrigin
    public void deleteReceipe(@PathVariable long receipeId) {
        try{
            receipeService.deleteById(receipeId);
            logger.info("Recipe with id {} deleted", receipeId);
        }
        catch(Exception e){
            logger.error("Error while deleting recipe with id: {}, {}", receipeId, e);
        }
        
    }

}
