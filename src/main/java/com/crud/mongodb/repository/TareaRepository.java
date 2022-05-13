package com.crud.mongodb.repository;

import com.crud.mongodb.model.Tarea;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TareaRepository extends MongoRepository<Tarea, String> {

    Tarea findByNombre(String nombre);
}
