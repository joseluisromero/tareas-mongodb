package com.crud.mongodb.repository;

import com.crud.mongodb.model.Tarea;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Date;
import java.util.List;

public interface TareaRepository extends MongoRepository<Tarea, String> {

    Tarea findByNombre(String nombre);

    @Query("{'created' : {$gte : ?0, $lte : ?1}}")
    List<Tarea> findByCreatedBetweenhgf(Date initDate, Date endDate);
}
