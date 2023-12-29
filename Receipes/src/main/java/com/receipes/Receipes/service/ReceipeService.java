package com.receipes.Receipes.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.receipes.Receipes.dto.ReceipeWithIngredsDTO;
import com.receipes.Receipes.model.Receipe;
import com.receipes.Receipes.repository.ReceipeRepository;

@Service
public class ReceipeService {

    @Autowired
    ReceipeRepository receipeRepository;
    @Autowired
    IngredientService ingredientService;


    public List<ReceipeWithIngredsDTO> findAll() {
        List<Receipe> allEntities = receipeRepository.findAll();
        List<ReceipeWithIngredsDTO> dtos = new ArrayList<>();
        for(Receipe receipe : allEntities){
            dtos.add(createReceipeDTOFromEntity(receipe));
        }
        return dtos;
    }

    public ReceipeWithIngredsDTO findReceipeByReceipeId(long receipeId){
        Receipe entity = receipeRepository.findReceipeByReceipeId(receipeId);
        return createReceipeDTOFromEntity(entity);
    };

    public void save(ReceipeWithIngredsDTO dto){
        Receipe entity = receipeRepository.findReceipeByReceipeId(dto.getReceipeId());
        if(entity == null){
            entity = createReceipeEntityFromDTO(dto);
        }
        receipeRepository.save(entity);        
        ingredientService.saveIngredsForReceipe(dto.getIngredients(), entity.getReceipeId());

    }

    private ReceipeWithIngredsDTO createReceipeDTOFromEntity(Receipe receipe){
        ReceipeWithIngredsDTO dto = new ReceipeWithIngredsDTO();
        dto.setReceipeId(receipe.getReceipeId());
        dto.setName(receipe.getName());
        dto.setPreparation(receipe.getPreparation());
        dto.setIngredients(ingredientService.getIngredientsByReceipeId(receipe.getReceipeId()));
        return dto;
    }

    private Receipe createReceipeEntityFromDTO(ReceipeWithIngredsDTO dto){
        return new Receipe(dto.getName(), dto.getPreparation());
    }
    
}
