package com.crud.mongodb.controller;

import com.crud.mongodb.model.Tarea;
import com.crud.mongodb.service.TareaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/tareas")
public class TareaController {
    @Autowired
    private TareaService tareaService;

    @GetMapping("/")
    List<Tarea> index() {
        return tareaService.getAll();
    }

    @GetMapping(value = "/findBy")
    List<Tarea> findByDate(@RequestParam("initDate") Date initDate, @RequestParam("endDate") Date endDate) {
        return tareaService.findByCreated(initDate,endDate);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/create")
    Tarea create(@RequestBody Tarea tarea) {
        return tareaService.save(tarea);
    }

    @PutMapping("/update")
    Tarea update(@RequestBody Tarea tarea) {
        return tareaService.save(tarea);
    }


    @DeleteMapping("/delete")
    ResponseEntity<Tarea> delete(@RequestParam(value = "id") String id) {
        boolean result = tareaService.deleteTarea(id);
        if (result) {
            return new ResponseEntity<Tarea>(HttpStatus.OK);
        } else {
            return new ResponseEntity<Tarea>(HttpStatus.NOT_FOUND);
        }
    }
}
