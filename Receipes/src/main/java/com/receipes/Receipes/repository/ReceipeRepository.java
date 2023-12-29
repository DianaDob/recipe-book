package com.receipes.Receipes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.receipes.Receipes.model.Receipe;

@Repository
public interface ReceipeRepository extends CrudRepository<Receipe, Long>{

    List<Receipe> findAll();

    Receipe findReceipeByReceipeId(long receipeId);
}
