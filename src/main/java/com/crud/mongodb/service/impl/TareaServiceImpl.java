package com.crud.mongodb.service.impl;

import com.crud.mongodb.model.Tarea;
import com.crud.mongodb.repository.TareaRepository;
import com.crud.mongodb.service.TareaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TareaServiceImpl implements TareaService {
    @Autowired
    private TareaRepository tareaRepository;

    @Override
    public List<Tarea> getAll() {
        return tareaRepository.findAll();
    }

    @Override
    public Tarea save(Tarea tarea) {
        return tareaRepository.save(tarea);
    }

    @Override
    public Tarea findByName(String tarea) {
        return tareaRepository.findByNombre(tarea);
    }

    @Override
    public boolean deleteTarea(String id) {
        boolean res = false;
        try {

            Optional<Tarea> exis = tareaRepository.findById(id);
            if (exis.isPresent()) {
                tareaRepository.delete(exis.get());
                res = true;
            } else {
                res = false;
            }


        } catch (Exception e) {
            res = false;
        }
        return res;
    }
}
