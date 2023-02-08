package com.receipes.Receipes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.receipes.Receipes.model.Receipe;

@Repository
public interface ReceipeRepository extends CrudRepository<Receipe, Long>{

    @Query(value="SELECT DISTINCT r FROM Receipe r JOIN FETCH r.ingredients")
    List<Receipe> findAll();

    Receipe findReceipeByReceipeId(long receipeId);
}
