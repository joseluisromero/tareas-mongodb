package com.crud.mongodb.service;

import com.crud.mongodb.model.Tarea;

import java.util.Date;
import java.util.List;

public interface TareaService {
    List<Tarea> getAll();

    List<Tarea> findByCreated(Date initDate, Date endDate);

    Tarea save(Tarea tarea);

    Tarea findByName(String tarea);

    boolean deleteTarea(String id);
}
